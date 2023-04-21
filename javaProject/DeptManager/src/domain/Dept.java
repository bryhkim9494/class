package domain;

// DTO : Java Beans

// Java Beans 특징: 모든 변수가 private처리되어야하니까 getter/setter메소드가 있어야함, 기본생성자가 반드시 존재해야함!

public class Dept { // Dept클래스:  데이터(deptno,dname,loc)를 저장하는 목적 

	private int deptno; // 컬럼이름과 동일하게!!!
	private String dname;
	private String loc;

	// 기본 생성자
	public Dept() {
		super();

	}

	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

}
