package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {

	public static void main(String[] args) {
		HashMap<Integer, FootballPlayer> myTeam = new HashMap<>(); //MAP이라고 해도됨 (상속관계여서)
//		Map<Integer, FootballPlayer> myTeam = new HashMap<>();
		
		myTeam.put(7,new FootballPlayer("손흥민" , 7 , "토트넘",30)); //7은 위에 Integer타입이랑 일치해야함
		
		FootballPlayer footballPlayer = myTeam.get(7);
		
		System.out.println(footballPlayer);
		
	}
}
