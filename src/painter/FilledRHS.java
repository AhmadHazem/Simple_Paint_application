package painter;

import java.awt.*;

public class FilledRHS extends RightAngledTriangle{
    RightAngledTriangle rightAngledTriangle;

    public FilledRHS(Color color, Point p1, Point p2, Point p3, RightAngledTriangle rightAngledTriangle, int ids) {
        super(color, p1, p2, p3, ids);
        this.rightAngledTriangle = rightAngledTriangle;
    }

    @Override
    public void draw(Graphics G) {
        rightAngledTriangle.draw(G);
        G.setColor(color);
        int[] X_Coordinates = {rightAngledTriangle.getP1().getX_Coordinate(), rightAngledTriangle.getP2().getX_Coordinate(),
                rightAngledTriangle.getP1().getX_Coordinate()};
        int[] Y_Coordinates = {rightAngledTriangle.getP1().getY_Coordinate(), rightAngledTriangle.getP2().getY_Coordinate(),
                rightAngledTriangle.getP2().getY_Coordinate()};
        G.fillPolygon(X_Coordinates,Y_Coordinates,3);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FilledRHS filledRHS = (FilledRHS) super.clone();
        filledRHS.rightAngledTriangle = (RightAngledTriangle) super.clone();
        filledRHS.rightAngledTriangle.setP2(filledRHS.getP2());
        filledRHS.rightAngledTriangle.setP1(filledRHS.getP1());
        filledRHS.rightAngledTriangle.getPoint()[0] = filledRHS.getP1();
        filledRHS.rightAngledTriangle.getPoint()[1] = filledRHS.getP2();
        return filledRHS;
    }
}
