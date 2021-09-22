package pack;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class sheets extends sheetsabstract{
	//declare objects
	Workbook wb;
	CreationHelper createHelper;
	Sheet sheet;
	public sheets() {
		//instantiates objects
		wb = new HSSFWorkbook();
		createHelper = wb.getCreationHelper();
		sheet = wb.createSheet("new sheet");
	}
	//adds student constructors to a row
	public void addStudent(student st, int a) {
		Row row = sheet.createRow((short)a);
		row.createCell(0).setCellValue(0);
		row.createCell(1).setCellValue(st.returnid());
		row.createCell(2).setCellValue(st.returnlname());
		row.createCell(3).setCellValue(st.returnfname());
	}
	//adds grade constructors to a row
	public void addGrade(grades gr, classes cl, student st, int a) {
		Row row = sheet.createRow((short)a);
		row.createCell(0).setCellValue(2);
		row.createCell(1).setCellValue(st.returnid());
		row.createCell(2).setCellValue(cl.returnname());
		row.createCell(3).setCellValue(gr.returnname());
		row.createCell(4).setCellValue(gr.returnscore());
		row.createCell(5).setCellValue(gr.returntotal());
	}
	//adds class constructors to a row
	public void addCLass(classes cl, student st, int a) {
		Row row = sheet.createRow((short)a);
		row.createCell(0).setCellValue(1);
		row.createCell(1).setCellValue(st.returnid());
		row.createCell(2).setCellValue(cl.returnname());
		row.createCell(3).setCellValue(cl.returnroom());
		row.createCell(4).setCellValue(cl.returnteacher());
	}
}
