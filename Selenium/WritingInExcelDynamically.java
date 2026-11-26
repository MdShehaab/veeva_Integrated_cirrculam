package seleniumWebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingInExcelDynamically {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\excel\\dy.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data2");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of rows : ");
		int rows = sc.nextInt();
		System.out.println("Enter no of cols : ");
		int cols =  sc.nextInt();
		for(int r = 0 ; r <= rows ; r++) {
			XSSFRow newRow = sheet.createRow(r);
			for(int c = 0 ; c <= cols ; c++) {
				XSSFCell cell = newRow.createCell(c);
				cell.setCellValue(sc.next());
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File is created......");
	}

}
