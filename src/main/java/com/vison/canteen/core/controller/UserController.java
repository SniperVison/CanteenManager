package com.vison.canteen.core.controller;

import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.UserDTO;
import com.vison.canteen.core.bean.DTO.UserInfoDTO;
import com.vison.canteen.core.bean.PO.UserInfoPO;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.bean.VO.UserVO;
import com.vison.canteen.core.exception.CanteenException;
import com.vison.canteen.core.service.UserInfoService;
import com.vison.canteen.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/3 22:12
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Value("${tmpLocation}")
    private String tmpLocation;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("get-all-user")
    public List<UserVO> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("list")
    public ModelAndView userView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        UserPO user = (UserPO) session.getAttribute("user");
        request.setAttribute("user", user);
        model.setViewName("user");
        return model;
    }

    @GetMapping("get-user-by-id")
    public UserVO getUserById(String id) {
        Long userId = LongUtils.StringToLong(id);
        return userService.getUserById(userId);
    }

    @PostMapping("delete-user-by-id")
    public Boolean deleteUserById(String id) {
        Long userId = LongUtils.StringToLong(id);
        return userService.deleteUserById(userId);
    }

    @PostMapping("update-user")
    public Boolean updateUser(@RequestBody UserDTO userDTO) throws CanteenException {
        return userService.updateUserById(userDTO);
    }

    @PostMapping("delete-user-by-ids")
    public Boolean deleteUserByIds(@RequestBody List<String> ids) {
        List<Long> idList = ids.parallelStream().map(e -> LongUtils.StringToLong(e)).collect(Collectors.toList());
        return userService.deleteUserByIds(idList);
    }

    @GetMapping("user-info")
    public ModelAndView userInfoView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        UserPO user = (UserPO) session.getAttribute("user");
        UserPO userPO = userService.selectById(user.getId());
        request.setAttribute("user", userPO);
        UserInfoPO userInfoPO = userInfoService.getUserInfoByUserId(user.getId());
        request.setAttribute("userInfo", userInfoPO);
        model.setViewName("userInfo");
        return model;
    }

    @PostMapping(value = "uploadImg")
    public Map<String, Object> uploadImg(HttpServletRequest request,
                                         HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<>();
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        String username = user.getUsername();
        String filePath = tmpLocation + "\\" + username;
        File dir = new File(filePath);
        try {
            if (!dir.exists()) {
                dir.mkdir();
                filePath = dir.getAbsolutePath();
            } else {
                File[] files = dir.listFiles();
                for (File currentfile : files) {
                    currentfile.delete();
                }
            }
            request.setCharacterEncoding("UTF-8");
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = null;
            Map map = multipartRequest.getFileMap();
            for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
                Object obj = i.next();
                multipartFile = (MultipartFile) map.get(obj);
            }
            //获取文件名
            String fileName = multipartFile.getOriginalFilename();
            log.info("上传的文件名为：[{}]", fileName);
            InputStream inputStream = multipartFile.getInputStream();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("上传的后缀名为：[{}]", suffixName);
            // 解决中文问题，liunx下中文路径，图片显示问题
            fileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
            File newFile = new File(filePath, fileName);
            //复制输入流到新文件中
            FileUtils.copyInputStreamToFile(inputStream, newFile);
            //获取绝对路径
            String absolutePath = newFile.getAbsolutePath();
            resultMap.put("filePath", absolutePath);
            //把路径插入数据库
            user.setAvatarUrl(fileName);
            userService.updateById(user);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.warn("上传成功");
        resultMap.put("msg", "上传成功");
        resultMap.put("status", 200);
        return resultMap;
    }

    @GetMapping("get-user-avatar")
    public void getUserAvatar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/*");
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        byte[] image = userService.getAvatarByUser(user);
        ServletOutputStream out = response.getOutputStream();
        out.write(image);
        out.close();
    }

    @PostMapping("update-user-info")
    public Boolean updateUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        return userService.updateUserInfo(userInfoDTO);

    }


}
