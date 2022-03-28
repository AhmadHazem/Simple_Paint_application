package painter;

import java.awt.*;

public class Rectangle extends Shape{
    Point P1;
    public boolean ColorMode = false;
    Point P2;
    private Point[] point = new Point[2];
    public Rectangle(Color color, Point p1, Point p2,int ids) {
        super(color,ids);
        P1 = p1;
        P2 = p2;
        point[0]=p1;
        point[1]=p2;
    }

    public Point[] getPoint() {
        return point;
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
        point[1] = p2;
    }

    @Override
    public void draw(Graphics G) {
        int[] X_Coordinates = {P1.getX_Coordinate(), P2.getX_Coordinate(), P2.getX_Coordinate(), P1.getX_Coordinate()};
        int[] Y_Coordinates = {P1.getY_Coordinate(), P1.getY_Coordinate(), P2.getY_Coordinate(), P2.getY_Coordinate()};
        G.drawPolygon(X_Coordinates, Y_Coordinates, 4);
    }

    @Override
    public Point[] Move() {
        return point;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Rectangle rectangle = (Rectangle) super.clone();
        rectangle.P1 = (Point) P1.clone();
        rectangle.P2 = (Point) P2.clone();
        rectangle.point = point.clone();
        rectangle.point[0] = rectangle.P1;
        rectangle.point[1] = rectangle.P2;
        return rectangle;
    }

    @Override
    public void Resize(int dx,int dy) {
        int TestLength =Math.abs(P2.getX_Coordinate() - P1.getX_Coordinate())/2;
        int TestWidth = Math.abs(P1.getY_Coordinate() - P2.getY_Coordinate())/2;
        if( P2.getX_Coordinate() -TestLength <= dx && P2.getY_Coordinate() -TestWidth*2 <= dy)
        {
            P2.setX_Coordinate(dx);
            P2.setY_Coordinate(dy);
        }
        else if (P1.getX_Coordinate() + TestLength >= dx && P1.getY_Coordinate()+TestWidth*2 >=dy)
        {
            P1.setX_Coordinate(dx);
            P1.setY_Coordinate(dy);
        }

    }
}
