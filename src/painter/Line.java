package painter;

import java.awt.*;

public class Line extends Shape{
    Point P1;
    Point P2;
    private Point[] point = new Point[2];
    public Line(Color color, Point p1, Point p2,int ids) {
        super(color,ids);
        P1 = p1;
        P2 = p2;
        point[0]=p1;
        point[1]=p2;
    }

    public Point[] getPoint() {
        return point;
    }

    /**
     *
     * @param G
     */
    @Override
    public void draw(Graphics G) {
        G.setColor(color);
        G.drawLine(P1.getX_Coordinate(), P1.getY_Coordinate(),P2.getX_Coordinate() ,P2.getY_Coordinate());
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


    public Point getP1() {
        return P1;
    }

    public void setP1(Point P1) {
        this.P1 = P1;
        point[0]=P1;
    }

    public Point getP2() {
        return P2;

    }

    public void setP2(Point P2) {
        this.P2 = P2;
        point[1]=P2;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Line line = (Line) super.clone();
        line.P1 = (Point) P1.clone();
        line.P2 = (Point) P2.clone();
        line.point = point.clone();
        line.point[0] = line.P1;
        line.point[1] = line.P2;
        return line;
    }
}
