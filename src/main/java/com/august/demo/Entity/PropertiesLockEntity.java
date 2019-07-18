package com.august.demo.Entity;

import lombok.Getter;
import lombok.Setter;
import io.gitee.tooleek.lock.spring.boot.annotation.Key;

/**
 * @BelongsPackage: com.august.demo
 * @Author: zsx
 * @CreateTime: 2019-04-16 10:42
 * @Description:
 */
@Setter
@Getter
public class PropertiesLockEntity {

    @Key
    private String id;

    private Integer count;

}
