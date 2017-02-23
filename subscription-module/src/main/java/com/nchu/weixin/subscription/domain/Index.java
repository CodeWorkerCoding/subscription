package com.nchu.weixin.subscription.domain;

import com.nchu.weixin.subscription.enums.IndexTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 物品编号
 * Created by fujianjian on 2017/2/23.
 */
@Entity
@Table(name = "subscription_index")
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter@Setter
    private Integer id;
    @Getter@Setter
    @Column(length = 16)
    private String flagDate;
    @Getter@Setter
    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private IndexTypeEnum type;
    @Getter@Setter
    @Column(length = 11)
    private Integer indexCount;
    @Getter@Setter
    private Date createdTime;
    @Getter@Setter
    private Date modifiedTime;

    /***
     * default constructor
     */
    public Index(){}

    public Index(String flagDate, IndexTypeEnum type){
        this.flagDate = flagDate;
        this.type = type;
    }

    @PrePersist
    public void onCreate(){
        this.createdTime = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        this.modifiedTime = new Date();
    }
}
