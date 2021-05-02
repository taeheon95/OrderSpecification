package com.customer;

import java.util.Scanner;

import com.view.ModelView;

public class CustomerView implements ModelView {

    @Override
    public void view(Scanner sc) {
        int id;

        System.out.println("보려는 고객의 고객 번호를 입력해주세요.");

        id = sc.nextInt();
        view(id);

    }

    @Override
    public void view(int id) {
        CustomerController controller = CustomerController.getInstance();
        Customer cus = controller.getCustomer(id);
        if(cus != null){
            System.out.println("회원 번호 : " + cus.getCus_num());
            System.out.println("이름 : " + cus.getName());
            System.out.println("주소 : " + cus.getAddress());
            System.out.println("전화 번호 : " + cus.getTel());
        }
        else{
            System.out.println("존재하지 않는 회원 번호 입니다.");
        }
    }

    @Override
    public void make(Scanner sc) {
        CustomerController controller = CustomerController.getInstance();
        String name, address, tel;
        int c_num;

        System.out.println("회원 가입");
        System.out.print("이름 : "); name = sc.next();
        System.out.print("주소 : "); address = sc.next();
        System.out.print("전화 번호 : "); tel = sc.next();
        System.out.println();

        c_num = controller.makeCustomer(name, address, tel);

        System.out.println("당신의 회원 번호는 " + c_num + "입니다");
    }

    @Override
    public void edit(Scanner sc) {
        System.out.println("편집하려는 고객 번호를 입력해주세요.");
        int id = sc.nextInt();
        edit(id, sc);
    }

    @Override
    public void edit(int id, Scanner sc) {
        CustomerController controller = CustomerController.getInstance();
        Customer customer = controller.getCustomer(id);
        String name, address, tel;

        if(customer != null){
            view(id);

            System.out.print("이름 : ");
            name = sc.next();
            System.out.println();

            System.out.print("주소 : ");
            address = sc.next();
            System.out.println();

            System.out.print("전화번호 : ");
            tel = sc.next();
            System.out.println();

            controller.editCustomer(id, name, address, tel);
        }
        else{
            System.out.println("없는 회원 번호 입니다.");
        }
    }

}
