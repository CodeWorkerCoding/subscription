package com.nchu.weixin.subscription.rim.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统连接秘钥相关配置 (保存在另一个数据源)
 * Created by fujianjian on 2017/2/20.
 */
@Entity
@Table(name = "subscription_secret_config")
public class SecretConfig {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(length = 128)
    @Getter
    @Setter
    private String externalKey1;

    @Column(length = 128)
    @Getter
    @Setter
    private String externalKey2;

    @Column(length = 128)
    @Getter
    @Setter
    private String internalKey1;

    @Column(length = 128)
    @Getter
    @Setter
    private String internalKey2;

    @Column(length = 128)
    @Getter
    @Setter
    private String extendKey1;

    @Column(length = 128)
    @Getter
    @Setter
    private String extendKey2;

}
