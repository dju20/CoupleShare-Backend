package com.example.couplesharebackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:mysql://localhost:3306/coupleshare?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true",
    "spring.datasource.username=root",
    "spring.datasource.password=coupleshare9764"
})
class CoupleShareBackendApplicationTests {

    @Test
    void contextLoads() {
    }

}
