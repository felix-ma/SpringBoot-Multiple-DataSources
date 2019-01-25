package cn.felix.multipledatasources.controller;

import cn.felix.multipledatasources.entity.Teacher;
import cn.felix.multipledatasources.vo.TeacherVo;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import cn.felix.multipledatasources.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
*
* @author felix-ma
* @create 2019/1/25 14:46
**/
@Api("对老师表CRUD")
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "添加老师")
    @PostMapping("/add")
    public String add(@RequestBody TeacherVo teacher){
        Teacher tea = new Teacher();
        tea.setName(teacher.getName());
        tea.setAge(teacher.getAge());
        tea.setSubject(teacher.getSubject());
        return teacherService.insert(tea)?"添加成功":"添加失败";
    }

    @ApiOperation("删除老师")
    @DeleteMapping("/delete/{id}")
    public String delete(@ApiParam("老师的主键id")@PathVariable(value = "id") Integer id){
        return teacherService.deleteById(id)?"删除成功":"删除失败";
    }

    @ApiOperation("修改老师")
    @PostMapping("/update")
    public String update(@RequestBody Teacher teacher){
        return teacherService.updateById(teacher)?"修改成功":"修改失败";
    }

    @ApiOperation(value = "查询老师")
    @GetMapping("/list")
    public List<Teacher> list(){
        Wrapper<Teacher> wrapper = new EntityWrapper<>();
        return teacherService.selectList(wrapper);
    }
}
