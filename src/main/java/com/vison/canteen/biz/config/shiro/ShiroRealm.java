package com.vison.canteen.biz.config.shiro;

import com.vison.canteen.biz.enums.UserRole;
import com.vison.canteen.biz.enums.UserStatus;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.service.RoleService;
import com.vison.canteen.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * @author huangwenshen 2018/3/31 15:43
 */
@Slf4j
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        log.info("开始身份验证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        Object password = String.valueOf(token.getPassword());
        UserPO userPO = userService.getByUsername(username);
        if (userPO == null) {
            log.info("账户不存在");
            throw new UnknownAccountException("用户名或密码错误！");
        } else if (userPO != null
                && !userPO.getPassword().equals(password)
                && userPO.getStatus() != UserStatus.LOCKED) {
            log.info("密码不正确");
            throw new IncorrectCredentialsException("用户名或密码错误！");
        } else if (userPO != null
                && userPO.getPassword().equals(password)
                && userPO.getStatus() == UserStatus.LOCKED) {
            log.info("账户被锁定");
            throw new LockedAccountException("账户被锁定！");
        } else {
            //当前realm对象的name，调用父类的getName（）即可
            String realName = getName();
            //账号
            Object principal = username;
            //密码
            Object credentials = password;
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", userPO);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realName);
            return info;
        }
    }

    //校验权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.error("进入授权校验了");
        String principal = (String) principals.getPrimaryPrincipal();
        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute("username", SecurityUtils.getSubject().getPrincipals());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if ("vison".equals(principal)) {
            info.addRole(UserRole.ADMIN.getTypeName());
        } else {
            info.addRole(UserRole.USER.getTypeName());
        }
        return info;
    }

}
