import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
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

        ArrayList<String> words = Database.uniqueWords();
        ArrayList<Integer> digits = Database.uniqueDigits();

        for(int row = 0; row < ((words.size()>digits.size()?words.size():digits.size())>10?(words.size()>digits.size()?words.size():digits.size()):10) + 2; row++) {
            sheet.createRow(row);
            for(int column = 0; column < 4; column++) {
                sheet.getRow(row).createCell(column);
            }
        }

        XSSFCellStyle zolte = workbook.createCellStyle();
        zolte.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        zolte.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        zolte.setAlignment(HorizontalAlignment.CENTER);
        zolte.setBorderBottom(BorderStyle.THICK);
        zolte.setBorderTop(BorderStyle.THICK);
        zolte.setBorderLeft(BorderStyle.THICK);
        zolte.setBorderRight(BorderStyle.THICK);

        sheet.getRow(0).getCell(0).setCellValue("Dane statystyczne: Database.txt");
        for (int i = 0; i <= 3 ; i++) {
            sheet.getRow(0).getCell(i).setCellStyle(zolte);
        }

        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

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

        XSSFCellStyle headers = workbook.createCellStyle();
        headers.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
        headers.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headers.setBorderBottom(BorderStyle.MEDIUM);
        headers.setBorderTop(BorderStyle.MEDIUM);
        headers.setBorderLeft(BorderStyle.MEDIUM);
        headers.setBorderRight(BorderStyle.MEDIUM);


        XSSFCellStyle results = workbook.createCellStyle();
        results.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        results.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        results.setBorderBottom(BorderStyle.THIN);
        results.setBorderTop(BorderStyle.THIN);
        results.setBorderLeft(BorderStyle.THIN);
        results.setBorderRight(BorderStyle.THIN);


        for (int i = 1; i <= 9; i++) {
            sheet.getRow(i).getCell(0).setCellStyle(headers);
            sheet.getRow(i).getCell(1).setCellStyle(results);
        }

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
        sheet.getRow(1).getCell(2).setCellStyle(headers);
        sheet.getRow(1).getCell(3).setCellStyle(headers);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);

        XSSFCellStyle wordig = workbook.createCellStyle();
        wordig.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
        wordig.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        wordig.setBorderBottom(BorderStyle.THIN);
        wordig.setBorderTop(BorderStyle.THIN);
        wordig.setBorderLeft(BorderStyle.THIN);
        wordig.setBorderRight(BorderStyle.THIN);


        for (int i = 0; i < words.size(); i++) {
            sheet.getRow(i + 2).getCell(2).setCellValue(words.get(i));
            sheet.getRow(i + 2).getCell(2).setCellStyle(wordig);
        }

        for (int i = 0; i < digits.size(); i++) {
            sheet.getRow(i + 2).getCell(3).setCellValue(digits.get(i));
            sheet.getRow(i + 2).getCell(3).setCellStyle(wordig);
        }


        FileOutputStream fileOut = new FileOutputStream(excelFileName);

        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();


    }
}
