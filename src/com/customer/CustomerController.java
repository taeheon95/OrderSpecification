package com.customer;

import java.util.HashMap;

class CustomerController {
    private static int CUSTOMER_NUM = 0;
    private static CustomerController instance;
    private final HashMap<Integer, Customer> customers;

    private CustomerController() {
        customers = new HashMap<>();
    }

    static CustomerController getInstance() {
        if(instance == null)
            instance = new CustomerController();
        return instance;
    }

    boolean isCustomer(int c_num){
        return customers.containsKey(c_num);
    }

    int makeCustomer(String name, String address, String tel) {
        customers.put(CUSTOMER_NUM, new Customer(CUSTOMER_NUM, name, address, tel));
        return CUSTOMER_NUM++;
    }

    Customer getCustomer(int c_num){
        if(isCustomer(c_num))
            return customers.get(c_num);
        return null;
    }

    void removeCustomer(int c_num){
        if(isCustomer(c_num)){
            customers.remove(c_num);
        }
    }

    void editCustomer(int c_num, String name, String address, String tel){
        if(isCustomer(c_num)){
            customers.get(c_num).setName(name);
            customers.get(c_num).setAddress(address);
            customers.get(c_num).setTel(tel);
        }
    }
}