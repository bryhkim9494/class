package chapter02;

public class VarRefferenceType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str =null; // 참조변수 : 객체의 주소값 , null은 아직 주소값을 저장하고 있지 않다는것을 의미함.
		System.out.println(str);
		str= "JAVA"; // "문자열" -> String타입의 객체를 생성
		System.out.println(str); // str.toString();
		
		float f = 1;
		System.out.println(f);
		
		
	}

}
