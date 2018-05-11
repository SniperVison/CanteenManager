package com.vison.canteen.core.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vison.canteen.biz.bean.UserOnline;
import com.vison.canteen.biz.util.AddressUtils;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.service.SessionService;
import com.vison.canteen.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author huangwenshen 2018/5/11 19:47
 */
@Slf4j
@Service
@Transactional
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDAO sessionDAO;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    UserService userService;

    @Override
    public List<UserOnline> list()  {
        List<UserOnline> list = new ArrayList<>();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            UserOnline userOnline = new UserOnline();
            SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
                continue;
            } else {
                principalCollection = (SimplePrincipalCollection) session
                        .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                String username = principalCollection.toString();
                UserPO user = userService.getByUsername(username);
                userOnline.setUsername(username);
                userOnline.setUserId(user.getId().toString());
            }
            userOnline.setId((String) session.getId());
            userOnline.setHost(session.getHost());
            userOnline.setStartTimestamp(session.getStartTimestamp());
            userOnline.setLastAccessTime(session.getLastAccessTime());
            Long timeout = session.getTimeout();
            if (timeout == 0L) {
                userOnline.setStatus("0");
            } else {
                userOnline.setStatus("1");
            }
            String address = AddressUtils.getRealAddressByIP(userOnline.getHost(), mapper);
            userOnline.setLocation(address);
            userOnline.setTimeout(timeout);
            list.add(userOnline);
        }
        return list;
    }

    @Override
    public boolean forceLogout(String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        session.setTimeout(0);
        return true;
    }


}
