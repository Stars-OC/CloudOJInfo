package xyz.starsoc.cloudojinfo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import xyz.starsoc.cloudojinfo.pojo.User;

import java.util.Base64;

@Configuration
public class UserConfiguration {

    @Value("${user.username}")
    private String username;

    @Value("${user.password}")
    private String password;

    private static String token;


    private static long verifyTime;

    @Value("${user.token}")
    public void setToken(String tokenConfig){
        token = tokenConfig;
    }
    @Value("${user.verifyTime}")
    public void setVerifyTime(long verifyTimeConfig){
        verifyTime = verifyTimeConfig;
    }

    @Bean
    public User admin() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public static String getToken(){
        long nowTime = System.currentTimeMillis() / 1000;
        long time = nowTime + verifyTime;
        String original = token + ":" + time;
        String sign = Base64.getEncoder().encodeToString(original.getBytes());
        return sign;
    }

    /**
     * 检查令牌是否有效
     * @param token 传入的令牌
     * @return 如果令牌有效则返回true，否则返回false
     */
    public static boolean checkToken(String token){
        // 获取当前时间（以秒为单位）
        long nowTime = System.currentTimeMillis() / 1000;
        // 解码令牌
        byte[] decode = Base64.getDecoder().decode(token);
        // 将解码后的字节数组转换为字符串
        String decodeSplit = new String(decode);
        // 通过冒号分割字符串得到时间字符串数组
        String[] timeString = decodeSplit.split(":");
        // 解析时间字符串为长整型时间
        long time = Long.parseLong(timeString[1]);
        // 返回比较结果，判断时间是否有效
        return time > nowTime;
    }


}
