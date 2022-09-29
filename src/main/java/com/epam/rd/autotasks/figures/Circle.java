package com.epam.rd.autotasks.figures;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;
class Circle extends Figure{
    private Point center;
    private double radius;
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        double area = Math.PI * radius * radius;
        if (area == 0){throw new IllegalArgumentException();};
        if (center == null){throw new IllegalArgumentException();}
        if (radius <=0){throw new IllegalArgumentException();}
    }
    public Point getCenter() {return center;}
    public double getRadius() {return radius;}

    @Override
    public Point centroid() {

        Point C = new Point(center.getX(), center.getY());
        return C;
    }
    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Circle){
        double cx = ((Circle) figure).center.getX();
        double cy = ((Circle) figure).center.getY();
        double rrr = ((Circle) figure).getRadius();
        double delta = 4.440892098500626E-16;
        if ((Math.abs(getRadius() - rrr)<=delta)&&(Math.abs(center.getX() - cx)<=delta)&&(Math.abs(center.getY() - cy)<=delta)){return true;}}
        else return false;
        return false;
    }
}
