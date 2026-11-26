package ru.shamsutdinova.weapon;

import ru.shamsutdinova.main.Shootable;

public abstract class Weapon implements Shootable {
    protected int ammo;

    public Weapon(int ammo) {
        if (ammo < 0) throw new RuntimeException("Отрицательное число патронов");
        this.ammo = ammo;
    }

    @Override
    public abstract void shoot();

    @Override
    public int ammo() { return ammo; }

    public boolean getAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    @Override
    public int load(int ammo) {
        if (ammo < 0) throw new RuntimeException("Отрицательное число патронов");
        int tmp = ammo;
        this.ammo = ammo;
        return tmp;
    }
}