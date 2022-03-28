package painter;

import java.awt.*;

public class FilledRhombus extends Rhombus{
    private Rhombus rhombus;

    public FilledRhombus(Color color, Point p1, Point p2, Rhombus rhombus, int ids) {
        super(color, p1, p2, ids);
        this.rhombus = rhombus;
    }

    @Override
    public void draw(Graphics G) {
        rhombus.draw(G);
        G.setColor(color);
        int HorizontalShift = 2*(rhombus.getP2().getX_Coordinate() - rhombus.getP1().getX_Coordinate());
        int VerticalShift = 2*(rhombus.getP2().getY_Coordinate() - rhombus.getP1().getY_Coordinate());
        int[] X_Coordinates = {rhombus.getP1().getX_Coordinate(), rhombus.getP2().getX_Coordinate(),
                rhombus.getP1().getX_Coordinate(), rhombus.getP2().getX_Coordinate()-HorizontalShift};
        int[] Y_Coordinates = {rhombus.getP1().getY_Coordinate(), rhombus.getP2().getY_Coordinate(),
                rhombus.getP1().getY_Coordinate()+VerticalShift, rhombus.getP2().getY_Coordinate()};
        G.fillPolygon(X_Coordinates,Y_Coordinates,4);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FilledRhombus filledRhombus = (FilledRhombus) super.clone();
        filledRhombus.rhombus = (Rhombus) rhombus.clone();
        filledRhombus.rhombus.setP2(filledRhombus.getP2());
        filledRhombus.rhombus.setP1(filledRhombus.getP1());
        filledRhombus.rhombus.getPoint()[0] = filledRhombus.getP1();
        filledRhombus.rhombus.getPoint()[1] = filledRhombus.getP2();
        return filledRhombus;
    }
}
