package painter;

import java.awt.*;

public class FilledRectangle extends Rectangle{
    private Rectangle rectangle;

    public FilledRectangle(Color color, Point p1, Point p2, Rectangle rectangle, int ids) {
        super(color, p1, p2, ids);
        this.rectangle = rectangle;
    }

    @Override
    public void draw(Graphics G) {
        super.draw(G);
        rectangle.draw(G);
        G.setColor(color);
        int[] X_Coordinates = {P1.getX_Coordinate(), P2.getX_Coordinate(), P2.getX_Coordinate(), P1.getX_Coordinate()};
        int[] Y_Coordinates = {P1.getY_Coordinate(), P1.getY_Coordinate(), P2.getY_Coordinate(), P2.getY_Coordinate()};
        G.fillPolygon(X_Coordinates, Y_Coordinates, 4);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FilledRectangle filledRectangle = (FilledRectangle) super.clone();
        filledRectangle.rectangle = (Rectangle) rectangle.clone();
        filledRectangle.rectangle.setP2(filledRectangle.getP2());
        filledRectangle.rectangle.setP1(filledRectangle.getP1());
        filledRectangle.rectangle.getPoint()[0] = filledRectangle.getP1();
        filledRectangle.rectangle.getPoint()[1] = filledRectangle.getP2();
        return filledRectangle;
    }
}
