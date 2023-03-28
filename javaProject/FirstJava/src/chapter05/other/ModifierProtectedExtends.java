package chapter05.other;

import chapter05.ModifierProtected;

public class ModifierProtectedExtends extends ModifierProtected { // 상속
	
	//ModifierProtected이 가지고 있던 name, age, tell()을 상속받아서 따로 선언없이 멤버가 됨
	
	public static void main(String[] args) {
		ModifierProtectedExtends mpe = new ModifierProtectedExtends();
		mpe.name = "이강인";
		mpe.age = 30;
		mpe.tell();
	}
}
