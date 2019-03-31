import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        analysisOfFile Database = new analysisOfFile();

        String excelFileName = "./Database_stats.xlsx";
        String sheetName = "Dane statystyczne";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        XSSFCellStyle zolte = workbook.createCellStyle();
        zolte.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        zolte.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        zolte.setAlignment(HorizontalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

        ArrayList<String> words = Database.uniqueWords();
        ArrayList<String> digits = Database.uniqueDigits();

        for(int row = 0; row < ((words.size()>digits.size()?words.size():digits.size())>10?(words.size()>digits.size()?words.size():digits.size()):10); row++) {
            sheet.createRow(row);
            for(int column = 0; column < 4; column++) {
                sheet.getRow(row).createCell(column);
            }
        }

        sheet.getRow(0).getCell(0).setCellValue("Dane statystyczne: Database.txt");
        sheet.getRow(0).getCell(0).setCellStyle(zolte);
        sheet.getRow(1).getCell(0).setCellValue("Iloœæ znaków");
        sheet.getRow(2).getCell(0).setCellValue("Iloœæ znaków bia³ych");
        sheet.getRow(3).getCell(0).setCellValue("Iloœæ linii tekstu w pliku");
        sheet.getRow(4).getCell(0).setCellValue("Iloœæ wielkich liter");
        sheet.getRow(5).getCell(0).setCellValue("Iloœæ ma³ych liter");
        sheet.getRow(6).getCell(0).setCellValue("Iloœæ znaków interpunkcyjnych");
        sheet.getRow(7).getCell(0).setCellValue("Iloœæ cyfr");
        sheet.getRow(8).getCell(0).setCellValue("Iloœæ s³ów");
        sheet.getRow(9).getCell(0).setCellValue("Iloœæ zdañ");
        sheet.setColumnWidth(0, 7500);

        sheet.getRow(1).getCell(1).setCellValue(Database.amountOfCharacters());
        sheet.getRow(2).getCell(1).setCellValue(Database.amountOfWhiteSpaces());
        sheet.getRow(3).getCell(1).setCellValue(Database.amountOfLines());
        sheet.getRow(4).getCell(1).setCellValue(Database.amountOfUpperCase());
        sheet.getRow(5).getCell(1).setCellValue(Database.amountOfLowerCase());
        sheet.getRow(6).getCell(1).setCellValue(Database.amountOfInterpunctionSigns());
        sheet.getRow(7).getCell(1).setCellValue(Database.amountOfDigitals());
        sheet.getRow(8).getCell(1).setCellValue(Database.amountOfWords());
        sheet.getRow(9).getCell(1).setCellValue(Database.amountOfSentences());

        sheet.getRow(1).getCell(2).setCellValue("S³owa bez powtórzeñ");
        sheet.getRow(1).getCell(3).setCellValue("Cyfry bez powtórzeñ");
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);


        for (int i = 2; i < words.size(); i++) {
            sheet.getRow(i).getCell(2).setCellValue(words.get(i-2));
        }

        for (int i = 2; i < digits.size(); i++) {
            sheet.getRow(i).getCell(3).setCellValue(digits.get(i-2));
        }



//        XSSFRow row1 = sheet.createRow(0);
//        XSSFCell cell1 = row1.createCell(0);
//        cell1.setCellValue("Dane statystyczne: Database.txt");
//        cell1.setCellStyle(style);


        FileOutputStream fileOut = new FileOutputStream(excelFileName);

        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();


    }
}
