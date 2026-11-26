
package seleniumWebDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils {

    // Get total number of rows
    public static int getRowCount(String xlfile, String xlsheet)
            throws IOException {

        try (FileInputStream fi = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {

            XSSFSheet ws = wb.getSheet(xlsheet);

            if (ws == null) {
                throw new IOException("Sheet not found: " + xlsheet);
            }

            return ws.getLastRowNum();
        }
    }

    // Get total number of cells in a row
    public static int getCellCount(String xlfile, String xlsheet, int rownum)
            throws IOException {

        try (FileInputStream fi = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {

            XSSFSheet ws = wb.getSheet(xlsheet);

            if (ws == null) {
                throw new IOException("Sheet not found: " + xlsheet);
            }

            XSSFRow row = ws.getRow(rownum);

            if (row == null) {
                return 0;
            }

            return row.getLastCellNum();
        }
    }

    // Get cell data
    public static String getCellData(String xlfile, String xlsheet,
            int rownum, int colnum) throws IOException {

        try (FileInputStream fi = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {

            XSSFSheet ws = wb.getSheet(xlsheet);

            if (ws == null) {
                throw new IOException("Sheet not found: " + xlsheet);
            }

            XSSFRow row = ws.getRow(rownum);

            if (row == null) {
                return "";
            }

            XSSFCell cell = row.getCell(colnum);

            if (cell == null) {
                return "";
            }

            DataFormatter formatter = new DataFormatter();

            return formatter.formatCellValue(cell);
        }
    }

    // Set cell data
    public static void setCellData(String xlfile, String xlsheet,
            int rownum, int colnum, String data) throws IOException {

        try (FileInputStream fi = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {

            XSSFSheet ws = wb.getSheet(xlsheet);

            if (ws == null) {
                throw new IOException("Sheet not found: " + xlsheet);
            }

            XSSFRow row = ws.getRow(rownum);

            if (row == null) {
                row = ws.createRow(rownum);
            }

            XSSFCell cell = row.getCell(colnum);

            if (cell == null) {
                cell = row.createCell(colnum);
            }

            cell.setCellValue(data);

            // Write updated data into Excel
            try (FileOutputStream fo = new FileOutputStream(xlfile)) {
                wb.write(fo);
            }
        }
    }

    // Fill Green Color
    public static void fillGreenColor(String xlfile, String xlsheet,
            int rownum, int colnum) throws IOException {

        fillColor(xlfile, xlsheet, rownum, colnum,
                IndexedColors.GREEN);
    }

    // Fill Red Color
    public static void fillRedColor(String xlfile, String xlsheet,
            int rownum, int colnum) throws IOException {

        fillColor(xlfile, xlsheet, rownum, colnum,
                IndexedColors.RED);
    }

    // Common method for applying cell colors
    private static void fillColor(String xlfile, String xlsheet,
            int rownum, int colnum, IndexedColors color) throws IOException {

        try (FileInputStream fi = new FileInputStream(xlfile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {

            XSSFSheet ws = wb.getSheet(xlsheet);

            if (ws == null) {
                throw new IOException("Sheet not found: " + xlsheet);
            }

            XSSFRow row = ws.getRow(rownum);

            if (row == null) {
                row = ws.createRow(rownum);
            }

            XSSFCell cell = row.getCell(colnum);

            if (cell == null) {
                cell = row.createCell(colnum);
            }

            CellStyle style = wb.createCellStyle();

            style.setFillForegroundColor(color.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cell.setCellStyle(style);

            // Save color changes
            try (FileOutputStream fo = new FileOutputStream(xlfile)) {
                wb.write(fo);
            }
        }
    }
}
