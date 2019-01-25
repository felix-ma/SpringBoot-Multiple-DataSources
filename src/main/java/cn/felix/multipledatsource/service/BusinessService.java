package cn.felix.multipledatsource.service;

import cn.felix.multipledatsource.entity.DataA;
import cn.felix.multipledatsource.entity.DataB;
import cn.felix.multipledatsource.entity.DataC;

import java.util.List;

public interface BusinessService {

    void execute();

    List<DataA> getAllA();

    List<DataB> getAllB();

    List<DataC> getAllC();
}
