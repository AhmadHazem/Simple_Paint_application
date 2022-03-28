package painter;

import java.awt.*;

public class Triangle extends Shape
{
    private Point P1;
    private Point P2;
    private Point P3;
    private Point[] point = new Point[3];
    public Triangle(Color color, Point p1, Point p2, Point p3,int ids) {
        super(color,ids);
        P1 = p1;
        P2 = p2;
        P3 = p3;
        point[0]=p1;
        point[1]=p2;
        point[2]=p3;
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

    public Point getP3() {
        return P3;
    }

    public void setP3(Point p3) {
        P3 = p3;
        point[2]=p3;
    }

    public Point[] getPoint() {
        return point;
    }

    public void setPoint(Point[] point) {
        this.point = point;
    }

    @Override
    public void draw(Graphics G) {
        int[] X_Coordinates = {P1.getX_Coordinate(), P2.getX_Coordinate(), P3.getX_Coordinate()};
        int[] Y_Coordinates = {P1.getY_Coordinate(), P2.getY_Coordinate(), P3.getY_Coordinate()};
        G.drawPolygon(X_Coordinates,Y_Coordinates,3);
    }

    @Override
    public Point[] Move() {
        return point;
    }

    @Override
    public void Resize(int dx, int dy) {
        if(P2.getX_Coordinate() + 15 >= dx && P2.getY_Coordinate() + 115 >= dy &&
        P2.getX_Coordinate() - 15 <= dx && P2.getY_Coordinate() - 15 <= dy)
        {
            P2.setX_Coordinate(dx);
            P2.setY_Coordinate(dy);
        }
        else if(P3.getX_Coordinate() + 15 >= dx && P3.getY_Coordinate() + 15 >= dy &&
                P3.getX_Coordinate() -15 <= dx && P3.getY_Coordinate() - 15 <= dy)
        {
            P3.setX_Coordinate(dx);
            P3.setY_Coordinate(dy);
        }
        else if(P1.getX_Coordinate() + 15 >= dx && P1.getY_Coordinate() + 15 >= dy &&
                P1.getX_Coordinate() -15 <= dx && P1.getY_Coordinate() - 15 <= dy)
        {
            P1.setX_Coordinate(dx);
            P1.setY_Coordinate(dy);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Triangle triangle = (Triangle) super.clone();
        triangle.P1 = (Point) P1.clone();
        triangle.P2 = (Point) P2.clone();
        triangle.P3 = (Point) P3.clone();
        triangle.point = point.clone();
        triangle.point[0] =triangle.P1;
        triangle.point[1] =triangle.P2;
        triangle.point[2] = triangle.P3;
        return triangle;
    }
}
