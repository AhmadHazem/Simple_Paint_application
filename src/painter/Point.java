package painter;

public class Point implements Cloneable {
    private int X_Coordinate;
    private int Y_Coordinate;

    public Point(int x_Coordinate, int y_Coordinate) {
        X_Coordinate = x_Coordinate;
        Y_Coordinate = y_Coordinate;
    }

    public int getX_Coordinate() {
        return X_Coordinate;
    }

    public void setX_Coordinate(int x_Coordinate) {
        X_Coordinate = x_Coordinate;
    }

    public int getY_Coordinate() {
        return Y_Coordinate;
    }

    public void setY_Coordinate(int y_Coordinate) {
        Y_Coordinate = y_Coordinate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
