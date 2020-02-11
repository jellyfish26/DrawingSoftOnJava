package shape;

import java.awt.*;

public class SquareShape implements BaseShape {
    @Override
    public void drawShape(Graphics g, Point basePoint) {
        Polygon squarePolygon = makeSquare(basePoint.getLocation(), 10);
        g.fillPolygon(squarePolygon);
    }

    public static Polygon makeSquare(Point center, int halfLength) {
        Polygon polygon = new Polygon();
        polygon.addPoint(center.x - halfLength, center.y - halfLength);
        polygon.addPoint(center.x + halfLength, center.y - halfLength);
        polygon.addPoint(center.x + halfLength, center.y + halfLength);
        polygon.addPoint(center.x - halfLength, center.y + halfLength);
        return polygon;
    }
}
