package cn.felix.multipledatsource;

import cn.felix.multipledatsource.entity.DataA;
import cn.felix.multipledatsource.dao.a.DataADao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDataSourcesApplication {

    @Autowired
    private DataADao dataAMapper;

    @Test
    public void insertTest() {
        System.out.println(dataAMapper);
        List<DataA> all = dataAMapper.selectList(null);
        System.out.println(all);
    }

}
