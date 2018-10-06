package com.bluecity.cbs.system.controller;

import com.bluecity.cbs.common.annotation.Log;
import com.bluecity.cbs.common.utils.MD5Utils;
import com.bluecity.cbs.common.utils.R;
import com.bluecity.cbs.common.utils.ShiroUtils;
import com.bluecity.cbs.system.service.MenuService;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Log4j
@Controller
public class LoginController {
    @Autowired
    MenuService menuService;

    @GetMapping({"/", ""})
    String welcome(Model model) {

        return "redirect:/index";
    }

    @Log("请求访问主页")
    @GetMapping({"/index"})
    String index(Model model) {
        model.addAttribute("name", ShiroUtils.getUser().getName());
        model.addAttribute("username", ShiroUtils.getUser().getUsername());
        return "index";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @Log("登录")
    @PostMapping("/login")
    @ResponseBody
    R ajaxLogin(String username, String password) {

        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (AuthenticationException e) {
            return R.error("用户或密码错误");
        }
    }

    @GetMapping("/logout")
    String logout() {
        ShiroUtils.logout();
        return "redirect:/login";
    }

    @GetMapping("/main")
    String main() {
        return "main";
    }
}
