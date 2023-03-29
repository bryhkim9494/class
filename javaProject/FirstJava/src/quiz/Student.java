package quiz;

public class Student {
	private String name;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	
	Student (String name,int koreanScore,int englishScore,int mathScore) {
		this.name = name;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	int total =koreanScore+englishScore+mathScore;
	void total() {
		System.out.println(total);
	}
	
	float avg = (float)total/3;
	void avg() {
		System.out.println(avg);
	}
}
