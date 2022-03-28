package painter;

import java.awt.*;

public class Rhombus extends Shape{
    private Point P1;
    private Point P2;
    private Point[] point = new Point[2];
    public Rhombus(Color color, Point p1, Point p2,int ids) {
        super(color,ids);
        P1 = p1;
        P2 = p2;
        point[0]=p1;
        point[1]=p2;
    }

    public Point getP1() {
        return P1;
    }

    public void setP1(Point p1) {
        P1 = p1;
        point[0]=p1;
    }

    public Point getP2() {
        return P2;
    }

    public void setP2(Point p2) {
        P2 = p2;
        point[1]=p2;
    }

    public Point[] getPoint() {
        return point;
    }

    @Override
    public void draw(Graphics G) {
        int HorizontalShift = 2*(P2.getX_Coordinate() - P1.getX_Coordinate());
        int VerticalShift = 2*(P2.getY_Coordinate() - P1.getY_Coordinate());
        int[] X_Coordinates = {P1.getX_Coordinate(), P2.getX_Coordinate(),
        P1.getX_Coordinate(), P2.getX_Coordinate()-HorizontalShift};
        int[] Y_Coordinates = {P1.getY_Coordinate(), P2.getY_Coordinate(),
        P1.getY_Coordinate()+VerticalShift, P2.getY_Coordinate()};
        G.drawPolygon(X_Coordinates,Y_Coordinates,4);
    }

    @Override
    public Point[] Move() {
        return  point;
    }

    @Override
    public void Resize(int dx, int dy) {
        P2.setX_Coordinate(dx);
        P2.setY_Coordinate(dy);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Rhombus rhombus = (Rhombus) super.clone();
        rhombus.P1 = (Point) P1.clone();
        rhombus.P2 = (Point) P2.clone();
        rhombus.point = point.clone();
        rhombus.point[0] = rhombus.P1;
        rhombus.point[1] = rhombus.P2;
        return rhombus;
    }
}
