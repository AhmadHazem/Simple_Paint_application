package painter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polygon extends Shape {
    List<Point> Points=new ArrayList<>();
    Boolean DoubleCheck= false;
    public Polygon(Color color,int ids) {
        super(color,ids);

    }


    public void addPoint(Point P)
    {
        Points.add(P);
    }

    public List<Point> getPoints() {
        return Points;
    }

    public Boolean getDoubleCheck() {
        return DoubleCheck;
    }

    @Override
    public void draw(Graphics G) {
        int i=0;
        G.setColor(super.color);
        for( i=1 ; i < Points.size();i++)
        {
            if(i==Points.size()-1)
            {
                if((Points.get(0).getX_Coordinate()+20 >= Points.get(Points.size()-1).getX_Coordinate() &&
                        Points.get(0).getX_Coordinate()-20 <= Points.get(Points.size()-1).getX_Coordinate()) &&
                        (Points.get(0).getY_Coordinate()+20 >= Points.get(Points.size()-1).getY_Coordinate() &&
                                Points.get(0).getY_Coordinate()-20 <= Points.get(Points.size()-1).getY_Coordinate()))
                {
                    Points.get(Points.size()-1).setX_Coordinate(Points.get(0).getX_Coordinate());
                    Points.get(Points.size()-1).setY_Coordinate(Points.get(0).getY_Coordinate());
                    if(!DoubleCheck)
                    {
                        WhiteBoard.Clicked=false;
                        DoubleCheck =true;
                    }

                }
            }
            G.setColor(super.color);
            G.drawLine(Points.get(i-1).getX_Coordinate(),Points.get(i-1).getY_Coordinate()
                    ,Points.get(i).getX_Coordinate(),Points.get(i).getY_Coordinate());

        }


    }

    @Override
    public Point[] Move() {
        Point[] P = new Point[Points.size()-1];
        for(int i=0 ; i < Points.size()-1;i++)
        {
            P[i]=Points.get(i);
        }
        return P;
    }

    @Override
    public void Resize(int dx, int dy) {

        for(int i =0 ; i < Points.size() ; i++)
        {
            if(Points.get(i).getX_Coordinate() +15 >= dx && Points.get(i).getX_Coordinate()-15 <=dx
                    && Points.get(i).getY_Coordinate() +15 >= dy && Points.get(i).getY_Coordinate()-15 <=dy)
            {
                Points.get(i).setX_Coordinate(dx);
                Points.get(i).setY_Coordinate(dy);
            }

        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Polygon polygon = (Polygon)super.clone();
        polygon.Points = new ArrayList<>();
        Point []Temp = new Point[Points.size()];
        for(int i=0 ; i< Points.size(); i++)
        {
            Temp[i] = (Point) Points.get(i).clone();
            polygon.Points.add(Temp[i]);
        }
        return polygon;
    }
}
