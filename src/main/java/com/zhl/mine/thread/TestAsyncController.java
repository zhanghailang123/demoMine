package com.zhl.mine.thread;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/9/30 14:59
 */
@RestController("zzzz")
@Slf4j
public class TestAsyncController {

    private final TestAsync testAsync;

    public TestAsyncController(TestAsync testAsync) {
        this.testAsync = testAsync;
    }

    @GetMapping("/testAsync")
    public Object testAsync(int num){
//        try {
//            log.info(this.testAsync.testAsync(num).get() + " 返回的参数");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        User user = new User(){{
            setAge(25);
            setName("zzz");
        }};

        return user;
    }

    @Data
    public static class User{
        private String name;
        private Integer age;
    }
}