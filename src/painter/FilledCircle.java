package painter;

import java.awt.*;

public class FilledCircle extends Circle{
    private Circle circle;

    public FilledCircle(Color color, Point p1, Point p2, Circle circle, int ids) {
        super(color, p1, p2, ids);
        this.circle = circle;
    }



    @Override
    public void draw(Graphics G) {
        circle.draw(G);
        G.setColor(color);
        if(circle.getP1().getX_Coordinate() > circle.getP2().getX_Coordinate()
                && circle.getP1().getY_Coordinate() > circle.getP2().getY_Coordinate())
        {
            G.fillOval(circle.getP2().getX_Coordinate(), getP2().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getX_Coordinate()-getP1().getX_Coordinate()));
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.fillOval(getP1().getX_Coordinate(), getP1().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getX_Coordinate()-getP1().getX_Coordinate()));
        }
        else if(getP2().getX_Coordinate() < getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.fillOval(getP2().getX_Coordinate(), getP1().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getX_Coordinate()-getP1().getX_Coordinate()));
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() < getP1().getY_Coordinate())
        {
            G.fillOval(getP1().getX_Coordinate(), getP2().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getX_Coordinate()-getP1().getX_Coordinate()));
        }
    }
}
