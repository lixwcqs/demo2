package com.trial.effective.java;

import java.awt.*;

/**
 * Created by li on 2016/5/16.
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Point");

//        if(!(obj instanceof Point))
        System.out.println( obj.getClass() + "\t" + getClass());
        if(obj == null || ! obj.getClass().equals(getClass()))
            return false;
        Point p = (Point) obj;
        return  p.x == x && p.y == y;
    }

    public static void main(String[] args) {
        Point p = new Point(1,2);
        ColorPoint cp = new ColorPoint(1,2,Color.BLACK);
        System.out.println(p.equals(cp));
        System.out.println(cp.equals(p));
        System.out.println( null instanceof Object);
        System.out.println( null == null);
    }
}


class ColorPoint extends Point{
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }


    @Override
    public boolean equals(Object obj) {
        System.out.println("ColorPoint");
        if (!(obj instanceof ColorPoint)) return false;
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }
}
