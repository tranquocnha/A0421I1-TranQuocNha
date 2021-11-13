package model.services;

import java.util.List;

public interface Service {
    List<model.bean.Service> findAll();
    boolean saveService(model.bean.Service service);
}
