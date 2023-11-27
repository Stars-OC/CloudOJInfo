package xyz.starsoc.cloudojinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ServletComponentScan
@MapperScan("xyz/starsoc/cloudojinfo/mapper")
@EnableWebMvc
public class CloudOjInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOjInfoApplication.class, args);
    }

}
