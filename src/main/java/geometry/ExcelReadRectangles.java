package geometry;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.sql.Types.NUMERIC;
import static org.apache.xmlbeans.impl.piccolo.xml.Piccolo.STRING;

public class ExcelReadRectangles {

    public static List<Rectangle> readRectanglesFromExcel(String filePath) throws IOException {
        List<Rectangle> rectangles = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Берем первую страницу

            //Row headerRow = rowIterator.next(); // Пропускаем заголовок

            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();

                List<Double> dimensions = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    dimensions.add(cell.getNumericCellValue());
                    //dimensions.add(Double.parseDouble(cell.getStringCellValue()));
                    }


                if (dimensions.size() == 2) {
                    Rectangle rectangle = new Rectangle(dimensions);
                    rectangles.add(rectangle);
                }
            }
        }

        return rectangles;
    }
}
