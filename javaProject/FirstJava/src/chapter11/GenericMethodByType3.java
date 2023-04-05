package chapter11;

import chapter08.SmartPhone;
import chapter08.phone.Phone;

public class GenericMethodByType3 {

	public void introduce(MyClass<? super SmartPhone> t) {
		System.out.println("안녕하세요 . " + t.toString());
	}

	public static void main(String[] args) {
		GenericMethodByType3 byType = new GenericMethodByType3();

		MyClass<Phone> class1 = new MyClass<Phone>();

		class1.setVal(new SmartPhone());
		
		byType.introduce(class1);
//		byType.<String>introduce("1");
//		byType.<Integer>introduce(1);
//		byType.introduce("1");
//		byType.introduce(true);

	}
}
