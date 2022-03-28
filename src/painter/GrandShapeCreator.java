package painter;

import java.awt.*;

public abstract class GrandShapeCreator
{
    public abstract  Shape CreateShape(Mods mods, Color color, Point p1, int ids);
    public abstract   Shape CreateFilledShape(Color color , Point P1, Point P2, Shape shape,int ids);
}
