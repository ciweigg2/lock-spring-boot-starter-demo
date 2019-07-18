package com.august.demo;

import com.august.demo.Entity.DemoEntity;
import com.august.demo.Entity.PropertiesLockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.august.demo.manager.HelloManager;

@SpringBootApplication
public class LockSpringBootStarterDemoApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(LockSpringBootStarterDemoApplication.class, args);
	}
	
	@Autowired
	private HelloManager helloManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//最简单的配置方式，默认使用可重入锁
		helloManager.simpleReentrant("","201812125235");
		//支持加锁时长和等待时间设置
		//helloManager.lock("","201812125235");
		//支持多个Key加锁
		//helloManager.multiKey("", "key1", "key2", "key3");


		//方法锁
//		new Thread(new Runnable() {
//			public void run() {
//				DemoEntity entity = new DemoEntity();
//				entity.setOrderNo("2018121252351");
//				entity.setId(1);
//				helloManager.methodLock(entity);
//			}
//		} ).start();
//		new Thread(new Runnable() {
//			public void run() {
//				DemoEntity entity = new DemoEntity();
//				entity.setOrderNo("201812125235");
//				entity.setId(1);
//				helloManager.methodLock(entity);
//			}
//		} ).start();

//		//属性锁
//		new Thread(new Runnable() {
//			public void run() {
//				PropertiesLockEntity lockEntity = new PropertiesLockEntity();
//				lockEntity.setId("12345601");
//				helloManager.attributeLock(lockEntity);
//			}
//		} ).start();
//		new Thread(new Runnable() {
//			public void run() {
//				PropertiesLockEntity lockEntity = new PropertiesLockEntity();
//				lockEntity.setId("1234560");
//				helloManager.attributeLock(lockEntity);
//			}
//		} ).start();

	}
}
