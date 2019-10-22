package com.hl.springboot_demo1.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author 黄龙
 * @Date 2019/10/10 11:31
 * @Description TODO
 * @Version 1.0.0
 */
@Data
@ApiModel(description = "添加学生model")
public class AddStuForm {

    @ApiModelProperty(value = "学生姓名")
    @NotNull(message = "学生姓名不能为空")
    @Length(min = 2, max = 20, message = "学生姓名长度不符")
    private String name;

    @ApiModelProperty(value = "学生年龄")
    private Integer age;

    @ApiModelProperty(value = "学生性别")
    private Integer sex;
}
