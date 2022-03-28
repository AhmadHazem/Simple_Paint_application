/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painter;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author NADER
 */
public class Sector extends Shape{
    private Point P1;
    private Point P2;
    Point[] point = new Point[2];
    public Sector(Color color, Point p1, Point p2,int ids) {
        super(color,ids);
        P1 = p1;
        P2 = p2;
    }

    public Point getP1() {
        return P1;
    }

    public void setP1(Point p1) {
        P1 = p1;
    }

    public Point getP2() {
        return P2;
    }

    public void setP2(Point p2) {
        P2 = p2;
    }

    @Override
    public void draw(Graphics G) {
        double Width = Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate());
        double Length =Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate());
        double angle = Math.atan(Length/Width);
        if(getP1().getX_Coordinate() > getP2().getX_Coordinate() && getP1().getY_Coordinate() > getP2().getY_Coordinate())
        {
            G.drawArc(getP2().getX_Coordinate(), getP2().getY_Coordinate(),
            Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
            Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()),90,90);
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.drawArc(getP1().getX_Coordinate(), getP1().getY_Coordinate(),
            Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
            Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()),-90,90);
        }
        else if(getP2().getX_Coordinate() < getP1().getX_Coordinate() && getP2().getY_Coordinate() > getP1().getY_Coordinate())
        {
            G.drawArc(getP2().getX_Coordinate(), getP1().getY_Coordinate(),
            Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
            Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()),180,90);
        }
        else if(getP2().getX_Coordinate() > getP1().getX_Coordinate() && getP2().getY_Coordinate() < getP1().getY_Coordinate())
        {
            G.drawArc(getP1().getX_Coordinate(), getP2().getY_Coordinate(),
            Math.abs(getP2().getX_Coordinate()- getP1().getX_Coordinate()),
            Math.abs(getP2().getY_Coordinate()-getP1().getY_Coordinate()),0,90);
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
