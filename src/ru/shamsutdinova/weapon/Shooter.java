package ru.shamsutdinova.weapon;

import ru.shamsutdinova.main.Shootable;

public class Shooter {
    private String name;
    private Shootable weapon;

    public Shooter(String name, Shootable weapon) {
        setName(name);
        this.weapon = weapon;
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Имя не пустое");
        this.name = name;
    }

    public Shootable getWeapon() { return weapon; }

    public void setWeapon(Shootable weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon == null) {
            System.out.println(name + " не может выстрелить: у него нет оружия.");
        } else {
            weapon.shoot();
        }
    }

    @Override
    public String toString() {
        return "Стрелок " + name + " с " + (weapon == null ? "отсутствующим оружием" : weapon);
    }
}