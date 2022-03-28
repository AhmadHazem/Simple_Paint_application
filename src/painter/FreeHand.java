package painter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FreeHand extends Shape
{
    List<Point> Points=new ArrayList<>();

    public FreeHand(Color color,int ids) {
        super(color,ids);
    }

    public void Addpoint(Point P)
    {
        Points.add(P);
    }

    @Override
    public void draw(Graphics G) {
        for(int i=1 ; i < Points.size();i++)
        {

            G.drawLine(Points.get(i-1).getX_Coordinate(),Points.get(i-1).getY_Coordinate()
            ,Points.get(i).getX_Coordinate(),Points.get(i).getY_Coordinate());
        }
    }

    @Override
    public Point[] Move() {
        return new Point[0];
    }

    @Override
    public void Resize(int dx, int dy) {

    }
}
