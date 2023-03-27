package chapter05;

public class ClassVariableMain {
	public static void main(String[] args) {
		System.out.println(ClassVariable.age);
		System.out.println(ClassVariable.name);
		
		ClassVariable cv = new ClassVariable();
		cv.tellName();
		cv.tellAge();
		
	}
}
