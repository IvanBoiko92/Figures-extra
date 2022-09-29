package com.epam.rd.autotasks.figures;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;
class Quadrilateral extends  Figure{
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (a == null) {throw new IllegalArgumentException();}
        if (b == null) {throw new IllegalArgumentException();}
        if (c == null) {throw new IllegalArgumentException();}
        if (d == null) {throw new IllegalArgumentException();}
        if (((b.getX()-a.getX())*(c.getY()-a.getY())==(c.getX()-a.getX())*(b.getY()-a.getY()))&&((b.getX()-a.getX())*(d.getY()-a.getY())==(d.getX()-a.getX())*(b.getY()-a.getY()))){
            throw new IllegalArgumentException();
        }
        if (wherePoint(a, b, c) * (-1) == wherePoint(a, b, d) || (
                wherePoint(b, c, d) * (-1) == wherePoint(b, c, a))) {
            throw new IllegalArgumentException();
        }
        double Sabc = 0.5 * Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY()));
        double Sadc = 0.5 * Math.abs((d.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (d.getY() - a.getY()));
        if (Sabc <= 0 || Sadc <= 0) {
            throw new IllegalArgumentException();
        }
    }
        public int wherePoint(Point a, Point b, Point myPoint) {
            double s;
            s = (b.getX() - a.getX()) * (myPoint.getY() - a.getY()) - (b.getY() - a.getY()) * (myPoint.getX() - a.getX());
            if (s > 0)  return 1;
            else if (s < 0)  return -1;
            else return 0;
        }
    public Point getA() {return a;}
    public Point getB() {return b;}
    public Point getC() {return c;}
    public Point getD() {return d;}
    @Override
    public Point centroid() {
        Point[] points = {a,b,c,d,a};
    Point Centroid = new Point(Gx(points), Gy(points));
    return Centroid;
    }

    private double A(Point[] points) {
        double sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += (points[i].getX() * points[i + 1].getY() - points[i + 1].getX() * points[i].getY());
        }
        return sum / 2;     }
    private double Gx(Point[] points) {
        double sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += (points[i].getX() + points[i + 1].getX()) * (points[i].getX() * points[i + 1].getY() - points[i + 1].getX() * points[i].getY());
        }
        return sum / (6 * A(points));
    }
    private double Gy(Point[] points) {
        double sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += (points[i].getY() + points[i + 1].getY()) * (points[i].getX() * points[i + 1].getY() - points[i + 1].getX() * points[i].getY());
        }
        return sum / (6 * A(points));
    }
    @Override
    public boolean isTheSame(Figure figure) {
        double ax = ((Quadrilateral)figure).a.getX();
        double ay = ((Quadrilateral)figure).a.getY();
        double bx = ((Quadrilateral)figure).b.getX();
        double by = ((Quadrilateral)figure).b.getY();
        double cx = ((Quadrilateral)figure).c.getX();
        double cy = ((Quadrilateral)figure).c.getY();
        double dx = ((Quadrilateral)figure).d.getX();
        double dy = ((Quadrilateral)figure).d.getY();
        double delta = 4.440892098500626E-16;
        if (((Quadrilateral)figure).a != a){
            if ((a.getX()==bx)||(b.getX()==cx)||(c.getX()==dx)||(d.getX()==ax)){return true;}
            else if ((a.getX()==bx)||(b.getX()==ax)||(c.getX()==dx)||(d.getX()==cx)){return true;}
            else if ((a.getX()==cx)||(b.getX()==bx)||(c.getX()==ax)||(d.getX()==dx)){return true;}
        }
        if ((a.getX()!=ax)||(b.getX()!=bx)||(c.getX()!=cx)||(d.getX()!=dx)){return false;}
        if ((Math.abs(a.getX()-ax)<=delta)||(Math.abs(b.getX()-bx)<=delta)||(Math.abs(c.getX()-cx)<=delta)||(Math.abs(d.getX()-dx)<=delta)){return true;}
        return false;
    }
}

