package cn.felix.multipledatasources.service.impl;

import cn.felix.multipledatasources.annotation.DataSource;
import cn.felix.multipledatasources.entity.Teacher;
import cn.felix.multipledatasources.enums.DataSourceEnum;
import cn.felix.multipledatasources.mapper.TeacherMapper;
import cn.felix.multipledatasources.service.TeacherService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
* 
* @author felix-ma
* @create 2019/1/25 14:51
**/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public boolean insert(Teacher entity) {
        return super.insert(entity);
    }

    @Override
    public boolean deleteById(Serializable id) {
        return super.deleteById(id);
    }

    @Override
    public boolean updateById(Teacher entity) {
        return super.updateById(entity);
    }

    @Override
    public Teacher selectById(Serializable id) {
        return super.selectById(id);
    }

    @Override
    public List<Teacher> selectList(Wrapper<Teacher> wrapper) {
        return super.selectList(wrapper);
    }

    @Override
    public Page<Teacher> selectPage(Page<Teacher> page) {
        return super.selectPage(page);
    }

    @Override
    public Page<Teacher> selectPage(Page<Teacher> page, Wrapper<Teacher> wrapper) {
        return super.selectPage(page, wrapper);
    }
}
