import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class readWorkBook {
    public static void read()throws IOException{

        FileInputStream out = new FileInputStream(new File("Database_stats.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(out);

        XSSFSheet sheet = workbook.getSheetAt(0);

        FormulaEvaluator formula = workbook.getCreationHelper().createFormulaEvaluator();

        for(Row row: sheet){
            for(Cell cell : row){
                switch (formula.evaluateInCell(cell).getCellType()){
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t\t\t");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t\t");
                        break;
                }
            }
            System.out.println();
        }
    }
}