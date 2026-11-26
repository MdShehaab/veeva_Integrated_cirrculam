package seleniumWebDriver;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingInExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\excel\\new.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data1");
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Welcome");
		row1.createCell(1).setCellValue("6141");
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("hello");
		row2.createCell(1).setCellValue("6162");
		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("bye");
		row3.createCell(1).setCellValue("6158");
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File is created");
		

	}

}
