import org.junit.jupiter.api.Test;
import ships.Ship;
import ships.ShipCalculator;
import ships.WeaponSystem;
import ships.ReadDBShips;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class ShipTest {

    @Test
    void testConstructorAndGetters() {
        List<String> weapons = Arrays.asList("Laser", "Missile", "Cannon");
        WeaponSystem weaponSystem = new WeaponSystem(weapons);

        Ship ship = new Ship("Aurora", "Battleship", 30.5, weaponSystem);

        assertEquals("Aurora", ship.getName());
        assertEquals("Battleship", ship.getType());
        assertEquals(30.5, ship.getSpeed(), 0.01);
        assertEquals(weaponSystem, ship.getWeaponSystem());
    }

    @Test
    void testSetters() {
        List<String> weapons = Arrays.asList("Laser", "Missile", "Cannon");
        WeaponSystem weaponSystem = new WeaponSystem(weapons);

        Ship ship = new Ship("", "", 0, null);

        ship.setName("Enterprise");
        ship.setType("Starship");
        ship.setSpeed(60.8);
        ship.setWeaponSystem(weaponSystem);

        assertEquals("Enterprise", ship.getName());
        assertEquals("Starship", ship.getType());
        assertEquals(60.8, ship.getSpeed(), 0.01);
        assertEquals(weaponSystem, ship.getWeaponSystem());
    }

    @Test
    void testToString() {
        List<String> weapons = Arrays.asList("Laser", "Missile", "Cannon");
        WeaponSystem weaponSystem = new WeaponSystem(weapons);

        Ship ship = new Ship("Defiance", "Destroyer", 40.2, weaponSystem);

        String expected = "Ship{name='Defiance', type='Destroyer', speed=40.2, weaponSystem=WeaponSystem{weapons=[Laser, Missile, Cannon]";
        assertTrue(ship.toString().startsWith(expected));
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testSortBySpeedDescending() {
        List<Ship> ships = Arrays.asList(
                new Ship("Aurora", "Battleship", 30.5, new WeaponSystem(List.of())),
                new Ship("Enterprise", "Starship", 60.8, new WeaponSystem(List.of())),
                new Ship("Defiance", "Destroyer", 40.2, new WeaponSystem(List.of()))
        );

        List<Ship> sortedShips = ShipCalculator.sortBySpeedDescending(ships);

        assertEquals("Enterprise", sortedShips.get(0).getName());
        assertEquals("Defiance", sortedShips.get(1).getName());
        assertEquals("Aurora", sortedShips.get(2).getName());
    }

    @Test
    void testCalculateAverageSpeed() {
        List<Ship> ships = Arrays.asList(
                new Ship("Aurora", "Battleship", 30.5, new WeaponSystem(Arrays.asList())),
                new Ship("Enterprise", "Starship", 60.8, new WeaponSystem(Arrays.asList())),
                new Ship("Defiance", "Destroyer", 40.2, new WeaponSystem(Arrays.asList()))
        );

        double averageSpeed = ShipCalculator.calculateAverageSpeed(ships);
        assertEquals(43.83, averageSpeed, 0.01);

        // Проверка на пустой список
        assertEquals(0, ShipCalculator.calculateAverageSpeed(List.of()), 0.01);
    }

    @Test
    void testGetTopWeapons() {
        List<Ship> ships = Arrays.asList(
                new Ship("Aurora", "Battleship", 30.5, new WeaponSystem(Arrays.asList("Laser", "Missile"))),
                new Ship("Enterprise", "Starship", 60.8, new WeaponSystem(Arrays.asList("Laser", "Cannon"))),
                new Ship("Defiance", "Destroyer", 40.2, new WeaponSystem(Arrays.asList("Missile", "Cannon")))
        );

        // Проверка на пустой список
        assertTrue(ShipCalculator.getTopWeapons(List.of()).isEmpty());
    }

    @Test
    void testCalculateTotalPower() {
        List<Ship> ships = Arrays.asList(
                new Ship("Aurora", "Battleship", 30.5, new WeaponSystem(Arrays.asList("Laser", "Missile"))),
                new Ship("Enterprise", "Starship", 60.8, new WeaponSystem(Arrays.asList("Laser", "Cannon"))),
                new Ship("Defiance", "Destroyer", 40.2, new WeaponSystem(Arrays.asList("Missile", "Cannon")))
        );

        double totalPower = ShipCalculator.calculateTotalPower(ships);
        assertEquals(263.0, totalPower, 0.01);

        // Проверка на пустой список
        assertEquals(0, ShipCalculator.calculateTotalPower(List.of()), 0.01);
    }

    @Test
    void testFilterShipsByType() {
        List<Ship> ships = Arrays.asList(
                new Ship("Aurora", "Battleship", 30.5, new WeaponSystem(Arrays.asList())),
                new Ship("Enterprise", "Starship", 60.8, new WeaponSystem(Arrays.asList())),
                new Ship("Defiance", "Destroyer", 40.2, new WeaponSystem(Arrays.asList())),
                new Ship("Voyager", "Starship", 50.0, new WeaponSystem(Arrays.asList()))
        );

        List<Ship> filteredShips = ShipCalculator.filterShipsByType(ships, "Starship");
        assertEquals(2, filteredShips.size());
        assertEquals("Enterprise", filteredShips.get(0).getName());
        assertEquals("Voyager", filteredShips.get(1).getName());

        // Проверка на несуществующий тип
        assertTrue(ShipCalculator.filterShipsByType(ships, "Cruiser").isEmpty());
    }

    //UNTESTED
    @Test
    void testReadDBShips() throws SQLException {
        /*
        ReadDBShips reader = new ReadDBShips(
                "jdbc:postgresql://localhost:5432/ships_db",
                "your_username",
                "your_password"
        );

        //List<Ship> ships = reader.getAllShips();

        // Проверяем, что список не пустой
        //assertFalse(ships.isEmpty());

        // Проверяем, что все корабли имеют корректные данные
        //for (Ship ship : ships) {
        //
        //}

         */
    }
}
