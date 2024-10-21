package com.liangquan.pay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName：PageController
 * @Author: liangquan
 * @Date: 2024/10/21 13:42
 * @Description: 创建跳转页面的控制器PageController
 */
public class PageController {
    @GetMapping("/")
    public String home(){
        return "index.html";
    }
    @GetMapping("/page/{pageName}")
    public String page(@PathVariable String pageName){
        return pageName;
    }
}
