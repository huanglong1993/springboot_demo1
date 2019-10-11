package com.hl.springboot_demo1.dao;

import com.hl.springboot_demo1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author 黄龙
 * @Date 2019/10/10 10:26
 * @Description TODO
 * @Version 1.0.0
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
}
