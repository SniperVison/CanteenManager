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
@RequestMapping("weather")
public class WeatherController {

    @GetMapping("/")
    public ModelAndView weatherView(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("weather");
        return model;
    }

    @PostMapping("query")
    public ResponseDTO queryWeather(String areaId) {
        try {
            String data = HttpUtils.sendPost(UrlUtils.MEIZU_WEATHER_URL, "cityIds=" + areaId);
            System.out.println(data);
            return ResponseDTO.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.error("查询天气失败，请联系网站管理员！");
        }
    }
}
