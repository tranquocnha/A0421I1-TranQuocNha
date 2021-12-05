package com.codegym.cms.services;

import com.codegym.cms.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
