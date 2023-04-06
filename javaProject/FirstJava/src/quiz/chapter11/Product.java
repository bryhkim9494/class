package quiz.chapter11;

import java.util.ArrayList;

public class Product {
	String name;
	int num;

	public Product(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", num=" + num + "]";
	}

	public static void main(String[] args) {
		ArrayList<Product> pList = new ArrayList<Product>();

		//  1.클래스의 객체를 직접 생성해서 add() 메소드로 리스트에 넣어주는 방법
		Product product = new Product("candy", 100);
		pList.add(product);
		
		//  2.add() 메소드에서 클래스 생성자를 통해 바로 리스트에 넣어주는 방법
		pList.add(new Product("snack", 200));
		
		System.out.println(pList.toString());
	}
}
