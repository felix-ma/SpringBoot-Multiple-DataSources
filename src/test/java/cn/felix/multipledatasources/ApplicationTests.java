package cn.felix.multipledatasources;

import cn.felix.multipledatasources.entity.Student;
import cn.felix.multipledatasources.entity.Teacher;
import cn.felix.multipledatasources.service.StudentService;
import cn.felix.multipledatasources.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author felix-ma
 * @create 2019/1/25 14:56
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @Test
    public void contextLoads() {
        List<Student> students = studentService.selectList(null);
        List<Teacher> teachers = teacherService.selectList(null);
        System.out.println(students);
        System.out.println(teachers);
    }

}
