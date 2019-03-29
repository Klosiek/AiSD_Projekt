import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeWorkBook {
    public static void write()throws IOException{
        String excelFileName = "C:/Users/Klosiek/Desktop/AiSD_Projekt/Database_stats.xlsx";
        String sheetName = "Sheet1";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < 5; i++ ) {
            XSSFRow row = sheet.createRow(i);

            //iterating c number of columns
            for (int j = 0; j < 5; j++ ) {
                XSSFCell cell = row.createCell(j);

                cell.setCellValue("Cell "+j+" "+i);
            }
        }
        FileOutputStream fileOut = new FileOutputStream(excelFileName);

        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();

    }
}
