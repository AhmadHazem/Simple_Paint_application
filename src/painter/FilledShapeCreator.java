package painter;

import java.awt.*;

public class FilledShapeCreator extends GrandShapeCreator {
    @Override
    public Shape CreateShape(Mods mods, Color color, Point p1, int ids) {
        return null;
    }

    @Override
    public Shape CreateFilledShape(Color color, Point P1, Point P2, Shape shape, int ids) {
        if(shape instanceof Circle)
        {
            Circle circle = (Circle) shape;
            circle.setFillMode(true);
            return new FilledCircle(color,circle.getP1(),circle.getP2(),circle,ids);
        }
        else if(shape instanceof Rectangle)
        {
            Rectangle rectangle = (Rectangle) shape;
            rectangle.setFillMode(true);
            return new FilledRectangle(color,rectangle.getP1(), rectangle.getP2(),rectangle,ids);
        }
        else if(shape instanceof Oval)
        {
            Oval oval = (Oval) shape;
            oval.setFillMode(true);
            return new FillOval(color, oval.getP1(), oval.getP2(), oval,ids);
        }
        else if(shape instanceof Rhombus)
        {
            Rhombus rhombus = (Rhombus) shape;
            rhombus.setFillMode(true);
            return new FilledRhombus(color,rhombus.getP1(), rhombus.getP2(),rhombus,ids);
        }
        else if(shape instanceof RightAngledTriangle)
        {
            RightAngledTriangle rightAngledTriangle = (RightAngledTriangle) shape;
            rightAngledTriangle.setFillMode(true);
            return new FilledRHS(color,rightAngledTriangle.getP1(), rightAngledTriangle.getP2(),null,rightAngledTriangle, ids);
        }
        else if(shape instanceof Square)
        {
            Square square = (Square) shape;
            square.setFillMode(true);
            return new FilledSquare(color,square.getP1(), square.getP2(), square, ids);
        }
        else if(shape instanceof Triangle)
        {
            Triangle triangle = (Triangle) shape;
            triangle.setFillMode(true);
            return new FilledTriangle(color, triangle.getP1(), triangle.getP2(), triangle.getP3(), triangle, ids);
        }
        else if(shape instanceof Polygon)
        {
            Polygon polygon = (Polygon) shape;
            polygon.setFillMode(true);
            return new FilledPolygon(color,polygon, ids);
        }
        return null;
    }


}
