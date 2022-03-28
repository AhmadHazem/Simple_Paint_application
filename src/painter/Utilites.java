package painter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

public class Utilites<T extends Shape> {
    private static Utilites<Shape> Utilites = null;
    FilledShapeCreator filledShapeCreator = new FilledShapeCreator();
    int undo = 0;
    private Utilites() {

    }

    public static Utilites getInstance() {
        if (Utilites == null)
            Utilites = new Utilites<>();
        return Utilites;
    }

    public Shape Copy(T CurrentShape, Point P1) throws CloneNotSupportedException {
        if (CurrentShape != null) {
            Shape shape = (Shape) CurrentShape.clone();
            Move((T) shape, P1, 20, 20);
            // shape.ID++;
            return shape;
        }

        return CurrentShape;
    }

    public void Move(T CurrentShape, Point P1, int dx, int dy) {
        Point[] points = CurrentShape.Move();
        for (int p = 0; p < points.length; p++) {
            points[p].setX_Coordinate(points[p].getX_Coordinate() + dx);
            points[p].setY_Coordinate(points[p].getY_Coordinate() + dy);
        }
        P1.setX_Coordinate(P1.getX_Coordinate() + dx);
        P1.setY_Coordinate(P1.getY_Coordinate() + dy);
    }

    public void Resize(T CurrentShape, Point P, Point SpecialPolygon) {
        if (CurrentShape != null) {

            CurrentShape.Resize(P.getX_Coordinate(), P.getY_Coordinate());
        }

    }

    public Shape FillShape(Shape currentShape, Color color, int id) {
        return filledShapeCreator.CreateFilledShape(color, null, null, currentShape, id);

    }

    public void undo(LinkedList<Shape> shapes, LinkedList<Shape> HiddenBuffer, LinkedList<Shape> Buffer,
                     Mods mode , LinkedList<Point> points) {

        if(HiddenBuffer.size() > 1 && shapes.size()>1)
        {
            Shape shape = contains(points.getLast(),shapes);
            int index = shapes.indexOf(shape);
            int id = shapes.get(index).ID;
            if(index >= 0)
            {
                Buffer.add(shapes.remove(index));
                for(int z=HiddenBuffer.size()-1; z>=0; z--)
                {
                    if(id == HiddenBuffer.get(z).ID)
                    {

                        shapes.addFirst(HiddenBuffer.remove(z));

                        break;
                    }
                }
            }
        }
        else
        {
            Buffer.add(shapes.removeLast());
            shapes.addFirst(HiddenBuffer.removeLast());
        }
        points.addFirst(points.removeLast());
    }

    public void redo(LinkedList<Shape> shapes,LinkedList<Shape> HiddenBuffer, LinkedList<Shape> Buffer, Mods mode,
                     LinkedList<Point> points) {
        if(Buffer.size() > 1)
        {
            Shape shape = contains(points.getFirst(),Buffer);
            int index = Buffer.indexOf(shape);
            if(index >= 0)
            {
                shapes.removeLast();
                shapes.add(Buffer.remove(index));
            }
        }
        else
        {
            Buffer.addFirst(shapes.removeLast());
            shapes.add(Buffer.removeLast());
        }
        points.addLast(points.removeFirst());

    }
    public Shape  contains(Point P1, LinkedList<Shape> shapes) {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i) instanceof Square || shapes.get(i) instanceof FilledSquare) {
                Square square = (Square) shapes.get(i);
                int[] X_Coordinates = {square.getP1().getX_Coordinate(), square.getP2().getX_Coordinate(), square.getP2().getX_Coordinate(), square.getP1().getX_Coordinate()};
                int[] Y_Coordiantes = {square.getP1().getY_Coordinate(), square.getP1().getY_Coordinate(), square.getP2().getY_Coordinate(), square.getP2().getY_Coordinate()};
                java.awt.Polygon polygon = new java.awt.Polygon(X_Coordinates, Y_Coordiantes, 4);
                if (polygon.contains(P1.getX_Coordinate(), P1.getY_Coordinate())) {

                    return square;
                }

            } else if (shapes.get(i) instanceof Rectangle || shapes.get(i) instanceof FilledRectangle) {
                Rectangle rectangle = (Rectangle) shapes.get(i);
                int[] X_Coordinates = {rectangle.getP1().getX_Coordinate(), rectangle.getP2().getX_Coordinate(), rectangle.getP2().getX_Coordinate(), rectangle.getP1().getX_Coordinate()};
                int[] Y_Coordiantes = {rectangle.getP1().getY_Coordinate(), rectangle.getP1().getY_Coordinate(), rectangle.getP2().getY_Coordinate(), rectangle.getP2().getY_Coordinate()};
                java.awt.Polygon polygon = new java.awt.Polygon(X_Coordinates, Y_Coordiantes, 4);
                if (polygon.contains(P1.getX_Coordinate(), P1.getY_Coordinate())) {

                    return rectangle;
                }
            }

            else if (shapes.get(i) instanceof Polygon || shapes.get(i) instanceof FilledPolygon) {
                Polygon polygon = (Polygon) shapes.get(i);
                int[] X_Coordinates = new int[polygon.getPoints().size()];
                int[] Y_Coordinates = new int[polygon.getPoints().size()];
                for (int p = 0; p < polygon.getPoints().size() - 1; p++) {
                    X_Coordinates[p] = polygon.getPoints().get(p).getX_Coordinate();
                    Y_Coordinates[p] = polygon.getPoints().get(p).getY_Coordinate();
                }
                java.awt.Polygon polygon1 = new java.awt.Polygon(X_Coordinates, Y_Coordinates, polygon.getPoints().size() - 1);
                if (polygon1.contains(P1.getX_Coordinate(), P1.getY_Coordinate())) {


                    return polygon;
                }
            } else if (shapes.get(i) instanceof Rhombus || shapes.get(i) instanceof FilledRhombus) {
                Rhombus rhombus = (Rhombus) shapes.get(i);
                int HorizontalShift = 2 * (rhombus.getP2().getX_Coordinate() - rhombus.getP1().getX_Coordinate());
                int VerticalShift = 2 * (rhombus.getP2().getY_Coordinate() - rhombus.getP1().getY_Coordinate());
                int[] X_Coordinates = {rhombus.getP1().getX_Coordinate(), rhombus.getP2().getX_Coordinate(),
                        rhombus.getP1().getX_Coordinate(), rhombus.getP2().getX_Coordinate() - HorizontalShift};
                int[] Y_Coordinates = {rhombus.getP1().getY_Coordinate(), rhombus.getP2().getY_Coordinate(),
                        rhombus.getP1().getY_Coordinate() + VerticalShift, rhombus.getP2().getY_Coordinate()};
                java.awt.Polygon polygon = new java.awt.Polygon(X_Coordinates, Y_Coordinates, 4);
                if (polygon.contains(P1.getX_Coordinate(), P1.getY_Coordinate())) {


                    return rhombus;
                }

            } else if (shapes.get(i) instanceof Triangle || shapes.get(i) instanceof FilledTriangle) {
                Triangle triangle = (Triangle) shapes.get(i);
                int[] X_Coordinates = {triangle.getP1().getX_Coordinate(), triangle.getP2().getX_Coordinate()
                        , triangle.getP3().getX_Coordinate()};
                int[] Y_Coordinates = {triangle.getP1().getY_Coordinate(), triangle.getP2().getY_Coordinate()
                        , triangle.getP3().getY_Coordinate()};
                java.awt.Polygon polygon = new java.awt.Polygon(X_Coordinates, Y_Coordinates, 3);
                if (polygon.contains(P1.getX_Coordinate(), P1.getY_Coordinate())) {


                    return triangle;
                }
            } else if (shapes.get(i) instanceof RightAngledTriangle || shapes.get(i) instanceof FilledRHS) {
                RightAngledTriangle rhs = (RightAngledTriangle) shapes.get(i);
                int[] X_Coordinates = {rhs.getP1().getX_Coordinate(), rhs.getP2().getX_Coordinate()
                        , rhs.getP1().getX_Coordinate()};
                int[] Y_Coordinates = {rhs.getP1().getY_Coordinate(), rhs.getP2().getY_Coordinate()
                        , rhs.getP2().getY_Coordinate()};
                java.awt.Polygon polygon = new java.awt.Polygon(X_Coordinates, Y_Coordinates, 3);
                if (polygon.contains(P1.getX_Coordinate(), P1.getY_Coordinate())) {


                    return rhs;
                }
            } else if (shapes.get(i) instanceof Line) {
                Line line = (Line) shapes.get(i);
                double[] X_Coordinates = {line.getP1().getX_Coordinate(), line.getP2().getX_Coordinate()};
                double[] Y_Coordiantes = {line.getP1().getY_Coordinate(), line.getP2().getY_Coordinate()};
                double lineslope = ((Y_Coordiantes[1] - Y_Coordiantes[0])) / ((X_Coordinates[1] - X_Coordinates[0]));
                double lineangle = Math.atan(lineslope);
                double Testslope = (P1.getY_Coordinate() - Y_Coordiantes[1]) / (P1.getX_Coordinate() - X_Coordinates[1]);
                double Testangle = Math.atan(Testslope);
                if (lineangle + 0.10 >= Testangle && lineangle - 0.10 <= Testangle) {


                    return line;
                }
            } else if (shapes.get(i) instanceof Oval || shapes.get(i) instanceof FillOval) {
                Oval oval = (Oval) shapes.get(i);
                Ellipse2D ellipse2D = new Ellipse2D.Double(oval.getP1().getX_Coordinate(),
                        oval.getP1().getY_Coordinate(), Math.abs(oval.getP2().getX_Coordinate() -
                        oval.getP1().getX_Coordinate()), Math.abs(oval.getP2().getY_Coordinate() - oval.getP1().getY_Coordinate()));
                if (ellipse2D.contains(P1.getX_Coordinate(), P1.getY_Coordinate())) {

                    return oval;
                }
            } else if (shapes.get(i) instanceof Circle || shapes.get(i) instanceof FilledCircle) {
                Circle circle = (Circle) shapes.get(i);
                Ellipse2D ellipse2D = new Ellipse2D.Double(circle.getP1().getX_Coordinate(),
                        circle.getP1().getY_Coordinate(), Math.abs(circle.getP2().getX_Coordinate() -
                        circle.getP1().getX_Coordinate()), Math.abs(circle.getP2().getY_Coordinate() - circle.getP1().getY_Coordinate()));
                if (ellipse2D.contains(P1.getX_Coordinate(), P1.getY_Coordinate())) {

                    return circle;
                }
            }

        }
        return null;
    }

}
//    Shape shape =  contains(points.getLast(),shapes);
//    int index = shapes.indexOf(shape);
//            if(index >= 0)
//                    {
//                    Buffer.add(shapes.remove(index));
//                    shapes.addFirst(HiddenBuffer.remove(HiddenBuffer.size()-1));
//                    }