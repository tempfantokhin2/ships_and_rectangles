package ships;

import java.util.List;

// Класс для хранения информации о системе вооружения
public class WeaponSystem {
    private List<String> weapons;

    public WeaponSystem(List<String> weapons) {
        this.weapons = weapons;
    }

    // Геттер и сеттер
    public List<String> getWeapons() { return weapons; }
    public void setWeapons(List<String> weapons) { this.weapons = weapons; }

    @Override
    public String toString() {
        return "WeaponSystem{" +
                "weapons=" + weapons +
                '}';
    }
}
