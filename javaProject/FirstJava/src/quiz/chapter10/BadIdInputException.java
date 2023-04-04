package quiz.chapter10;

public class BadIdInputException extends Exception {

	public BadIdInputException(String message) {
		super("사용자의 입력 값이 올바르지 않습니다.");
		
	}

	
	
}
