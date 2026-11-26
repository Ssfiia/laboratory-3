package ru.shamsutdinova.weapon;

public class Gun extends Weapon {
    private final int maxAmmo;

    public Gun(int maxAmmo) {
        super(0);
        if (maxAmmo < 0) throw new RuntimeException("Отрицательная вместимость");
        this.maxAmmo = maxAmmo;
    }

    public int getMaxAmmo() { return maxAmmo; }

    public int reload(int count) {
        if (count < 0) throw new RuntimeException("Отрицательное число патронов");
        if (count > maxAmmo) {
            this.ammo = maxAmmo;
            return count - maxAmmo;
        }
        this.ammo = count;
        return 0;
    }

    public int unload() {
        int tmp = ammo;
        ammo = 0;
        return tmp;
    }

    public boolean isLoaded() { return ammo > 0; }

    @Override
    public void shoot() {
        if (getAmmo()) System.out.println("Бах!");
        else System.out.println("Клац!");
    }

    @Override
    public String toString() {
        return "Пистолет: " + ammo + "/" + maxAmmo;
    }
}