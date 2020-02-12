package drawing;

import color.CustomColorMenuItem;
import color.SetColorMenuItem;
import file.FileChooserMenuItem;
import file.NewGraphicsMenuItem;
import line.*;
import listener.MousePaintListener;
import listener.SetMousePaintListener;
import shape.SquareShape;
import shape.StarShape;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DrawingJFrame extends JFrame {
	private final int FRAME_WIDTH = 700, FRAME_HEIGHT = 600;
	private final int PANEL_WIDTH = 500, PANEL_HEIGHT = 500;
	private MousePaintListener paintListener;
	private JMenuBar menuBar;
	private PenBehaviorComboBox penRelateComboBox;
	private DrawingJPanel drawPanel;
	private SetStampPen stampPen;

	public DrawingJFrame() {
		super("Drawing Software");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
		drawPanel = new DrawingJPanel(PANEL_WIDTH, PANEL_HEIGHT);
		drawPanel.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		drawPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		add(drawPanel);
		setMenuBar();
		addButton();
	}
	
	public synchronized void addMousePaintListener(MousePaintListener mpl) {
		addMouseListener(mpl);
		addMouseMotionListener(mpl);
	}

	public MousePaintListener getMousePaintListener() {
		return this.paintListener;
	}

	public Component[] add(Component... comp) {
		Component[] values = new Component[comp.length];
		for (int i = 0; i < comp.length; i++) values[i] = super.add(comp[i]);
		return values;
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (!b) return;
		paintListener = new MousePaintListener(drawPanel);
		for (Component component : getContentPane().getComponents()) {
			if (component instanceof SetMousePaintListener) {
				((SetMousePaintListener) component).setMousePaintListener(paintListener);
			}
		}
		drawPanel.addMousePaintListener(paintListener);
		for (int menuBarIndex = 0; menuBarIndex < menuBar.getMenuCount(); menuBarIndex++) {
			setMousePaintListenerToMenu(menuBar.getMenu(menuBarIndex));
		}
		drawPanel.addMouseMotionListener(paintListener);
		penRelateComboBox.setMousePaintListener(paintListener);
	}

	private void setMousePaintListenerToMenu(JMenuItem menu) {
		if (menu == null) return;
		if (menu instanceof JMenu) {
			for (int menuIndex = 0; menuIndex < ((JMenu) menu).getItemCount(); menuIndex++) {
				setMousePaintListenerToMenu(((JMenu) menu).getItem(menuIndex));
			}
		} else if (menu instanceof SetMousePaintListener) {
			((SetMousePaintListener) menu).setMousePaintListener(paintListener);
		}
	}

	private void addButton() {
		SetStampButton setStarStampButton = new SetStampButton("Star", new StarShape(), stampPen);
		SetStampButton setSquareStampButton = new SetStampButton("Square", new SquareShape(), stampPen);
		setStarStampButton.setLocationAndSize(500, 0);
		setSquareStampButton.setLocationAndSize(500 + SetStampButton.SIZE_WIDTH, 0);
		add(setStarStampButton);
		add(setSquareStampButton);
	}

	private void setMenuBar() {
		menuBar = new JMenuBar();
		menuBar.add(setFileMenu());
		menuBar.add(setColorMenu());
		menuBar.add(setLineMenu());
		penRelateComboBox = setPenBehaviorComboBox();
		menuBar.add(penRelateComboBox);
		setJMenuBar(menuBar);
	}

	private JMenu setFileMenu() {
		JMenu fileRelate = new JMenu("File");
		fileRelate.add(new NewGraphicsMenuItem("New File", drawPanel.getCustomGraphics(), Color.WHITE));
		fileRelate.add(new FileChooserMenuItem("Save", 1, this,
				drawPanel.getCustomGraphics(), "png", "jpg"));
		fileRelate.add(new FileChooserMenuItem("Load", 0, this,
				drawPanel.getCustomGraphics(), "png", "jpg"));
		return fileRelate;
	}

	private JMenu setColorMenu() {
		JMenu colorRelate = new JMenu("Color");
		colorRelate.add(new SetColorMenuItem("Black", new Color(0, 0, 0)));
		colorRelate.add(new SetColorMenuItem("Red", new Color(255, 0, 0)));
		colorRelate.add(new SetColorMenuItem("Green", new Color(0, 255, 0)));
		colorRelate.add(new CustomColorMenuItem("Custom Color", this));
		return colorRelate;
	}

	private JMenu setLineMenu() {
		JMenu lineRelate = new JMenu("Line");
		lineRelate.add(new SetThicknessMenuItem("thin", 1));
		lineRelate.add(new SetThicknessMenuItem("normal", 3));
		lineRelate.add(new SetThicknessMenuItem("thick", 5));
		return lineRelate;
	}

	private PenBehaviorComboBox setPenBehaviorComboBox() {
		Color[] colors = {
				new Color(255, 0, 0),
				new Color(255, 127, 0),
				new Color(255, 255, 0),
				new Color(0, 127, 0),
				new Color(0, 255, 255),
				new Color(0,0, 255),
				new Color(127, 0, 0)
		};
		PenBehavior[] penBehaviors = {
				new SetNormalPen("pen", null),
				new SetErasePen("erase pen"),
				new SetColorfulPen("colorful pen", 4, colors),
				new SetShapePen("line", 2),
				new SetShapePen("triangle", 3),
				new SetInputCharPen("input character"),
				new SetStampPen("draw Stamp")
		};
		stampPen = (SetStampPen) penBehaviors[6];
		PenBehaviorComboBox penRelate = new PenBehaviorComboBox(penBehaviors);
		return penRelate;
	}
}
