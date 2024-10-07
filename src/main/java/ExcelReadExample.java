import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelReadExample {
    public static void main(String[] args) throws Exception {
        try (FileInputStream fis = new FileInputStream("Example1.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // Обработка различных типов данных в ячейках
                    System.out.print(cell.toString() + "; ");
                }
                System.out.println();  // Начало новой строки
            }
        }
    }
}