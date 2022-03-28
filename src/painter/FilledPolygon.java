package painter;

import java.awt.*;
import java.util.List;

public class FilledPolygon extends Polygon {
    Polygon polygon;
    public FilledPolygon(Color color, Polygon polygon, int ids) {
        super(color, ids);
        this.polygon = polygon;
    }

    @Override
    public void draw(Graphics G) {
        polygon.draw(G);
        G.setColor(color);
        int[] X_Coordinates = new int[polygon.getPoints().size()];
        int[] Y_Coordinates = new int[polygon.getPoints().size()];
        for (int i = 0; i < polygon.getPoints().size() - 1; i++) {
            X_Coordinates[i] = polygon.getPoints().get(i).getX_Coordinate();
            Y_Coordinates[i] = polygon.getPoints().get(i).getY_Coordinate();
        }
        G.fillPolygon(X_Coordinates,Y_Coordinates,polygon.getPoints().size()-1);

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FilledPolygon filledPolygon = (FilledPolygon) super.clone();
        filledPolygon.polygon = (Polygon) polygon.clone();
        for(int i=0 ; i < filledPolygon.getPoints().size() ; i++)
        {
            filledPolygon.polygon.getPoints().set(i,filledPolygon.getPoints().get(i));
        }

        return filledPolygon;
    }

    @Override
    public List<Point> getPoints() {
        return polygon.getPoints();
    }

    @Override
    public Point[] Move() {
        return  polygon.Move();
    }

    @Override
    public void Resize(int dx, int dy) {
        polygon.Resize(dx,dy);
    }

    //    @Override
//    public List<Point> getPoints() {
//        ArrayList<Point> T = new ArrayList<>();
//        for(int i=0 ; i <points.length;i++)
//        {
//            T.add(points[i]);
//        }
//        return T;
//    }
}
