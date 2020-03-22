package com.dachui.quickstart;

public class RedisLock {
    public String deductStock() throws InterruptedException {
        String lockKey = "product_001";
        //String clientId = UUID.randomUUID().toString();
        RLock redissonLock = redisson.getLock(lockKey);
        try {
            //Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "zhuge"); //jedis.setnx(key,value)
            //stringRedisTemplate.expire(lockKey,30, TimeUnit.SECONDS);
            /*Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 30, TimeUnit.SECONDS);

            if (!result) {
                return "1001";
            }*/

            // 加锁，实现锁续命功能
            redissonLock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock")); // jedis.get("stock")
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + ""); // jedis.set(key,value)
                System.out.println("扣减成功，剩余库存:" + realStock + "");
            } else {
                System.out.println("扣减失败，库存不足");
            }
        }finally {
            redissonLock.unlock();
            /*if (clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))){
                    stringRedisTemplate.delete(lockKey);
            }*/
        }
        return "end";
    }
}
