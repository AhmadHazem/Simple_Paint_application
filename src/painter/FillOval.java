package painter;

import java.awt.*;

public class FillOval extends Oval{
    private Oval oval;

    public FillOval(Color color, Point p1, Point p2, Oval oval, int ids) {
        super(color, p1, p2, ids);
        this.oval = oval;
    }

    @Override
    public void draw(Graphics G) {
        super.draw(G);
        G.setColor(color);
        if(getP1().getX_Coordinate() > getP2().getX_Coordinate() && getP1().getY_Coordinate() > getP2().getY_Coordinate())
        {
            G.fillOval(getP2().getX_Coordinate(), getP2().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()));
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.fillOval(getP1().getX_Coordinate(), getP1().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()));
        }
        else if(getP2().getX_Coordinate() < getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.fillOval(getP2().getX_Coordinate(), getP1().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()));
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() < getP1().getY_Coordinate())
        {
            G.fillOval(getP1().getX_Coordinate(), getP2().getY_Coordinate(),
                    Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
                    Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()));
        }
    }
}
