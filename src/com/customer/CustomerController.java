package com.customer;

import java.util.HashMap;

public class CustomerController {
    private static int CUSTOMER_NUM = 0;
    private static CustomerController instance = new CustomerController();
    private static HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();

    private CustomerController() {

    }

    public static CustomerController getInstance() {
        return instance;
    }

    public int makeCustomer(String name, String address, String tel) {
        customers.put(CUSTOMER_NUM, new Customer(CUSTOMER_NUM, name, address, tel));
        return CUSTOMER_NUM++;
    }

    public Customer getCustomer(int c_num){
        if(customers.get(c_num) != null){
            return customers.get(c_num);
        }
        return null;
    }

    public boolean removeCustomer(int c_num){
        if(customers.get(c_num) != null){
            customers.remove(c_num);
            return true;
        }
        return false;
    }

    public boolean editCustomer(int c_num, String name, String address, String tel){
        if(customers.get(c_num) != null){
            customers.get(c_num).setName(name);
            customers.get(c_num).setAddress(address);
            customers.get(c_num).setTel(tel);
            return true;
        }
        return false;
    }
}