package com.mmj.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.mmj.app.config.WebConfig;
import com.mmj.core.config.CoreSpringConfig;

@SpringBootApplication
@Import(value = { CoreSpringConfig.class, WebConfig.class})
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
