package quiz;

public class StudentMain {
	public static void main(String[] args) {
		
		Student[] student = new Student[10];
		
		student[0] = new Student("손흥민",30,40,50);
		student[1] = new Student("손흥민",30,40,50);
		student[2] = new Student("손흥민",30,40,50);
		student[3] = new Student("손흥민",30,40,50);
		student[4] = new Student("손흥민",30,40,50);
		student[5] = new Student("손흥민",30,40,50);
		student[6] = new Student("손흥민",30,40,50);
		student[7] = new Student("손흥민",30,40,50);
		student[8] = new Student("손흥민",30,40,50);
		student[9] = new Student("손흥민",30,40,50);
		
//		Student student2 = new Student("손흥민",30,40,50);
//		System.out.println(student2.getEnglishScore());
		for (int i=0; i < student.length;i++) {
			System.out.println(student[i].getName()+"\t" + student[i].getKoreanScore()+"\t"+ student[i].getEnglishScore()+"\t" + student[i].getMathScore()) ;
		}
		Student student2 = new Student();
		student2.avg();
		
//		Studen
//		student2.total();
//		student2.avg();
	}
}
