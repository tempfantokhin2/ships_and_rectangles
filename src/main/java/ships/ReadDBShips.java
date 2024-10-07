package ships;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadDBShips {

    private final String url;
    private final String username;
    private final String password;

    public ReadDBShips(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public List<Ship> getAllShips() {
        List<Ship> ships = new ArrayList<>();
        String sql = "SELECT id, name, type, speed FROM ships";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double speed = rs.getDouble("speed");
                //TO_DO
                List<String> weapons = Arrays.asList("Laser", "Missile", "Cannon");
                WeaponSystem weaponSystem = new WeaponSystem(weapons);

                Ship ship = new Ship(name, type, speed, weaponSystem);
                ships.add(ship);
            }

        } catch (SQLException e) {
            System.err.println("Ошибка при чтении данных о кораблях: " + e.getMessage());
        }

        return ships;
    }
}
