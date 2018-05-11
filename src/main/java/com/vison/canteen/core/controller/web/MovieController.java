package com.vison.canteen.core.controller.web;


import com.vison.canteen.biz.bean.ResponseDTO;
import com.vison.canteen.biz.util.HttpUtils;
import com.vison.canteen.biz.util.UrlUtils;
import com.vison.canteen.core.bean.PO.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("movie")
public class MovieController {

    @GetMapping("hot")
    public ModelAndView hotView(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("hot");
        return model;
    }

    @GetMapping("coming")
    public ModelAndView comintView(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("comingmovie");
        return model;
    }

    @PostMapping("get-movie-hot")
    public ResponseDTO getMoiveHot() {
        try {
            String data = HttpUtils.sendSSLPost(UrlUtils.TIME_MOVIE_HOT_URL, "locationId=328");
            return ResponseDTO.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.error("获取热映影片信息失败，请联系网站管理员！");
        }
    }

    @PostMapping("get-movie-coming")
    public ResponseDTO getMovieComing() {
        try {
            String data = HttpUtils.sendSSLPost(UrlUtils.TIME_MOVIE_COMING_URL, "locationId=328");
            return ResponseDTO.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.error("获取即将上映影片信息失败，请联系网站管理员！");
        }
    }

}
