package com.customer;

public class Customer {
    private final int cus_num;
    private String name;
    private String address;
    private String tel;

    Customer(int c_num, String name, String address, String tel) {
        cus_num = c_num;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    String getTel() {
        return tel;
    }

    void setTel(String tel) {
        this.tel = tel;
    }

    public int getCus_num() {
        return cus_num;
    }

    @Override
    public String toString() {
        return Integer.toString(cus_num) + name + address + tel;
    }
}