package com.hl.springboot_demo1.controller;

import com.hl.springboot_demo1.configuration.GirlProperties;
import com.hl.springboot_demo1.dao.StudentDao;
import com.hl.springboot_demo1.entity.Student;
import com.hl.springboot_demo1.form.AddStuForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 黄龙
 * @Date 2019/10/8 17:44
 * @Description 测试
 * @Version 1.0.0
 */
@RestController
@Api(description = "测试接口")
public class HelloController {

    @Value("${girl.name}")
    private String name;

    @Value("${content}")
    private String content;

    @Autowired
    StudentDao studentDao;

    @Autowired
    GirlProperties girlProperties;

    @GetMapping(value = {"/hello","hi"})
    @ApiOperation(value = "测试")
    public String sayHello(){
        return name + "Hello World!" + content + "===" +girlProperties.getAge();
    }

    @RequestMapping(value = "/addStu", method = RequestMethod.POST)
    @ApiOperation(value = "新增学生")
    public String addStu(@RequestBody AddStuForm form){
        Student stu = new Student();
        stu.setAge(form.getAge());
        stu.setName(form.getName());
        stu.setSex(form.getSex());
        studentDao.saveAndFlush(stu);
        return "success";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有学生")
    public List<Student> findAll(){
        return studentDao.findAll();
    }
}
