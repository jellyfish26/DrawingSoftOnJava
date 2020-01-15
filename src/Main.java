import java.awt.Color;

public class Main {
	public static void main(String[] args) {
		DrawingJFrame window = new DrawingJFrame();
		ChangeColorButton blackButton = new ChangeColorButton(window.getMousePaintListener(), "black", new Color(0, 0, 0));
		ChangeColorButton redButton = new ChangeColorButton(window.getMousePaintListener(), "red", new Color(255, 0, 0));
		ChangeShapeButton straightLineButton = new ChangeShapeButton(window.getMousePaintListener(), "line", 2);
		ChangeShapeButton triangleLineButton = new ChangeShapeButton(window.getMousePaintListener(), "triangle", 3);
		blackButton.setLocationAndSize(20, 400);
		redButton.setLocationAndSize(100, 400);
		straightLineButton.setLocationAndSize(180, 400);
		triangleLineButton.setLocationAndSize(260, 400);
		window.add(blackButton);
		window.add(redButton);
		window.add(straightLineButton);
		window.add(triangleLineButton);
	}
}
