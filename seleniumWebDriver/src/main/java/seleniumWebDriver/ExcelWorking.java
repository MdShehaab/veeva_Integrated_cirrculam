package seleniumWebDriver;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorking {
	//excelFile---->workbook--->sheet--->rows--->cells

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\excel\\tests.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int totalRow = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		System.out.println("Number of rows :" + totalRow);
		System.out.println("Number of cells :" + totalCells);
		for(int r = 0 ; r <= totalRow ; r++) {
			XSSFRow currRow =sheet.getRow(r);
			for(int c = 0 ; c<totalCells ; c++) {
				System.out.print(currRow.getCell(c).toString() + "\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

}
