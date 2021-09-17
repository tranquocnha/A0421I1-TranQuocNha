package cassestudy.services;

import cassestudy.models.Customer;

public interface CustomerService extends Service {
    public Customer isCustomer(String customerCode);
}
