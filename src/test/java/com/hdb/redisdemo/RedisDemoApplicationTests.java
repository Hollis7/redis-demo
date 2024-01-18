package com.hdb.redisdemo;

import com.hdb.redisdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name", "彬哥");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testSaveUser() {
        redisTemplate.opsForValue().set("user:100", new User("彬哥", 23));

        User user = (User) redisTemplate.opsForValue().get("user:100");
        System.out.println("user = " + user);
    }

}
