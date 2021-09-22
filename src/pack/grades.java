package pack;

public class grades implements interfac{
	//declare variables
	String name; int score; int total;
	public grades(String name, int score, int total) {
		//instantiates variables
		this.name=name;
		this.score=score;
		this.total=total;
	}
	//return string score
	public int returnscore() {
		return score;
	}
	//return string total
	public int returntotal() {
		return total;
	}
	//return string name
	public String returnname() {
		return name;
	}
}

