package com.dachui.componentredis;

//import org.junit.jupiter.api.Test;
import com.dachui.componentredis.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;

@SpringBootTest
class ComponentRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSaveObj() throws IOException {
        //User user =new User(1,"zhangsan","123345","aa@qq.com","199107");
        User user = new User();
        redisTemplate.opsForValue().set("zhangsan",user);
        //这里使用的linkedHashmap
        Object obj = redisTemplate.opsForValue().get("zhangsan");

        ObjectMapper MAPPER = new ObjectMapper();
        //转为对象
        User user2 = MAPPER.readValue(MAPPER.writeValueAsString(obj),User.class);
        System.out.println(user2);

    }

}
