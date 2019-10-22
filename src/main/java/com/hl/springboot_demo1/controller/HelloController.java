package com.hl.springboot_demo1.controller;

import com.hl.springboot_demo1.configuration.GirlProperties;
import com.hl.springboot_demo1.dao.ClassInfoEntityDao;
import com.hl.springboot_demo1.dao.StudentEntityDao;
import com.hl.springboot_demo1.entity.ClassInfoEntity;
import com.hl.springboot_demo1.entity.StudentEntity;
import com.hl.springboot_demo1.form.AddStuForm;
import com.hl.springboot_demo1.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    StudentEntityDao studentDao;

    @Autowired
    ClassInfoEntityDao classInfoEntityDao;

    @Autowired
    GirlProperties girlProperties;

    @GetMapping(value = {"/hello","hi"})
    @ApiOperation(value = "测试")
    public ResponseVO<String> sayHello(){
        String result = name + "Hello World!" + content + "===" +girlProperties.getAge();
        return ResponseVO.successResponse(result);
    }

    @RequestMapping(value = "/addStu", method = RequestMethod.POST)
    @ApiOperation(value = "新增学生")
    public ResponseVO<String> addStu(@Valid @RequestBody AddStuForm form){
        StudentEntity stu = new StudentEntity();
        stu.setAge(form.getAge());
        stu.setName(form.getName());
        stu.setSex(form.getSex());
        studentDao.saveAndFlush(stu);
        return ResponseVO.successResponse("新增成功");
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有学生")
    public ResponseVO<List<StudentEntity>> findAll(){
        throw new RuntimeException("查询学生信息出错");
//        return ResponseVO.successResponse(studentDao.findAll());
    }

    @PostMapping("/queryClassInfo")
    @ApiOperation(value = "查询课程信息")
    public ResponseVO<List<ClassInfoEntity>> queryClassInfos(Integer id){
        return ResponseVO.successResponse(classInfoEntityDao.findAll());
    }
}
