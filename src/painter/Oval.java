package painter;

import java.awt.*;

public class Oval extends Shape{
    private Point P1;
    private Point P2;
    private Point[] point = new Point[2];
    public Oval(Color color, Point p1, Point p2,int ids) {
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
        point[1]=p2;
    }



    public void draw(Graphics G) {
        if(getP1().getX_Coordinate() > getP2().getX_Coordinate() && getP1().getY_Coordinate() > getP2().getY_Coordinate())
        {
            G.drawOval(getP2().getX_Coordinate(), getP2().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()));
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.drawOval(getP1().getX_Coordinate(), getP1().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()));
        }
        else if(getP2().getX_Coordinate() < getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.drawOval(getP2().getX_Coordinate(), getP1().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()));
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() < getP1().getY_Coordinate())
        {
            G.drawOval(getP1().getX_Coordinate(), getP2().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()));
        }
    }

    @Override
    public Point[] Move() {
        return  point;
    }

    @Override
    public void Resize(int dx, int dy) {
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Oval oval = (Oval) super.clone();
        oval.P1 = (Point) P1.clone();
        oval.P2 = (Point) P2.clone();
        oval.point = point.clone();
        oval.point[0] = oval.P1;
        oval.point[1] = oval.P2;
        return oval;
    }
}
