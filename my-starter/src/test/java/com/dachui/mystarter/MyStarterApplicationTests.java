package com.dachui.mystarter;

import com.dachui.myautoconfiguration.core.IMyRedis;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyStarterApplicationTests {
    @Autowired
    private IMyRedis myRedis;

    @Test
    public void myRedisTest() {
        String str = myRedis.get("anqi");
        System.out.println(str);
    }

}
