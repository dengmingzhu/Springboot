package com.example.demo.from;

import lombok.Data;

/**
 * @Author DengMingZhu
 * @Date 2019/12/20 10:13
 * @Version 1.0
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
