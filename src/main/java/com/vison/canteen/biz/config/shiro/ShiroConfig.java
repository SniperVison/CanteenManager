
package com.vison.canteen.biz.config.shiro;

import com.vison.canteen.core.service.PermissionInitService;
import com.vison.canteen.core.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huangwenshen 2018/3/11 21:21
 */


@Slf4j
@Component
public class ShiroConfig {

    @Autowired
    ShiroRealm shiroRealm;

    @Autowired
    PermissionService permissionService;

    @Autowired
    RedisManager redisManager;

    @Autowired
    RedisCacheManager redisCacheManager;

    @Autowired
    PermissionInitService permissionInitService;

    private static final int SEVENDAY = 604800;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        log.warn("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //默认是登录页面,如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/");
        //登录成功跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/main");
        //未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        /**过滤链
         * url权限采用第一次匹配优先原则，在前面的执行度越高,所以使用有序的LinkHashMap
         * 配置哪些页面需要收到保护，以及访问这些页面需要的权限
         * anon 可以被匿名访问
         * authc 必须认证(即登录后)才能访问的页面
         * logout 登出
         */

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>() {
            {

                put("/swagger/**","anon");
                put("/static/**", "anon");
                put("/swagger-ui.html", "anon");
                put("/swagger-resources", "anon");
                put("/v2/api-docs", "anon");
                put("/webjars/springfox-swagger-ui/**", "anon");
                put("/register/**", "anon");
                put("/druid/**", "anon");
                put("/kaptcha/**", "anon");
                put("/ajax-login", "anon");
                put("/user/list", "roles[admin]");
                put("/templates/**", "authc");
                put("/logout", "logout");
                put("/addAuthc", "perms[权限添加]");
                put("/**", "authc");
            }
        };
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置Realm
        securityManager.setRealm(shiroRealm);
        //自定义缓存实现，使用redis
        securityManager.setCacheManager(redisCacheManager);
        //自定义session管理，使用redis
        securityManager.setSessionManager(this.sessionManager());
        //注入记住我管理器
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     * cookie对象
     *
     * @return
     */

    public SimpleCookie rememberCookie() {
        //这个参数cookie的名称，对应前端的checkbox的name=rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //记住我cookie生效时间7天，单位秒
        simpleCookie.setMaxAge(SEVENDAY);
        return simpleCookie;
    }

    /**
     * cookie管理对象，记住我功能
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /**
     * RedisSessionDAO shiro
     * sessionDao层的实现 通过redis
     *
     * @return
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }

    /**
     * shiro session的管理
     *
     * @return
     */
    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
        listeners.add(new ShiroSessionListener());
        sessionManager.setSessionListeners(listeners);
        sessionManager.setSessionDAO(this.redisSessionDAO());
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(256);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    public static void main(String[] args) {
        String algorithmName = "MD5";
        String source = "123";
        String salt = "abc";
        int hashIterations = 256;
        SimpleHash simpleHash = new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(simpleHash.toString());
    }


}


