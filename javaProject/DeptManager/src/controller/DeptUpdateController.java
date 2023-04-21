package controller;

import java.util.List;
import domain.Dept;
import main.DeptManagerMain;
import service.DeptListService;
import service.DeptSearchService;
import service.DeptUpdateService;

public class DeptUpdateController {

	DeptListService listService;
	DeptSearchService searchService;
	DeptUpdateService updateService; // 여기서 선언

	private DeptUpdateController() {
		super();
		// TODO Auto-generated constructor stub

		this.listService = DeptListService.getInstance();
		this.searchService = DeptSearchService.getInstance();
		this.updateService = DeptUpdateService.getInstance(); // 생성자통해서 초기화
	}

	private static DeptUpdateController controller = new DeptUpdateController();

	public static DeptUpdateController getInstance() {
		return controller;
	}

	public void updateDept() {
		// 1. 수정하고자하는 데이터를 사용자로 부터 받아서 => Dept
		Dept newDept = inputUpdateDept();
		// 2. Service 클래스에 Dept를 전달해서 수정처리하고 결과를 반환( 결과는 1 or 0)
		int result = updateService.updateDept(newDept);
		// 3. 결과 값에 따른 결과 출력
		printData(result);

	}

	private void printData(int result) {
		if (result > 0) {
			System.out.println("수정되었습니다.");

		} else {
			System.out.println("수정 실패. (입력시 데이터를 확인후 입력해주세요.)");
		}
	}

	private Dept inputUpdateDept() {

		// 1. 수정하고자 하는 부서번호를 입력하세요.
		System.out.println("부서정보 수정을 시작합니다.");
		// 전체리스트 출력
		System.out.println();
		List<Dept> list = listService.getDeptList(); // list 출력
		System.out.println("-------------------------------------------");
		for (Dept d : list) {
			System.out.println(d.getDeptno() + "  / " + d.getDname() + "  /  " + d.getLoc());
		}
		System.out.println("-------------------------------------------");
		System.out.println("수정하고자하는 부서번호를 입력하세요.>>>");
		// 사용자가 부서번호를 입력
		int deptno = Integer.parseInt(DeptManagerMain.sc.nextLine());

		// 2. 해당 부서번호의 데이터를 가져와서 보여준다.
//		Dept dept = new Dept();
		Dept dept = searchService.searchDept(deptno); // 여기서 객체생성을 해주는게 아니라 DeptDao클래스에서 객체생성을 해서 return 값으로 반환해준걸 전달받아서
														// 사용함
		System.out.println("-------------------------------------------");
		System.out.println(dept);
		System.out.println("-------------------------------------------");

		// Dept => 사용자가 입력한 부서의 저장되어있는 데이터를 가지는 Dept

		// 3. 수정할 데이터를 입력 받아 => Dept로 반환해줌
		System.out.println(deptno + "번 부서의 정보 수정을 시작합니다.>>>");
		System.out.println("새로운 부서이름을 입력하세요");
		String newDname = DeptManagerMain.sc.nextLine();
		dept.setDname(newDname);
		System.out.println("새로운 위치 정보를 입력하세요.>>>");
		String newLoc = DeptManagerMain.sc.nextLine();
		dept.setLoc(newLoc);
		// dept => 새로 입력한 데이터를 가지는 Dept
		return dept;
	}

	public static void main(String[] args) {
		DeptUpdateController controller = new DeptUpdateController();
		Dept dept = controller.inputUpdateDept();
		System.out.println(dept);

	}

}
