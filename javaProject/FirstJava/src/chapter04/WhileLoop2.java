package chapter04;

public class WhileLoop2 {
	public static void main(String[] args) {
		int num = 1;
		while(num < 10) { //바깢쪽 while은 행을 표현
//			System.out.println("2 X " + num + " = " + num*2);
			
			int n = 2;
			while (n<10) {
				System.out.print(n+ " X " + num+" = " + n*num+"\t");
				n++;
			}
			
//			System.out.print("2 X " + num + " = " + num*2);
//			System.out.print("\t3 X " + num + " = " + num*3);
//			System.out.print("\t4 X " + num + " = " + num*3);
//			System.out.print("\t5 X " + num + " = " + num*3);
//			System.out.print("\t6 X " + num + " = " + num*3);
//			System.out.print("\t7 X " + num + " = " + num*3);
//			System.out.print("\t8 X " + num + " = " + num*3);
//			System.out.print("\t9 X " + num + " = " + num*3);
//			
			System.out.println();
			num++;
		}
	}
}
