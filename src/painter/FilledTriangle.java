package painter;

import java.awt.*;

public class FilledTriangle extends Triangle{
    Triangle triangle;

    public FilledTriangle(Color color, Point p1, Point p2, Point p3, Triangle triangle, int ids) {
        super(color, p1, p2, p3, ids);
        this.triangle = triangle;
    }

    @Override
    public void draw(Graphics G) {
        triangle.draw(G);
        G.setColor(color);
        int[] X_Coordinates = {triangle.getP1().getX_Coordinate(), triangle.getP2().getX_Coordinate()
                , triangle.getP3().getX_Coordinate()};
        int[] Y_Coordinates = {triangle.getP1().getY_Coordinate(), triangle.getP2().getY_Coordinate()
                , triangle.getP3().getY_Coordinate()};
        G.fillPolygon(X_Coordinates,Y_Coordinates,3);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FilledTriangle filledTriangle = (FilledTriangle)super.clone();
        filledTriangle.triangle = (Triangle)triangle.clone();
        return filledTriangle;
    }
}
