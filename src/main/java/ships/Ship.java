package ships;

import java.util.List;

public class Ship {
    private String name;
    private String type;
    private double speed;
    private WeaponSystem weaponSystem;

    public Ship(String name, String type, double speed, WeaponSystem weaponSystem) {
        this.name = name;
        this.type = type;
        this.speed = speed;
        this.weaponSystem = weaponSystem;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public WeaponSystem getWeaponSystem() { return weaponSystem; }
    public void setWeaponSystem(WeaponSystem weaponSystem) { this.weaponSystem = weaponSystem; }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", speed=" + speed +
                ", weaponSystem=" + weaponSystem +
                '}';
    }
}

