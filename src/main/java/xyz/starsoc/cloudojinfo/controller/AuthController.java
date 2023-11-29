package xyz.starsoc.cloudojinfo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.starsoc.cloudojinfo.config.UserConfiguration;
import xyz.starsoc.cloudojinfo.pojo.Result;
import xyz.starsoc.cloudojinfo.pojo.User;

@RestController
@Slf4j
public class AuthController {
    @Autowired
    private User admin;




    /**
     * 用户登录方法
     *
     * @param user 登录的用户对象
     * @return 返回登录结果，成功时返回包含令牌的Result对象，失败时返回包含错误信息的Result对象
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {

        if (admin.getUsername().equals(user.getUsername()) && admin.getPassword().equals(user.getPassword())) {

            return Result.success("登录成功",UserConfiguration.getToken());
        }
        return Result.failure("登录失败");
    }





    @GetMapping("/verify")
    public Result<String> verify(){
        return Result.success("验证成功");
    }



}
