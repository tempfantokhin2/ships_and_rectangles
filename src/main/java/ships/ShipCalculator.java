package ships;

import java.util.*;
import java.util.stream.Collectors;

public class ShipCalculator {

    public static List<Ship> sortBySpeedDescending(List<Ship> ships) {
        return ships.stream()
                .sorted(Comparator.comparingDouble(Ship::getSpeed).reversed())
                .collect(Collectors.toList());
    }

    public static double calculateAverageSpeed(List<Ship> ships) {
        return ships.stream()
                .mapToDouble(Ship::getSpeed)
                .average()
                .orElse(0);
    }

    public static List<String> getTopWeapons(List<Ship> ships) {
        Map<String, Integer> weaponCount = new HashMap<>();
        for (Ship ship : ships) {
            for (String weapon : ship.getWeaponSystem().getWeapons()) {
                weaponCount.put(weapon, weaponCount.getOrDefault(weapon, 0) + 1);
            }
        }

        return weaponCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static double calculateTotalPower(List<Ship> ships) {
        return ships.stream()
                .mapToDouble(ship -> ship.getSpeed() * ship.getWeaponSystem().getWeapons().size())
                .sum();
    }

    public static List<Ship> filterShipsByType(List<Ship> ships, String type) {
        return ships.stream()
                .filter(ship -> ship.getType().equals(type))
                .collect(Collectors.toList());
    }
}
