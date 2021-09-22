package pack;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class driver {
	public static void main(String args[]) {
		//declares and instantiate 
		Scanner scan = new Scanner(System.in);
		sheets sheet = new sheets();
		ArrayList<student> st = new ArrayList<student>();
		boolean save = false;
		int index=0;
		int temp = 0;
		Import.merge(st);
		student guy = null;
		classes classinuse = null;
		grades gradeinuse = null;
		
		while(!save) {
			index = temp;
			//start of swicth statement
			switch(index) {
			case 0:
				System.out.print("1: Manage Students"+"\n"+"2: Add Student"+"\n"+"3: Save"+"\n");
				temp = scan.nextInt();
				guy = null;
				classinuse = null;
				break;
			case 1:
				//chooses the student you are editing
				System.out.println("Enter The ID Of The Student You Want To Edit");
				for(int i=0;i<st.size();i++) {
					System.out.println(st.get(i).returnid()+" "+st.get(i).returnfname()+" "+st.get(i).returnlname());
				}
				int tag = scan.nextInt();
				for(int i=0;i<st.size();i++) {
					if(tag == st.get(i).returnid()) {
						guy = st.get(i);
					}
				}
				System.out.print("1: Delete Student"+"\n"+"2: Add Class"+"\n"+"3: Manage Classes"+"\n");
				temp = scan.nextInt()+3;
				break;
			case 2:
				//creates a new student
				System.out.println("Enter First Name: ");
				String fname = scan.next();
				System.out.println("Enter Last Name: ");
				String lname = scan.next();
				System.out.println("Enter Student ID: ");
				int id = scan.nextInt();
				st.add(new student(fname,lname,id));
				temp = 0;
				break;
			case 3:
				//ends while loop
				save=true;
				break;
			case 4:
				//deletes student
				for(int i = 0;i<st.size();i++) {
					if(st.get(i).returnid()==(guy.returnid())) {
						st.remove(i);
					}
				}
				temp = 0;
				break;
			case 5:
				//creates a new class
				System.out.println("Enter Name: ");
				String name = scan.next();
				System.out.println("Enter Room Number: ");
				String room = scan.next();
				System.out.println("Enter Name of Teacher: ");
				String teacher = scan.next();
				for(int i = 0;i<st.size();i++) {
					if(st.get(i).returnid()==(guy.returnid())) {
						st.get(i).addClass(name, room, teacher);;
					}
				}
				temp = 0;
				break;
			case 6:
				//chooses the class you want to edit
				System.out.println("Enter The Name Of The Class You Want To Edit");
				for(int i=0;i<guy.cl.size();i++) {
					int totalpoints = 0;
					int totalscore = 0;
					for(int f = 0;f<guy.cl.get(i).gr.size();f++) {
					totalpoints += (int)guy.cl.get(i).gr.get(f).returntotal();
					totalscore += (int)guy.cl.get(i).gr.get(f).returnscore();
					}
					double percent = ((double)totalscore/(double)totalpoints);
					System.out.print(guy.cl.get(i).returnname()+" "+(NumberFormat.getPercentInstance().format(percent))+" "+guy.cl.get(i).returnteacher()+" "+guy.cl.get(i).returnroom()+"\n");
				}
				String classid = scan.next();
				for(int i=0;i<guy.cl.size();i++) {
					if(classid.equalsIgnoreCase(guy.cl.get(i).returnname())) {
						classinuse = guy.cl.get(i);
					}
				}
				System.out.print("1: Delete Class"+"\n"+"2: Add Grade"+"\n"+"3: Manage Grades"+"\n");
				temp = scan.nextInt()+6;
				break;
			case 7:
				//deletes the selected class
				for(int f = 0;f<st.size();f++) {
					if(st.get(f).returnid()==(guy.returnid())) {
						for(int i = 0;i<guy.cl.size();i++) {
							if(st.get(f).cl.get(i).returnname().equalsIgnoreCase(classinuse.returnname())) {
								st.get(f).cl.remove(i);
							}
						}
					}
				}
				temp = 0;
				break;
			case 8:
				//adds a grade
				System.out.println("Enter Name");
				String gradename = scan.next();
				System.out.println("Enter Total Points");
				int tpoints = scan.nextInt();
				System.out.println("Enter Score");
				int score = scan.nextInt();
				for(int f = 0;f<st.size();f++) {
					if(st.get(f).returnid()==(guy.returnid())) {
						for(int i = 0;i<guy.cl.size();i++) {
							if(st.get(f).cl.get(i).returnname().equalsIgnoreCase(classinuse.returnname())) {
								st.get(f).cl.get(i).addGrade(gradename, score, tpoints);
							}
						}
					}
				}
				temp = 0;
				break;
			case 9:
				//chooses the grade you want to edit
				System.out.println("Enter The Name Of The Grade You Want To Edit");
				for(int f = 0;f<classinuse.gr.size();f++) {
					System.out.println(classinuse.gr.get(f).returnname()+" "+classinuse.gr.get(f).returnscore()+"/"+classinuse.gr.get(f).returntotal());
					}
				String gradeid = scan.next();
				for(int i=0;i<classinuse.gr.size();i++) {
					if(gradeid.equalsIgnoreCase(classinuse.gr.get(i).returnname())) {
						gradeinuse = classinuse.gr.get(i);
					}
				}
				System.out.print("1: Delete Grade"+"\n");
				temp = scan.nextInt()+9;
				break;
			case 10:
				//deletes the selected grade
				for(int f = 0;f<st.size();f++) {
					if(st.get(f).returnid()==(guy.returnid())) {
						for(int i = 0;i<guy.cl.size();i++) {
							if(st.get(f).cl.get(i).returnname().equalsIgnoreCase(classinuse.returnname())) {
								for(int e = 0;e<classinuse.gr.size();e++) {
									if(st.get(f).cl.get(i).gr.get(e).returnname().equalsIgnoreCase(gradeinuse.returnname())) {
										st.get(f).cl.get(i).gr.remove(e);
									}
								}
							}
						}
					}
				}
				temp = 0;
				break;
			}
		}
		//exports the array lists as an excel sheet
		export.write(sheet, st);
	} 
}
