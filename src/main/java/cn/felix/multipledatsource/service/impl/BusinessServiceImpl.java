package cn.felix.multipledatsource.service.impl;

import cn.felix.multipledatsource.dao.a.DataADao;
import cn.felix.multipledatsource.entity.DataA;
import cn.felix.multipledatsource.entity.DataB;
import cn.felix.multipledatsource.entity.DataC;
import cn.felix.multipledatsource.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author potter
 * @create 2018-06-13 17:57
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private DataADao dataAMapper;

    @Override
    public void execute() {
        List<DataA> dataAS = dataAMapper.selectList(null);
        System.out.println(dataAS);
    }

    @Override
    public List<DataA> getAllA() {
        return null;
    }

    @Override
    public List<DataB> getAllB() {
        return null;
    }

    @Override
    public List<DataC> getAllC() {
        return null;
    }
}
