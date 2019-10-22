package com.hl.springboot_demo1.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author 黄龙
 * @Date 2019/10/9 14:16
 * @Description TODO
 * @Version 1.0.0
 */
@Entity
@Table(name = "t_student")
@Data
@EntityListeners(AuditingEntityListener.class)
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 523807193731303425L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex", nullable = false)
    private Integer sex;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "create_time", nullable = false)
    @CreatedDate
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private Date updateTime;
}
