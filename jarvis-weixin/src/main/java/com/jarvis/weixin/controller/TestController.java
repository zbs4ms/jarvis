package com.jarvis.weixin.controller;

import com.jarvis.weixin.tool.EncrAndDecr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zbs on 2017/11/2.
 */
@RestController
@RequestMapping("/")
@Slf4j
public class TestController {

    @Value("weixin.zjdwToken")
    private String token;

    @RequestMapping(value = "test")
    @ResponseBody
    public String test(@RequestParam(value = "signature",required=false) String signature,
                       @RequestParam(value = "timestamp",required=false) Long timestamp,
                       @RequestParam(value = "nonce",required=false) Long nonce,
                       @RequestParam(value = "echostr",required=false) String echostr) throws Exception {
        String decrStr = EncrAndDecr.getSha1(token + timestamp + nonce);
        log.info("加密后信息 "+ decrStr);
        if(decrStr.endsWith(signature)) {
            return echostr;
        }
        return "no";
    }
}
