package pack;

import java.util.ArrayList;
import java.util.Iterator;

public class student {
	//declares stuff
	String fname;String lname;int id;
	ArrayList<classes> cl;
	public student(String fname,String lname,int id) {
		//instantiates stuff
		this.fname=fname;
		this.lname=lname;
		this.id=id;
		cl = new ArrayList<classes>();
	}
	//return string fname
	public String returnfname() {
		return fname;
	}
	//return string lname
	public String returnlname() {
		return lname;
	}
	//return int id
	public int returnid() {
		return id;
	}
	//adds a new class to the arraylist
	public void addClass(String name, String room, String teacher) {
		cl.add(new classes(name,room,teacher));
	}
	//removes a class from the arraylist
	public void removeClass(String n) {
		Iterator<classes> itr = cl.iterator();
		while(itr.hasNext()) {
			if(itr.next().returnname().equalsIgnoreCase(n)) {
				itr.remove();
			}
		}
	}
}
