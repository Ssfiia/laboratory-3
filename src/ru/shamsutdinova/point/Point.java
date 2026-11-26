package ru.shamsutdinova.point;

public class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x; this.y = y; 
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    @Override
    public String toString() { return "{" + x + ";" + y + "}"; }

    @Override
    public boolean equals(Object o) {
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
}