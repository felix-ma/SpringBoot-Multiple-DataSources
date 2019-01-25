package cn.felix.multipledatasources.service.impl;

import cn.felix.multipledatasources.annotation.DataSource;
import cn.felix.multipledatasources.entity.Student;
import cn.felix.multipledatasources.enums.DataSourceEnum;
import cn.felix.multipledatasources.mapper.StudentMapper;
import cn.felix.multipledatasources.service.StudentService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 
* @author felix-ma
* @create 2019/1/25 14:48
**/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    @DataSource(DataSourceEnum.DB2)
    public List<Student> selectList(Wrapper<Student> wrapper) {
        return super.selectList(wrapper);
    }
}
