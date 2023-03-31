package quiz.chepter8;

public abstract class Calculator2 implements Calculator {

	long num;
	long num2;
	
	

	public Calculator2(long num, long num2) {
		super();
		this.num = num;
		this.num2 = num2;
	}

//	@Override
//	public long add(long n1, long n2) {
//		// TODO Auto-generated method stub
//		return n1+n2;
//	}

	@Override
	public long substract(long n1, long n2) {
		// TODO Auto-generated method stub
		return n1-n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		// TODO Auto-generated method stub
		return n1*n2;
	}

	@Override
	public double divide(double n1, double n2) {
		// TODO Auto-generated method stub
		return n1/n2;
	}
	

}
