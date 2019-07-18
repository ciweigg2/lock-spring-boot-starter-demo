package com.august.demo.manager;

import com.august.demo.Entity.DemoEntity;
import com.august.demo.Entity.PropertiesLockEntity;
import io.gitee.tooleek.lock.spring.boot.annotation.Key;
import io.gitee.tooleek.lock.spring.boot.annotation.Lock;
import io.gitee.tooleek.lock.spring.boot.enumeration.LockType;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class HelloManager {
	
	/**
	 * 最简单的配置方式，默认使用可重入锁
	 * @param ces
	 * @param orderNo “@Key”标记的参数作为分布式锁的关键字
	 */
	@Lock
	public void simpleReentrant(String ces, @Key String orderNo) {
		System.out.println("hello");
	}
	
	/**
	 * lockType：锁类型设置，支持6种常用锁
	 * waitTime：等待锁的时间，超过该时长依然无法获取到锁则不会执行程序
	 * leaseTime：加锁时长，超过该时长自动解锁，所以设置该值时一定要设置一个合理的值
	 * @param ces
	 * @param orderNo
	 */
	@Lock(lockType=LockType.REENTRANT,waitTime=20,leaseTime=10)
	public void lock(String ces, @Key String orderNo) {
		System.out.println("hello");
	}
	
	/**
	 * 多个Key的锁，目前多个Key只支持联锁及红锁
	 * @param param
	 * @param key1
	 * @param key2
	 * @param key3
	 */
	@Lock(lockType=LockType.MULTI)
	public void multiKey(String param,@Key String key1,@Key String key2,@Key String key3) {
		System.out.println("hello");
	}


	/**
	 * 方法申明对象加锁属性
	 * @param entity
	 */
    @Lock(lockType = LockType.MULTI,waitTime=20,leaseTime=10)
    @Key({"DemoEntity.orderNo","DemoEntity.id"})
    public void methodLock(DemoEntity entity) {
        System.out.println(LocalTime.now()+":hello");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


	/**
	 * 对象属性添加锁
	 */
	@Lock(waitTime=20,leaseTime=10)
    public void  attributeLock(PropertiesLockEntity demoEntity){
		System.out.println(LocalTime.now()+":hello");
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}




}
