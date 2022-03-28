package painter;

import java.awt.*;

public class Circle extends Shape{
    private Point P1;
    private Point P2;
    private Point[] point = new Point[2];

    public Circle(Color color, Point p1, Point p2,int ids) {
        super(color,ids);
        P1 = p1;
        P2 = p2;
        point[0]=p1;
        point[1]=p2;
    }

    @Override
    public void setFillMode(boolean fillMode) {
        super.setFillMode(fillMode);
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
        point[1]=p2;
    }



    public void draw(Graphics G) {

        if(getP1().getX_Coordinate() > getP2().getX_Coordinate() && getP1().getY_Coordinate() > getP2().getY_Coordinate())
        {
            G.drawOval(getP2().getX_Coordinate(), getP2().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getX_Coordinate()-getP1().getX_Coordinate()));
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.drawOval(getP1().getX_Coordinate(), getP1().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getX_Coordinate()-getP1().getX_Coordinate()));
        }
        else if(getP2().getX_Coordinate() < getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.drawOval(getP2().getX_Coordinate(), getP1().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getX_Coordinate()-getP1().getX_Coordinate()));
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() < getP1().getY_Coordinate())
        {
            G.drawOval(getP1().getX_Coordinate(), getP2().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getX_Coordinate()-getP1().getX_Coordinate()));
        }
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
        Circle circle = (Circle) super.clone();
        circle.P1 = (Point) P1.clone();
        circle.P2 = (Point) P2.clone();
        circle.point = point.clone();
        circle.point[0] = circle.P1;
        circle.point[1] = circle.P2;
        return circle;
    }
}
