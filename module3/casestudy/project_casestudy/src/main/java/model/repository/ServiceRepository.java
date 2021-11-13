package model.repository;

import model.bean.Customer;
import model.bean.Service;

import java.util.List;

public interface ServiceRepository {
    List<Service> findAll();
    boolean saveService(Service service);
}
