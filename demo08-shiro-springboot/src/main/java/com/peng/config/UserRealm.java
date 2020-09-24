package com.peng.config;

import com.peng.pojo.User;
import com.peng.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("==================>z执行了授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //info.addStringPermission("user:add");

        Subject subject = SecurityUtils.getSubject();

        User principal = (User) subject.getPrincipal();

        info.addStringPermission(principal.getPerms());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("==================>z执行了认证");


        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.queryByName(token.getUsername());


        if (user == null){
           return null;
       }

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
