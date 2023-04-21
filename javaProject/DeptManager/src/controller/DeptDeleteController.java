package controller;

import java.util.List;

import dao.DeptDao;
import domain.Dept;
import main.DeptManagerMain;
import service.DeptDeleteService;
import service.DeptListService;

public class DeptDeleteController {
	
	DeptListService listService;
	DeptDeleteService deleteService;

	public DeptDeleteController() {
		super();
		// TODO Auto-generated constructor stub
		this.listService = new DeptListService(new DeptDao());
		this.deleteService = new DeptDeleteService();
	}

	public void deleteDept() {
		// 1. 사용자로부터 삭제할 부서번호를 받는다
		// 부서의 전체 리스트를 출력하고 번호 입력 요청
		int deptno = getDeptno();

		// 2. 부서번호를 Service에 전달해서 삭제 요청을하고 삭제 결과를 받음 (결과 기댓값은 0 or 1)
		int result = deleteService.deleteDept(deptno);
		
		// 3. 삭제후 결과 데이터에 따라 결과 화면 생성
		printData(result);
		
	}
	
	private void printData(int result) {
		if (result > 0) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제할 대상 부서가 존재하지 않습니다.");
		}
		
	}
	

	private int getDeptno() {
		int deptno = 0;
		System.out.println("부서 정보 삭제가 진행됩니다.");

		// 전체 리스트 출력
		List<Dept> list = listService.getDeptList();
		for (Dept d : list) {
			System.out.println(d);
		}
		System.out.println("삭제하고자하는 부서번호를 입력하세요.>>>");
		deptno = Integer.parseInt(DeptManagerMain.sc.nextLine());
		return deptno;
	}
//-----------------------------------------------------------------------------
	public static void main(String[] args) {
		DeptDeleteController controller = new DeptDeleteController();
		
		int deptno= controller.getDeptno();
		System.out.println("결과 : " + deptno);

	}
}