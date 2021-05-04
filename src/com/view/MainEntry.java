package com.view;

import com.customer.CustomerController;
import com.product.ProductController;
import com.order.OrderView;

import java.util.Scanner;

public class MainEntry {
    public static void main(String[] args) {
        ProductController productController = ProductController.getInstance();
        productController.addWareHouse("제 1 창고", "부산", "051-000-0000");
        productController.addProduct("a000", "휴대폰", 1000000);
        productController.addProduct("a001", "데스크탑", 3000000);
        productController.addProduct("a002", "태블릿", 1500000);
        productController.addProduct("a003", "노트북", 2000000);
        productController.setProductsIntoWareHouse("부산", "a000", 10000);
        productController.setProductsIntoWareHouse("부산", "a001", 10000);
        productController.setProductsIntoWareHouse("부산", "a002", 10000);
        productController.setProductsIntoWareHouse("부산", "a003", 10000);

        int cus_num = CustomerController.getInstance()
                .makeCustomer("여태헌", "부산", "010-0000-0000");
        System.out.println(cus_num);

        OrderView view = new OrderView();
        Scanner sc = new Scanner(System.in);
        view.make(sc);
        view.view(sc);
    }
}
