package com.epam.rd.autotasks.figures;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;
class Triangle extends Figure{
    private Point a;
    private Point b;
    private Point c;
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a == null) {throw new IllegalArgumentException();}
        if (b == null) {throw new IllegalArgumentException();}
        if (c == null) {throw new IllegalArgumentException();}
        if ((a.getX()-b.getX())*(c.getY()-b.getY())-(a.getY()-b.getY())*(c.getX()-b.getX())==0)
            throw new IllegalArgumentException("Triangle is degenerative");
    }
    public Point getA() {return a;}
    public Point getB() {return b;}
    public Point getC() {return c;}

    @Override
    public Point centroid() {
        double Xo = (a.getX() + b.getX() + c.getX())/3;
        double Yo = (a.getY() + b.getY() + c.getY())/3;
        Point O = new Point(Xo,Yo);
        return O;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }
}
