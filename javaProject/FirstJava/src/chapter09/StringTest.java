package chapter09;

public class StringTest {

	public static void main(String[] args) {
		String str1 = "String";
		String str2 = "String";

		String str3 = new String("String");
		System.out.println(str1 == str2); // 앞에 str1곳에 "String"을 저장해놔서 str2도 거길 가리킨다.
		System.out.println(str1 == str3);// new String은 새로운곳에 별도로 "String"을 저장해서 다르다고 나옴(=st1과 str3객체는 서로 다름)

		System.out.println("str1.equals(str3) => " + str1.equals(str3)); // 참조값비교는 == 안에있는 문자값 비교는 equals로 한다

		// 특정 타입의 데이터를 => String 타입으로 변경
		String str4 = "" + 1;
		String str5 = String.valueOf(1);
		String str6 = new String();
		System.out.println(str5.toString());
		System.out.println(str5);
		String str = "Hello~";
		// 012345 <- index
//		System.out.println(str.charAt(0));
//		System.out.println(str.charAt(1));
//		System.out.println(str.charAt(2));
//		System.out.println(str.charAt(3));
//		System.out.println(str.charAt(4));
//		System.out.println(str.charAt(5));
		System.out.println(str.length());// 문자열의 길이 : 문자의 개수
		// index의 범위 : 0 ~ str.length()-1

		// 반복문
		// 문자열 출력

		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) + " ");
		}
		System.out.println();
		System.out.println();
		// 문자열 역순으로 출력하는 방법 : 5 ,4, 3,2,1,0
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i) + " ");
		}

		// compareTo는 같다 비교보다 크다 작다를 비교해서 정렬하려고 사용하는 메소드 , 같은 문자열 비교에는 compareTo을 사용하지않고 equals메소드 사용
		System.out.println();
		System.out.println();

		System.out.println(str.compareTo("Hello~~"));
		System.out.println(str.compareTo("Hello~"));
		System.out.println(str.compareTo("Hello"));
		
		
		System.out.println("------------------------------------");
		// 문자열을 붙인다! (concat) = > "" + "" => concat(String s)
		System.out.println(str.concat(" JAVA!!!"));
		System.out.println("------------------------------------");
		
		// 문자열에 특정 문자열을 포함여부 확인하는 메소드(contains) => boolean
		System.out.println(str.contains("lo"));
		System.out.println(str.contains("He"));
		System.out.println(str.contains("bye"));
		
		String file1 = "phone.jpg";
		String file2 = "java.pdf";
		
		if(file2.endsWith(".jpg") || file2.endsWith(".png")) {
			System.out.println("업로드가 가능합니다.");
		} else {
			System.out.println("확장자가 .jpg인 파일만 업로드가 가능합니다.");
		}
		
		//equals => 저장하고있는 문자열을 비교
		//compareTo랑 비교하기 
		
		System.out.println(str.equals("Hello~")); 
		
		//문자열의 사이즈 체크 : isEmpty() => str.length() == 0//
		System.out.println(str.isEmpty());
		System.out.println("".isEmpty());
		System.out.println(" ".isEmpty());
		
		//문자열의 개수
		System.out.println(str.length());
		
		System.out.println("===============================");
		System.out.println(str);
		System.out.println();
//		System.out.println(str.replace('~','!'));
		System.out.println(str.replace("Hello","JAVA"));
		
		
		// 시작하는 문자열 체크(startsWith)  --->  ex) http://localhost:80
		String url = "http://localhost:80/member/login.jsp";
		System.out.println(url.startsWith("http://"));
		String domain = "http://localhost:80/";
		System.out.println(url.substring(7));
		System.out.println(url.substring(7,12));
		System.out.println(domain.length());
		System.out.println(url.substring(domain.length()));
		
		// trim() :공백제거
		
		String str7 = "     Hello   Java     ";
		System.out.println(str7);
		System.out.println(str7.trim());//  trim메소드는 양쪽 끝에 공백을 제거함(가운데 공백은 제거x)
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
