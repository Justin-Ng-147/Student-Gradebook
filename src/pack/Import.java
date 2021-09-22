package pack;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Import {
	public static void merge(ArrayList<student> st) {
		try {
			//instantiates objects
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("D:/workbook.xls"));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows = sheet.getPhysicalNumberOfRows();

		    // gets number from first cell in each row to select which array list to add to
		    for(int r = rows; r >= 0; r--) {
		        row = sheet.getRow(r);
		        if(row != null) {
		           cell = row.getCell((short)0);
		           if(cell != null) {
		        	   switch((int)cell.getNumericCellValue()) {
		        	   case 0:
		        		   st.add(new student(row.getCell((short)3).getStringCellValue(),row.getCell((short)2).getStringCellValue(),(int)row.getCell((short)1).getNumericCellValue()));
		        		   break;
	        		   case 1:
	        			   for(int i = 0; i<st.size(); i++) {
	        				   if(st.get(i).returnid()==row.getCell((short)1).getNumericCellValue()) {
	        					   st.get(i).addClass(row.getCell((short)2).getStringCellValue(), row.getCell((short)3).getStringCellValue(), row.getCell((short)4).getStringCellValue());
	        				   }
	        			   }
	        			   break;
	        		    case 2:
	        		    	for(int i = 0; i<st.size(); i++) {
		        				   if(st.get(i).returnid()==row.getCell((short)1).getNumericCellValue()) {
		        					   for(int f = 0; f < st.get(i).cl.size(); f++) {
		        						   if(st.get(i).cl.get(f).returnname().equalsIgnoreCase(row.getCell((short)2).getStringCellValue())) {
		        							   st.get(i).cl.get(f).addGrade(row.getCell((short)3).getStringCellValue(), (int)row.getCell((short)4).getNumericCellValue(), (int)row.getCell((short)5).getNumericCellValue());
		        						   }
		        					   }
		        				   }
	        		    	}
	        		    	break;
		        	   }
		           }
		        }
		    }
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}
}
