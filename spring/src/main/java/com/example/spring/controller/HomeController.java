package com.example.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author majin.wj
 * @date 2023/6/13 3:32 PM
 * @desc
 */
@RestController
public class HomeController {

    @GetMapping("/see")
    public String see(){
        return "welcome(~)";
    }



}
