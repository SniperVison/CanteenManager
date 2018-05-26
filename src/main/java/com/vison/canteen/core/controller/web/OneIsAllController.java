package com.vison.canteen.core.controller.web;

import com.alibaba.fastjson.JSON;
import com.vison.canteen.biz.bean.ResponseDTO;
import com.vison.canteen.biz.util.HttpUtils;
import com.vison.canteen.biz.util.IdList;
import com.vison.canteen.biz.util.UrlUtils;
import com.vison.canteen.core.bean.PO.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequestMapping("one")
@RestController
public class OneIsAllController {

    private static final String STATIC_URL = "channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";

    @GetMapping("painting")
    public ModelAndView paintIndex(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("paint");
        return model;
    }

    @GetMapping("yuwen")
    public ModelAndView yuwenIndex(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("yuwen");
        return model;
    }

    @GetMapping("essay")
    public ModelAndView essayIndex(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("essay");
        return model;
    }

    @PostMapping("one-list")
    public ResponseDTO getOneList() {
        try {
            Long id = getIdList().getData()[0];
            String data = HttpUtils.sendGet(UrlUtils.ONE_LIST_URL + id + "/0", STATIC_URL);
            return ResponseDTO.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.error("获取oneList失败，请联系网站管理员！");
        }
    }

    @PostMapping("yuwen-detail")
    public ResponseDTO getYuwenDetail(String itemId, String id) {
        try {
            String data = HttpUtils.sendGet(UrlUtils.ONE_ESSAY_URL + itemId, "channel=wdj&source=summary&source_id="
                    + id + "&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android");
            return ResponseDTO.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.error("获取语文信息失败，请联系网站管理员！");
        }
    }

    @PostMapping("essay-detail")
    public ResponseDTO getEssayDetail(String itemId, String id) {
        try {
            String data = HttpUtils.sendGet(UrlUtils.ONE_ESSAY_URL + itemId,
                    "channel=wdj&source=summary&source_id=" + id
                            + "&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android");
            return ResponseDTO.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.error("获取散文评论失败，请联系网站管理员！");
        }
    }

    private static IdList getIdList() {
        IdList il = new IdList();
        try {
            String idList = HttpUtils.sendGet(UrlUtils.ONE_ID_LIST_URL, STATIC_URL);
            il = JSON.parseObject(idList, IdList.class);
            return il;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
