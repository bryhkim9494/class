package chapter11;

public class MyInterfaceImpl<T1, T2> implements MyInterface<T1, T2> {

	@Override
	public T1 method1(T1 t) {

		return t;
	}

	@Override
	public T2 method2(T2 t) {

		return t;
	}

	public static void main(String[] args) {

		MyInterfaceImpl<String, Integer> my = null; // my는 메소드안에서 지역변수이므로 null값으로 초기화해야한다.

//		my = new MyInterfaceImpl<String, Integer>();
		my = new MyInterfaceImpl();// 인스턴스생성 , 위에랑 다르게 생략하고 인스턴스 생성 가능함

//		MyInterfaceImpl<String, Integer> my = new MyInterfaceImpl<String, Integer>();

		System.out.println(my.method1("KING"));
		System.out.println(my.method2(3));
	}

}
