package drawing;

import java.util.ArrayList;

public class DrawingShape {
    private int vertex;
    private String shapeName;
    private ArrayList<Integer> x, y;

    public DrawingShape(int vertex, String name) {
        this.vertex = vertex;
        this.shapeName = name;
        this.x = new ArrayList<>(vertex);
        this.y = new ArrayList<>(vertex);
    }

    public boolean drawShapeToCustomGraphics(CustomGraphics2D graphics2D) {
        if (this.x.size() != vertex) return false;
        graphics2D.drawShape(this.x, this.y);
        this.x = new ArrayList<>(this.vertex);
        this.y = new ArrayList<>(this.vertex);
        return true;
    }

    public void setVertex(int x, int y) {
        this.x.add(x);
        this.y.add(y);
    }

    public int getVertex() {
        return vertex;
    }

    public String getShapeName() {
        return shapeName;
    }
}
