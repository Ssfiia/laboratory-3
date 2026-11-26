package ru.shamsutdinova.weapon;

public class MachineGun extends Gun {
    private int rate;

    public MachineGun(){ this(30, 30); }

    public MachineGun(int maxAmmo){ 
        this(maxAmmo, Math.max(1, maxAmmo / 2)); 
    }

    public MachineGun(int maxAmmo, int rate) {
        super(maxAmmo);
        if (rate <= 0) throw new RuntimeException("Скорострельность должна быть положительной");
        this.rate = rate;
    }

    public int getRate() { return rate; }

    @Override
    public void shoot() {
        for (int i = 0; i < rate; i++) super.shoot();
    }

    public void shootSeconds(int seconds) {
        if (seconds < 0) throw new RuntimeException("Время не может быть отрицательным");
        for (int i = 0; i < seconds * rate; i++) super.shoot();
    }

    @Override
    public String toString() {
        return "Автомат: " + ammo + "/" + getMaxAmmo() + ", скорострельность " + rate;
    }
}