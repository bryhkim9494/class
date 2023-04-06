package quiz.chapter11;

import java.util.Objects;

public class FootballPlayer implements Comparable<FootballPlayer> {

	String name;
	int number;
	String team;
	int age;

	public FootballPlayer(String name, int number, String team, int age) {
		super();
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public FootballPlayer(String name) {
		super();
		this.name = name;
	}

	public FootballPlayer() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, number, team);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		FootballPlayer other = (FootballPlayer) obj;
//		return age == other.age && Objects.equals(name, other.name) && number == other.number
//				&& Objects.equals(team, other.team);
//	}


	
	public 
//	@Override
//	public int compareTo(FootballPlayer o) {
//		// TODO Auto-generated method stub
//		return name.compareTo(o.name);
//		
//
//	}
	
	@Override
	public int compareTo(FootballPlayer o) {

		int compare = this.team.compareTo(o.team);

		if(compare == 0) {
			compare = this.name.compareTo(o.name);

			if(compare == 0) {
				compare = this.number - o.number;
				//compare = Integer.compare(this.number, o.getNumber());
			}
		}
		return compare;
	}

//	@Override
//	public String toString() {
//		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]"+;
//	}
	public void showInfo() {
		System.out.printf("[%s] %s(%d, %d)\n", this.team, this.name, this.number, this.age);
	}

}
