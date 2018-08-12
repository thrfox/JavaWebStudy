package com.study.springAop.demo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiongyongshun
 * @version 1.0
 * @created 2016/11/11 22:59
 */
@RestController
public class DemoController {
    @RequestMapping("/com/study/springAop/http/alive")
    public String alive() {
        return "服务一切正常";
    }

    @AuthChecker
    @RequestMapping("/com/study/springAop/http/user_info")
    public String callSomeInterface() {
        return "调用了 user_info 接口.";
    }
}
