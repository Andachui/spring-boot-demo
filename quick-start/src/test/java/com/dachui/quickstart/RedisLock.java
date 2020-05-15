package com.dachui.quickstart;

import com.base.common.log.LoggerFactory;
import com.oasis.biz.tpse.service.tpse.TpseBpmService;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;


/**
 * Redis实现分布式锁
 */
public class RedisLock {

  private static final Logger logger = LoggerFactory.getLogger(TpseBpmService.class);

  private RedisTemplate<String, Object> redisTemplate;

  public static final int retryMs = 10;

  /**
   * 锁超时时间
   */
  private long lockTimeOut;

  /**
   * 锁超时时间值
   */
  private long lockTimeOutValue;

  /**
   * 锁id
   */
  private String key;

  public RedisLock(RedisTemplate<String, Object> redisTemplate, String key, long lockTimeOut) {
    this.redisTemplate = redisTemplate;
    this.lockTimeOut = lockTimeOut;
    this.key = key;
  }

  /**
   * 加锁
   */
  public boolean lock() {
    return lock(0);
  }

  /**
   * 加锁
   */
  public boolean lock(long waitTimeOut) {
    try {
      long now = System.currentTimeMillis();
      // 失效时间
      lockTimeOutValue = now + this.lockTimeOut + 1;
      while ((System.currentTimeMillis() - now) < waitTimeOut || waitTimeOut == 0) {
        Boolean ret = redisTemplate.opsForValue().setIfAbsent(this.key, String.valueOf(lockTimeOutValue));
        if (ret) {
          this.redisTemplate.expire(this.key, this.lockTimeOut, TimeUnit.MILLISECONDS);
          return true;
        }
        // 解决死锁：判断key对应的value是否超时
        Object currentValue = redisTemplate.opsForValue().get(this.key);
        String currentValueStr = currentValue == null ? null : currentValue.toString();
        if (currentValueStr != null && System.currentTimeMillis() > Long.valueOf(currentValueStr)) {
          // 并发竞争：getAndSet取出旧值再判断一次，避免被其他线程set
          Object oldValue = redisTemplate.opsForValue()
              .getAndSet(this.key, String.valueOf(lockTimeOutValue));
          String oldValueStr = oldValue == null ? null : oldValue.toString();
          if (oldValueStr == null || oldValueStr.equals(currentValueStr)) {
            return true;
          }
        }

        if (waitTimeOut == 0) {
          break;
        }

        // 加随机时间防止活锁
        // 注意：当前线程将持有jedis一段时间（retryMs），如果并发数过大，可能会导致jedis连接数不足
        TimeUnit.MILLISECONDS.sleep(retryMs + new Random().nextInt(100));
      }
      // 超时未成功
      return false;
    } catch (Exception e) {
      logger.error("lock error key:" + this.key, e);
      return false;
    }
  }


  /**
   * 释放
   */
  public void unlock() {
    Object value = redisTemplate.opsForValue().get(key);
    // timeValue不等：可能发生当前线程lock后，业务操作比较耗时，导致超时后被其他线程lock
    if (value != null && lockTimeOutValue == Long.parseLong(value.toString())) {
      redisTemplate.delete(key);
    }
  }


}