package quiz.chapter11;

import java.util.TreeSet;

public class FootballPlayerTreeSet {

	public static void main(String[] args) {
		TreeSet<FootballPlayer> treeSet = new TreeSet<>();

		treeSet.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
		treeSet.add(new FootballPlayer("이강인", 10, "마요르카", 20));
		treeSet.add(new FootballPlayer("박지성", 7, "맨유", 40));
		treeSet.add(new FootballPlayer("안정환", 7, "토트넘", 30));
		treeSet.add(new FootballPlayer("안정환", 15, "토트넘", 30));

		for (FootballPlayer player : treeSet) {
			player.showInfo();
		}

	}

}
