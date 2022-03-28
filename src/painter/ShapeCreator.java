package painter;

import java.awt.*;

public class ShapeCreator extends GrandShapeCreator {
    @Override
    public Shape CreateShape(Mods mods, Color color, Point p1, int ids) {
        switch (mods)
        {
            case Line:
                return new Line(color,p1,p1,ids);
            case Square:
                return new Square(color,p1,p1,ids);
            case Rectangle:
                return new Rectangle(color,p1,p1,ids);
            case Rhombus:
                return new Rhombus(color,p1,p1,ids);
            case Oval:
                return new Oval(color,p1,p1,ids);
            case Circle:
                return new Circle(color,p1,p1,ids);
            case  RHS:
                return new RightAngledTriangle(color,p1,p1,p1,ids);
            case Triangle:
                return new Triangle(color,p1,p1,p1,ids);
            case Polygon:
                return new Polygon(color,ids);
            case freeHand:
                return new FreeHand(color,ids);
            case Sector:
                return new Sector(color,p1,p1,ids);
            default:
                return null;
        }
    }

    @Override
    public Shape CreateFilledShape(Color color, Point P1, Point P2, Shape shape, int ids) {
        return null;
    }


}
