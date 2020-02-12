package shape;

import java.awt.*;

public class StarShape implements BaseShape {

    @Override
    public void drawShape(Graphics g, Point basePoint) {
        Polygon starPolygon = makeStar(basePoint, 20, 5);
        g.fillPolygon(starPolygon);
    }

    public static Polygon makeStar(Point center, int radius, int numCorners) {
        Polygon star = new Polygon();
        int half = radius / 2;
        double theta = Math.PI / (double) numCorners;
        double angle = Math.PI / 2.0;
        double vertexX, vertexY;
        for (int i = 0; i < numCorners; i++) {
            vertexX = center.x + radius * Math.cos(angle);
            vertexY = center.y - radius * Math.sin(angle);
            star.addPoint((int) vertexX, (int) vertexY);
            angle += theta;
            vertexX = center.x + half * Math.cos(angle);
            vertexY = center.y - half * Math.sin(angle);
            star.addPoint((int) vertexX, (int) vertexY);
            angle += theta;
        }
        return star;
    }
}
