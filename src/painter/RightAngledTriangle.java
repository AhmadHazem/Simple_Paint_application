package painter;

import java.awt.*;

public class RightAngledTriangle extends Shape{
    private Point P1;
    private Point P2;
    //private Point P3;
    private Point[] point = new Point[2];
    public RightAngledTriangle(Color color, Point p1, Point p2, Point p3, int ids) {
        super(color, ids);
        P1 = p1;
        P2 = p2;
//        P3 = p3;
        point[0]=p1;
        point[1]=p2;
        //point[2]=p3;
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

//    public Point getP3() {
//        return P3;
//    }
//
//    public void setP3(Point p3) {
//        P3 = p3;
//        point[2]=p3;
//    }

    public Point[] getPoint() {
        return point;
    }

    public void setPoint(Point[] point) {
        this.point = point;
    }

    @Override
    public void draw(Graphics G) {
//        P3.setX_Coordinate(P1.getX_Coordinate());
//        P3.setY_Coordinate(P2.getY_Coordinate());
        int[] X_Coordinates = {P1.getX_Coordinate(), P2.getX_Coordinate(), P1.getX_Coordinate()};
        int[] Y_Coordinates = {P1.getY_Coordinate(), P2.getY_Coordinate(), P2.getY_Coordinate()};
//        P3.setY_Coordinate(P2.getY_Coordinate());
//        P3.setX_Coordinate(P1.getX_Coordinate());
        G.drawPolygon(X_Coordinates,Y_Coordinates,3);
    }

    @Override
    public Point[] Move() {
        return point;
    }

    @Override
    public void Resize(int dx, int dy) {
        P2.setX_Coordinate(dx);
        P2.setY_Coordinate(dy);

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        RightAngledTriangle rightAngledTriangle = (RightAngledTriangle) super.clone();
        rightAngledTriangle.P1 = (Point) P1.clone();
        rightAngledTriangle.P2 = (Point) P2.clone();
        rightAngledTriangle.point = point.clone();
        rightAngledTriangle.point[0] =rightAngledTriangle.P1;
        rightAngledTriangle.point[1] =rightAngledTriangle.P2;
        return rightAngledTriangle;
    }
}
