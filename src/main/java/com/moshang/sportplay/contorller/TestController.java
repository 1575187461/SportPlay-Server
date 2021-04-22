package com.moshang.sportplay.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: Yu
 * @Date: 2021/4/1 11:15
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "ok";
    }
}
