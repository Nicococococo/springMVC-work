package com.lagou.edu.controller;

import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, String username, String password) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("login");

        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, String username, String password) {

        ModelAndView modelAndView = new ModelAndView();

        if(!(username != null && password != null && "admin".equals(username) && "admin".equals(password))) {

            modelAndView.addObject("msg","用户名密码错误");
            modelAndView.setViewName("login");

            return modelAndView;
        }
        request.getSession().setAttribute("user", username);

        modelAndView.setViewName("resume");

        return modelAndView;
    }


}
