package chapter04;

public class ForLoop2 {
	public static void main(String[] args) {
		// 행을 표현 -> 외부 Loop
		// 열을 표현 -> 내부 Loop
		for (int i =1;i < 10; i++) {
			for(int j =2; j<10; j++) {
				System.out.print(j+ " X "+i + " = " + i*j+ "\t");
				
			}
			System.out.println();
		}
//			for(int i = 2; i<10 ; i++) {
//            for (int j = 1; j < 10; j++) {
//                System.out.println(i + "*" + j + "=" + (i*j));
//            }
//            System.out.println();
//            
//        }
		
	}
}
