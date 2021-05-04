package com.order;

import java.util.List;
import java.util.Scanner;

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
			System.out.println(order);
			System.out.println();
			System.out.println("========================주문 목록===============================");

			for(OrderSpecification os : order.getOrderSpecificationList()){
				System.out.println(os);
			}

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
		System.out.println("주문 입력 페이지 입니다.");
		System.out.print("당신의 회원 번호를 입력해주세요 : ");
		cus_num = sc.nextInt();
		int orderNum = orderController.makeOrder(cus_num);
		System.out.println("주문 번호는 " + orderNum + "입니다.");

		do{
			System.out.print("주문하려는 상품의 ID를 입력해주세요. : ");
			String productId = sc.next();
			System.out.print("주문하려는 상품의 수량을 입력해주세요 : ");
			int orderQuantity = sc.nextInt();

			if(!productController.productCanOrder(productId, orderQuantity)){
				System.out.println("주문 하려는 제품이 현재있는 수량보다 많습니다.");
				System.out.println("다시 입력해주세요.");
				continue;
			}

			OrderSpecification os = new OrderSpecification(productId, orderQuantity);
			productController.orderProductsWhereWareHouse(productId,orderQuantity);
			orderController.addOrderSpecification(orderNum, os);

			System.out.println("계속 입력하시겠습니까?(y/N)");
		}while(sc.next().equalsIgnoreCase("Y"));

		System.out.println("주문이 완료되었습니다.");
	}

	@Override
	public boolean edit(Scanner sc) {
		System.out.println("편집하려는 주문 번호를 입력해주세요. : ");
		int order_num = sc.nextInt();
		return edit(order_num, sc);
	}

	@Override
	public boolean edit(int order_num, Scanner sc) {
		Order order = orderController.getOrder(order_num);
		if(order != null){
			System.out.println("하려는 행동을 선택해주십시오. ");
			System.out.println("1. 전체 삭제 2. 부분 변경 3. 부분 삭제");
			String productId;
			do {
				switch (sc.nextInt()) {
					case 1:
						order.deleteAllProduct();
						break;
					case 2:
						order.getOrderSpecificationList().forEach(System.out::println);
						System.out.print("편집하려는 상품 Id를 입력해주세요. : ");
						productId = sc.next();
						OrderSpecification orderSpecification = order.getOrderSpecification(productId);
						orderSpecification.setOrderQuantity(sc.nextInt());
						break;
					case 3:
						order.getOrderSpecificationList().forEach(System.out::println);
						System.out.print("삭제하려는 상품 Id를 입력해주세요. : ");
						productId = sc.next();
						order.deleteProduct(productId);
						break;
					default:
						System.out.println("잘못 입력하셨습니다.");
				}
				System.out.println("계속 하시려면 y를 눌러주세요.");
			}while(sc.next().equalsIgnoreCase("y"));

			return true;
		}

		return false;
	}

	@Override
	public boolean delete(Scanner sc) {
		System.out.println("삭제하려는 주문 번호를 입력해주세요 : ");
		int order_num = sc.nextInt();
		return orderController.removeOrder(order_num);
	}

}
