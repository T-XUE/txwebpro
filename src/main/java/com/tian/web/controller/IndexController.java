package com.tian.web.controller;

import com.tian.mapper.UserBaseInfoMapper;
import com.tian.model.UserBaseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String vm_path = "/";

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("进入首页...");
        model.addAttribute("service", "index");
        return vm_path + "front/index.vm";
    }

    @RequestMapping("{service}.htm")
    public String vacation(Model model, HttpServletRequest request, HttpServletResponse response,
                           @PathVariable String service) {
        logger.info("进入页面{}", service);
        model.addAttribute("service", service);
        UserBaseInfo userBaseInfo = userBaseInfoMapper.selectByPrimaryKey("17063007835");
        model.addAttribute("userBaseInfo", userBaseInfo);
        return vm_path + "front/" + service + ".vm";
    }

}
