package pack;

import java.util.ArrayList;

public class classes {
	//declares variables
	String name;
	String room;
	String teacher;
	ArrayList<grades> gr;
	public classes(String name, String room, String teacher) {
		//initiates variables
		this.name=name;
		this.room=room;
		this.teacher=teacher;
		gr=new ArrayList<grades>();
	}
	//returns String name
	public String returnname() {
		return name;
	}
	//return String room
	public String returnroom() {
		return room;
	}
	//return String teacher
	public String returnteacher() {
		return teacher;
	}
	//adds a grade object to the arraylist
	public void addGrade(String name, int score, int total) {
		gr.add(new grades(name,score,total));
	}
	// removes a grade object from the arrraylist
	public void removeGrade(String n) {
		for(int i = 0;i<gr.size();i++) {
			if(gr.get(i).returnname().equalsIgnoreCase(n)) {
				gr.remove(i);
			}
		}
	}
	//calculates the percent of the class by adding the total score and dividing by the total points
	public double calculatepercent() {
		int totalpoints = 0;
		int totalscore = 0;
		for(int i = 0; i<gr.size();i++) {
			totalpoints += gr.get(i).returntotal();
			totalscore += gr.get(i).returnscore();
		}
		return (totalscore/totalpoints);
	}
}
