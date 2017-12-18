package cn.it.phw.ms.test;

import cn.it.phw.ms.BaseSpringJunitTest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class Test extends BaseSpringJunitTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Gson gson;

    @org.junit.Test
    public void testAutoWired() {
        redisTemplate.opsForValue().set("gson", gson.toString());
    }

}
