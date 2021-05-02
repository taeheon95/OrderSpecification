package com.customer;

public class SpecialCustomer extends Customer {
    private final int memberNum;

    public SpecialCustomer(int c_num, int m_num, String name, String address, String tel) {
        super(c_num, name, address, tel);
        this.memberNum = m_num;
    }

    @Override
    public String toString() {
        return "SpecialCustomer [memberNum=" + memberNum + ", Name=" + getName() + ", Address" + getAddress()
                + ", Tel=" + getTel() + ", Cus_num=" + getCus_num() + "]";
    }


}