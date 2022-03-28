package painter;

import java.awt.*;

public class Square extends Shape{

     Point P1;
     Point P2;
    private Point[] point = new Point[2];
    public Square(Color color, Point p1, Point p2,int ids) {
        super(color,ids);
        P1 = p1;
        P2 = p2;
        point[0]=p1;
        point[1]=p2;
    }

    public Point getP1() {
        return P1;
    }

    public Point[] getPoint() {
        return point;
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
        int Length = P2.getX_Coordinate() - P1.getX_Coordinate();
        int[] X_Coordinates = {P1.getX_Coordinate(), P1.getX_Coordinate() + Length , P1.getX_Coordinate() + Length, P1.getX_Coordinate()};
        int[] Y_Coordinates = {P1.getY_Coordinate(), P1.getY_Coordinate(), P1.getY_Coordinate() + Length, P1.getY_Coordinate() + Length};
        G.drawPolygon(X_Coordinates, Y_Coordinates, 4);

    }

    public void setPoint(Point[] point) {
        this.point = point;
    }

    @Override
    public Point[] Move() {
        return point;
    }

    @Override
    public void Resize(int dx, int dy) {

        point[1].setX_Coordinate(dx);
        point[1].setY_Coordinate(dy);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Square square = (Square)super.clone();
        square.P1 = (Point) P1.clone();
        square.P2 = (Point) P2.clone();
        square.point = point.clone();
        square.point[0] = square.P1;
        square.point[1] = square.P2;
        return square;
    }
}
