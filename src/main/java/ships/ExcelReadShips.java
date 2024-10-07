package ships;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReadShips {

    public static List<Ship> readShipsFromExcel(String filePath) throws IOException {
        List<Ship> ships = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Берем первую страницу

            Iterator<Row> rowIterator = sheet.iterator();
            Row headerRow = rowIterator.next(); // Пропускаем заголовок

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                List<String> shipData = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    shipData.add(cell.getStringCellValue());
                }

                if (shipData.size() >= 4) {
                    String name = shipData.get(0);
                    String type = shipData.get(1);
                    double speed = Double.parseDouble(shipData.get(2));
                    List<String> weapons = shipData.subList(3, shipData.size());

                    WeaponSystem weaponSystem = new WeaponSystem(weapons);
                    Ship ship = new Ship(name, type, speed, weaponSystem);
                    ships.add(ship);
                }
            }
        }

        return ships;
    }
}
