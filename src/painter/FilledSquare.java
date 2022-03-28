package painter;

import java.awt.*;

public class FilledSquare extends Square implements Cloneable {
    Square square;

    public FilledSquare(Color color, Point p1, Point p2, Square square, int ids) {
        super(color, p1, p2, ids);
        this.square = square;
    }

    @Override
    public void draw(Graphics G) {
        square.draw(G);
        G.setColor(color);
        int Length = square.getP2().getX_Coordinate() - square.getP1().getX_Coordinate();
        int[] X_Coordinates = {square.getP1().getX_Coordinate(), square.getP1().getX_Coordinate() + Length
                , square.getP1().getX_Coordinate() + Length, square.getP1().getX_Coordinate()};
        int[] Y_Coordinates = {square.getP1().getY_Coordinate(), square.getP1().getY_Coordinate(),
                square.getP1().getY_Coordinate() + Length, square.getP1().getY_Coordinate() + Length};
        G.fillPolygon(X_Coordinates, Y_Coordinates, 4);

    }

    @Override
    public Point getP1() {
        return super.getP1();
    }

    @Override
    public void setP1(Point p1) {
        super.setP1(p1);
    }

    @Override
    public Point getP2() {
        return super.getP2();
    }

    @Override
    public void setP2(Point p2) {
        super.setP2(p2);
    }

    @Override
    public Point[] Move() {
        return super.Move();
    }

    @Override
    public void Resize(int dx, int dy) {
        super.Resize(dx, dy);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FilledSquare filledSquare = (FilledSquare)super.clone();
        filledSquare.square = (Square)square.clone();
        filledSquare.square.setP2(filledSquare.getP2());
        filledSquare.square.setP1(filledSquare.getP1());
        filledSquare.square.getPoint()[0] = filledSquare.getP1();
        filledSquare.square.getPoint()[1] = filledSquare.getP2();
        return filledSquare;
    }
}
