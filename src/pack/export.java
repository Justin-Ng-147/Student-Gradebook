package pack;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class export{
	public static void write(sheets s, ArrayList<student> st) {
		int place = 0;
		//goes through the array lists and creates an excel sheet
		for(int a = 0; a < st.size();a++) {
	    	for(int b = 0; b<st.get(a).cl.size();b++) {
	    		for(int c = 0; c<st.get(a).cl.get(b).gr.size();c++) {
	    			s.addGrade(st.get(a).cl.get(b).gr.get(c) , st.get(a).cl.get(b), st.get(a), place);
	    			place++;
	    		}
	    		s.addCLass(st.get(a).cl.get(b), st.get(a), place);
	    		place++;
	    	}
	    	s.addStudent(st.get(a), place);
	    	place++;
	    }
		//exports the excel sheet as a .xls file
		try {
		    FileOutputStream fileOut = new FileOutputStream(new File("D:/workbook.xls"));
		    s.wb.write(fileOut);
		    fileOut.flush();
		    fileOut.close();
		    }
		catch(Exception e){
		    System.out.println(e);
		    }
	}
	public static void write(sheets s) {
		//exports a blank .xls file
		try {
		    FileOutputStream fileOut = new FileOutputStream(new File("F:/workbook.xls"));
		    s.wb.write(fileOut);
		    fileOut.flush();
		    fileOut.close();
		    }
		catch(Exception e){
		    System.out.println(e);
		    }
	}
}
