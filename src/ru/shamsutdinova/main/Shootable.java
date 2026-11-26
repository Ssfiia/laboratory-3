package ru.shamsutdinova.main;

public interface Shootable {
    void shoot();
    int ammo();
    int load(int ammo);
    String toString();
}