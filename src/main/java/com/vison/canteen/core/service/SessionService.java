package com.vison.canteen.core.service;

import com.vison.canteen.biz.bean.UserOnline;

import java.util.List;

/**
 * @author huangwenshen 2018/5/11 19:46
 */
public interface SessionService {


    List<UserOnline> list();

    boolean forceLogout(String sessionId);

}
