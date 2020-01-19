package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotations.LagouAutowired;
import com.lagou.edu.mvcframework.annotations.LagouController;
import com.lagou.edu.mvcframework.annotations.LagouRequestMapping;
import com.lagou.edu.mvcframework.annotations.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@LagouController
@LagouRequestMapping("/demo")
@Security({"admin","nico"})
public class DemoController {

    @LagouAutowired
    private IDemoService demoService;

    /**
     * URL: /demo/query?name=lisi
     * @param request
     * @param response
     * @param name
     * @return
     */
    @LagouRequestMapping("/query")
    @Security({"zhangsan"})
    public String query(HttpServletRequest request, HttpServletResponse response,String name) {

        System.out.println("这个是/demo/query");

        return demoService.get(name);
    }

    @LagouRequestMapping("/query1")
    public String query1(HttpServletRequest request, HttpServletResponse response,String name) {

        System.out.println("这个是/demo/query1");

        return demoService.get(name);
    }

    @LagouRequestMapping("/query2")
    public String query2(HttpServletRequest request, HttpServletResponse response,String name) {

        System.out.println("这个是/demo/query2");

        return demoService.get(name);
    }

}
