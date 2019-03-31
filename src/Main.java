import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        analysisOfFile Database = new analysisOfFile();

        String excelFileName = "./Database_stats.xlsx";
        String sheetName = "Sheet1";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        XSSFCellStyle style1 = workbook.createCellStyle();
        style1.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style1.setAlignment(HorizontalAlignment.CENTER);


        XSSFRow row1 = sheet.createRow(0);
        XSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("Dane statystyczne: Database.txt");
        cell1.setCellStyle(style1);
        sheet.autoSizeColumn(0);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));


        FileOutputStream fileOut = new FileOutputStream(excelFileName);

        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();


    }
}
