package model.services.Service.impl;

import model.repository.Service.ServiceRepository;
import model.repository.Service.ServiceRepositoryImpl;
import model.services.Service.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    private final String VALIDATE_SERVICE_ID= "(DV)[-][\\d]{4}";

    @Override
    public List<model.bean.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean saveService(model.bean.Service service) {
        return serviceRepository.saveService(service);
    }

    @Override
    public Map<String, String> saveService1(model.bean.Service service) {
        Map<String,String> map = new HashMap<>();
        boolean check = true;
        if(service.getServiceCode().equals("")){
            check = false;
            map.put("MSS","Ma khong duoc de trong");
        }else if(!validate(service.getServiceCode())){
            check = false;
            map.put("MSS","Ma khong dung dinh dang");
        }
        if(check){
            serviceRepository.saveService(service);
        }
        return map;
    }
    // phương thức kiểm tra dữ liệu SOLID,
    public boolean validate(String serviceCode){
        return serviceCode.matches(VALIDATE_SERVICE_ID);
    }
}
