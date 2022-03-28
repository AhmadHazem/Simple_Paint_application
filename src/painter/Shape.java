package painter;

import java.awt.*;

public abstract class Shape implements Cloneable {
    Color color;
    int ID;
    private boolean FillMode=false;
    public Shape(Color color, int id) {
        this.color = color;
        this.ID=id;
    }


    public boolean isFillMode() {
        return FillMode;
    }

    public void setFillMode(boolean fillMode) {
        FillMode = fillMode;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public  abstract void draw(Graphics G);
    public abstract Point[] Move();
    public abstract void Resize(int dx , int dy);


}
