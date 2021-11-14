package model.services.Service;

import java.util.List;
import java.util.Map;

public interface Service {
    List<model.bean.Service> findAll();
    boolean saveService(model.bean.Service service);
    Map<String,String> saveService1(model.bean.Service service);
}
