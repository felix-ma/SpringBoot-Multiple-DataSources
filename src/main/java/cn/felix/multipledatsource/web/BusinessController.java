package cn.felix.multipledatsource.web;

import cn.felix.multipledatsource.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author felix-ma
 * @create 2019/1/24 17:40
 **/
@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/execute")
    public String execute() {
        try {
            businessService.execute();
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

}
