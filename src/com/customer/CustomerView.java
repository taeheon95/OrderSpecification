package com.customer;

import java.util.Scanner;

import com.view.ModelView;

public class CustomerView implements ModelView {

    @Override
    public boolean view(Scanner sc) {
        int c_num;

        System.out.println("보려는 고객의 고객 번호를 입력해주세요.");

        c_num = sc.nextInt();
        return view(c_num);

    }

    @Override
    public boolean view(int c_num) {
        CustomerController controller = CustomerController.getInstance();
        Customer cus = controller.getCustomer(c_num);
        if(cus != null){
            System.out.println("회원 번호 : " + cus.getCus_num());
            System.out.println("이름 : " + cus.getName());
            System.out.println("주소 : " + cus.getAddress());
            System.out.println("전화 번호 : " + cus.getTel());
            return true;
        }
        else{
            System.out.println("존재하지 않는 회원 번호 입니다.");
            return false;
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
    public boolean edit(Scanner sc) {
        System.out.println("편집하려는 고객 번호를 입력해주세요.");
        int c_num = sc.nextInt();
        return edit(c_num, sc);
    }

    @Override
    public boolean edit(int c_num, Scanner sc) {
        CustomerController controller = CustomerController.getInstance();
        Customer customer = controller.getCustomer(c_num);
        String name, address, tel;

        if(customer != null){
            view(c_num);

            System.out.print("이름 : ");
            name = sc.next();
            System.out.println();

            System.out.print("주소 : ");
            address = sc.next();
            System.out.println();

            System.out.print("전화번호 : ");
            tel = sc.next();
            System.out.println();

            controller.editCustomer(c_num, name, address, tel);

            return true;
        }
        else{
            System.out.println("없는 회원 번호 입니다.");
            return false;
        }
    }

    @Override
    public boolean delete(Scanner sc) {
        CustomerController controller = CustomerController.getInstance();
        System.out.println("삭제할 회원(또는 당신)의 회원 번호를 입력해주세요.");
        int c_num = sc.nextInt();
        if(controller.isCustomer(c_num)){
            controller.removeCustomer(c_num);
            return true;
        }
        else{
            System.out.println("회원 번호가 잘못 되었습니다.");
            return false;
        }
    }
}
