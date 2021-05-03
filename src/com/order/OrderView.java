package com.order;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.customer.Customer;
import com.product.ProductController;
import com.view.ModelView;

public class OrderView implements ModelView{

	OrderController orderController = OrderController.getInstance();
	ProductController productController = ProductController.getInstance();

	@Override
	public boolean view(Scanner sc) {
		int order_num;

		System.out.println("보려는 주문 번호를 입려해주세요. : ");

		order_num = sc.nextInt();
		return view(order_num);
	}

	@Override
	public boolean view(int order_num) {
		Order order = orderController.getOrder(order_num);
		if(order != null){
			System.out.println("주문 번호 : " + order.getOrderNum());
			System.out.println("주문 고객 번호 : " + order.getCustomerNum());
			System.out.println("주문 날짜 :" + order.getDate());
			System.out.println("주문 목록");

			List<OrderSpecification> specificationList = order.getOrderSpecificationList();
			specificationList.forEach(System.out::println);

			return true;
		}
		else{
			System.out.println("주문이 존재하지 않습니다.");
			return false;
		}
	}

	@Override
	public void make(Scanner sc) {
		int cus_num;
		LinkedList<OrderSpecification> list = new LinkedList<>();
		System.out.println("주문 입력 페이지 입니다.");
		System.out.println("당신의 회원 번호를 입력해주세요");
		cus_num = sc.nextInt();

		boolean flag = true;
		while(flag){
			String productId;
			int orderQuantity;

			System.out.println("주문하려는 상품의 ID를 입력해주세요. : ");
			productId = sc.next();
			System.out.println("주문하려는 상품의 수량을 입력해주세요 : ");
			orderQuantity = sc.nextInt();
			if(!productController.productCanOrder(productId, orderQuantity)){
				System.out.println("주문 하려는 제품이 현재있는 수량보다 많습니다.");
				System.out.println("다시 입력해주세요.");
				continue;
			}
			double discount = 1.0;
			if(orderQuantity >= 1000)
				discount = 0.9;

			OrderSpecification os = new OrderSpecification(productId, orderQuantity, discount);
			list.add(os);

			System.out.println("계속 입력하시겠습니까?(y/N)");
			String flagChar = sc.next();
			if(flagChar.equalsIgnoreCase("N"))
				flag = false;
		}

		System.out.println("주문이 완료되었습니다.");
		System.out.println("주문 번호는 " + orderController.makeOrder(cus_num, list) + "입니다.");
	}

	@Override
	public boolean edit(Scanner sc) {
		System.out.println("편집하려는 주문 번호를 입력해주세요. : ");
		int order_num = sc.nextInt();
		return edit(order_num, sc);
	}

	@Override
	public boolean edit(int order_num, Scanner sc) {
		return false;
	}

	@Override
	public boolean delete(Scanner sc) {
		System.out.println("삭제하려는 주문 번호를 입력해주세요 : ");
		int order_num = sc.nextInt();
		return orderController.removeOrder(order_num);
	}

}
