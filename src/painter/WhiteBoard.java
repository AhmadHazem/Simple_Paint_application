package painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class WhiteBoard extends JPanel implements MouseListener, MouseMotionListener {
    public static Mods mode = Mods.None;
    public static int Ids=0;

    ShapeCreator shapeCreator = new ShapeCreator();
    public static UtilityModes utilityModes = UtilityModes.None;
    Boolean In = true;
    public static boolean FillMode = false;
    Shape shape = null;
    public static Boolean Clicked = false;
    public static Boolean flag = false;
    Utilites utilites = Utilites.getInstance();
    LinkedList<Point> Points = new LinkedList<>();
    LinkedList<Shape> Buffer = new LinkedList<>();
    LinkedList<Shape> HiddenBuffer = new LinkedList<>();
    LinkedList<Shape> shapes = new LinkedList<>();
    public static Color color = Color.BLUE;

    public WhiteBoard() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Line) {
                Shape LastLine = shapes.get(i);
                LastLine.draw(g);
                ;
            } else if (shapes.get(i) instanceof FilledCircle) {
                Shape LastFill = shapes.get(i);
                LastFill.draw(g);
            } else if (shapes.get(i) instanceof FilledSquare) {
                Shape Last = shapes.get(i);
                Last.draw(g);
            } else if (shapes.get(i) instanceof FilledRectangle) {
                Shape Last = shapes.get(i);
                Last.draw(g);
            } else if (shapes.get(i) instanceof FilledRhombus) {
                Shape Last = shapes.get(i);
                Last.draw(g);
            } else if (shapes.get(i) instanceof FilledRHS) {
                Shape Last = shapes.get(i);
                Last.draw(g);
            } else if (shapes.get(i) instanceof FilledTriangle) {
                Shape Last = shapes.get(i);
                Last.draw(g);
            } else if (shapes.get(i) instanceof FilledPolygon) {
                Shape Last = shapes.get(i);
                Last.draw(g);
            } else if (shapes.get(i) instanceof Square) {
                Shape LastSquare = shapes.get(i);
                LastSquare.draw(g);

            } else if (shapes.get(i) instanceof Rectangle) {
                Shape LastRectangle = shapes.get(i);
                LastRectangle.draw(g);

            } else if (shapes.get(i) instanceof Oval) {
                Shape LastOval = shapes.get(i);
                LastOval.draw(g);

            } else if (shapes.get(i) instanceof Circle) {
                Shape LastCircle = shapes.get(i);
                LastCircle.draw(g);
            } else if (shapes.get(i) instanceof Triangle) {
                Shape LastTriangle = shapes.get(i);
                LastTriangle.draw(g);

            } else if (shapes.get(i) instanceof RightAngledTriangle) {
                Shape LastRHS = shapes.get(i);
                LastRHS.draw(g);

            } else if (shapes.get(i) instanceof Rhombus) {
                Shape LastRhombus = shapes.get(i);
                LastRhombus.draw(g);

            } else if (shapes.get(i) instanceof FreeHand) {
                Shape freehand = shapes.get(i);
                freehand.draw(g);

            } else if (shapes.get(i) instanceof Sector) {
                Shape LastSector = shapes.get(i);
                LastSector.draw(g);

            } else if (shapes.get(i) instanceof Polygon) {
                Shape LastPolygon = shapes.get(i);
                LastPolygon.draw(g);

            }


        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        switch (mode) {

            case FillMode: {
                int x = e.getX();
                int y = e.getY();
                if ((shape = utilites.contains(new Point(x, y),shapes)) != null) {

                    shape = utilites.FillShape(shape, color, Ids);
                    System.out.println("Copied to Hidden Buffer");
                    Shape temp = delete(shapes,new Point(x,y));
                    Points.add(new Point(x,y));
                    HiddenBuffer.add(temp);
                    shapes.add(shape);
                    repaint();

                }
                break;
            }
            case None: {
                repaint();
                break;
            }
            case Line: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Line line = (Line) shapeCreator.CreateShape(Mods.Line, color, Points.get(Points.size() - 1),++Ids);
                shapes.add(line);
                repaint();
                break;
            }
            case Rectangle: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Rectangle rectangle = (Rectangle) shapeCreator.CreateShape(Mods.Rectangle, color,
                        Points.get(Points.size() - 1),++Ids);
                shapes.add(rectangle);
                repaint();
                break;

            }
            case Oval: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Oval oval = (Oval) shapeCreator.CreateShape(Mods.Oval, color, Points.get(Points.size() - 1),++Ids);
                shapes.add(oval);
                repaint();
                break;
            }
            case Circle: {

                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Circle circle = (Circle) shapeCreator.CreateShape(Mods.Circle, color, Points.get(Points.size() - 1),++Ids);
                shapes.add(circle);
                repaint();
                break;
            }
            case Square: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Square square = (Square) shapeCreator.CreateShape(Mods.Square, color, Points.get(Points.size() - 1),++Ids);
                shapes.add(square);
                repaint();
                break;
            }
            case Triangle: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Triangle triangle = (Triangle) shapeCreator.CreateShape(Mods.Triangle, color,
                        Points.get(Points.size() - 1),++Ids);
                shapes.add(triangle);
                repaint();
                break;
            }
            case RHS: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                RightAngledTriangle rightAngledTriangle = (RightAngledTriangle) shapeCreator.CreateShape(Mods.RHS, color
                        , Points.get(Points.size() - 1),++Ids);
                shapes.add(rightAngledTriangle);
                repaint();
                break;
            }
            case Rhombus: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Rhombus rhombus = (Rhombus) shapeCreator.CreateShape(Mods.Rhombus, color,
                        Points.get(Points.size() - 1),++Ids);
                shapes.add(rhombus);
                repaint();
                break;
            }
            case freeHand: {

                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                FreeHand freeHand = (FreeHand) shapeCreator.CreateShape(Mods.freeHand,
                        color, Points.get(Points.size() - 1),++Ids);
                shapes.add(freeHand);
                freeHand.Addpoint(new Point(x, y));
                repaint();
                break;
            }
            case Sector: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Sector sector = (Sector) shapeCreator.CreateShape(Mods.Sector, color,
                        Points.get(Points.size() - 1),++Ids);
                shapes.add(sector);
                repaint();
                break;
            }
            case Polygon: {
                if (!Clicked) {
                    int x = e.getX();
                    int y = e.getY();
                    Points.add(new Point(x, y));
                    Polygon polygon = (Polygon) shapeCreator.CreateShape(Mods.Polygon, color,
                            Points.get(Points.size() - 1),++Ids);
                    shapes.add(polygon);
                    polygon.addPoint(new Point(x, y));
                    repaint();
                    Clicked = true;

                } else {
                    int x = e.getX();
                    int y = e.getY();
                    Points.add(new Point(x, y));
                    Polygon Last = (Polygon) shapes.get(shapes.size() - 1);
                    Last.addPoint(new Point(x, y));
                    repaint();
                    // Clicked = false;
                }
                break;
            }
            case Moves: {
                int x = e.getX();
                int y = e.getY();
                if (utilites.contains(new Point(x, y),shapes) != null) {
                    Cursor cursor = new Cursor(Cursor.MOVE_CURSOR);
                    setCursor(cursor);
                    try {
                        System.out.println("Copied to Hidden Buffer");
                        HiddenBuffer.add(utilites.Copy(utilites.contains(new Point(x, y),shapes), new Point(x, y)));
                    } catch (CloneNotSupportedException cloneNotSupportedException) {
                        cloneNotSupportedException.printStackTrace();
                    }

                    Points.add(new Point(x, y));
                }
                break;
            }
            case Copy: {
                int x = e.getX();
                int y = e.getY();
                if (utilites.contains(new Point(x, y),shapes) != null) {
                    try {
                        Shape shape = utilites.Copy(utilites.contains(new Point(x, y),shapes), new Point(x, y));
                        shapes.add(shape);
                        Points.add(new Point(x, y));
                        repaint();
                    } catch (CloneNotSupportedException cloneNotSupportedException) {
                        cloneNotSupportedException.printStackTrace();
                    }
                }
                break;
            }
            case Resize: {
                int x = e.getX();
                int y = e.getY();
                if ((shape = utilites.contains(new Point(x, y),shapes)) != null) {
                    Points.add(new Point(x, y));
                    try {
                        System.out.println("Copied to Hidden Buffer");
                        HiddenBuffer.add(utilites.Copy(utilites.contains(new Point(x, y),shapes), new Point(x, y)));
                    } catch (CloneNotSupportedException cloneNotSupportedException) {
                        cloneNotSupportedException.printStackTrace();
                    }
                }
            }

        }


    }
    //}

    @Override
    public void mouseReleased(MouseEvent e) {
        Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        setCursor(cursor);


    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(In)
        {
            HiddenBuffer.add(new Line(Color.BLACK,
                    new Point(0,0),new Point(0,0),-1));
            Buffer.add(new Line(Color.BLACK,
                    new Point(0,0),new Point(0,0),-1));
            In = false;
        }
        switch (utilityModes) {
            case Undo: {
                utilites.undo(shapes, HiddenBuffer, Buffer, mode,Points);
                repaint();
                utilityModes = UtilityModes.None;
                break;
            }
            case Redo: {
                utilites.redo(shapes, HiddenBuffer, Buffer, mode,Points);
                repaint();
                utilityModes = UtilityModes.None;
                break;
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (mode) {
            case Line: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Line Last = (Line) shapes.get(shapes.size() - 1);
                Last.setP2(Points.get(Points.size() - 1));
                repaint();
                break;
            }
            case Rectangle: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Rectangle Last = (Rectangle) shapes.get(shapes.size() - 1);
                Last.setP2(Points.get(Points.size() - 1));
                repaint();
                break;
            }
            case Square: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Square Last = (Square) shapes.get(shapes.size() - 1);
                Last.setP2(Points.get(Points.size() - 1));
                repaint();
                break;
            }
            case Oval: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Oval Last = (Oval) shapes.get(shapes.size() - 1);
                Last.setP2(Points.get(Points.size() - 1));
                repaint();
                break;
            }
            case Circle: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Circle Last = (Circle) shapes.get(shapes.size() - 1);
                Last.setP2(Points.get(Points.size() - 1));
                repaint();
                break;
            }
            case Triangle: {
                int x1 = e.getX();
                int y1 = e.getY();
                int x2 = Math.abs(x1 - Points.get(Points.size() - 1).getX_Coordinate()) / 2;
                int y2 = y1;
                Points.add(new Point(x1, y1));
                Points.add(new Point(x2, y2));
                Triangle Last = (Triangle) shapes.get(shapes.size() - 1);
                Last.setP2(new Point(x1, y1));
                Last.setP3(new Point(x2, y2));
                repaint();
                break;
            }
            case RHS: {
                int x1 = e.getX();
                int y1 = e.getY();
//                int x2 = Points.get(Points.size()-1).getX_Coordinate();
//                int y2 = y1;
                Points.add(new Point(x1, y1));
//                Points.add(new Point(x2,y2));
                RightAngledTriangle Last = (RightAngledTriangle) shapes.get(shapes.size() - 1);
                Last.setP2(new Point(x1, y1));
//                Last.setP3(new Point(x2,y2));
                repaint();
                break;
            }
            case Rhombus: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Rhombus Last = (Rhombus) shapes.get(shapes.size() - 1);
                Last.setP2(new Point(x, y));
                repaint();
                break;
            }
            case freeHand: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                FreeHand Last = (FreeHand) shapes.get(shapes.size() - 1);
                Last.Addpoint(new Point(x, y));
                repaint();
                break;
            }
            case Sector: {
                int x = e.getX();
                int y = e.getY();
                Points.add(new Point(x, y));
                Sector Last = (Sector) shapes.get(shapes.size() - 1);
                Last.setP2(new Point(x, y));
                repaint();
                break;
            }
            case Moves: {
                int dx = e.getX() - Points.get(Points.size() - 1).getX_Coordinate();
                int dy = e.getY() - Points.get(Points.size() - 1).getY_Coordinate();
                Shape CurrentShape = utilites.contains(Points.get(Points.size() - 1),shapes);
                if (CurrentShape != null) {
                    utilites.Move(CurrentShape, Points.get(Points.size() - 1), dx, dy);
                }

                repaint();
                break;
            }
            case Resize: {
                int x = e.getX();
                int y = e.getY();
                int dx = e.getX() - Points.get(Points.size() - 1).getX_Coordinate();
                int dy = e.getY() - Points.get(Points.size() - 1).getY_Coordinate();
                System.out.println(x);
                System.out.println(y);
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                setCursor(cursor);
                utilites.Resize(shape, new Point(x, y), new Point(dx, dy));
                repaint();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
// if(P1.getX_Coordinate() > rectangle.getP1().getX_Coordinate() &&
//            P1.getX_Coordinate() < rectangle.getP2().getX_Coordinate() &&
//            P1.getY_Coordinate() > rectangle.getP2().getY_Coordinate() &&
//            P1.getY_Coordinate() < rectangle.getP1().getY_Coordinate())
//    {
//        return true;
//    }


    public Shape delete(LinkedList<Shape> shapes,Point P)
    {
        Shape shape = utilites.contains(P,shapes);
        int index = shapes.indexOf(shape);
        return shapes.remove(index);
    }
}


