package drawing;

import color.CustomColorMenuItem;
import color.SetColorMenuItem;
import file.FileChooserMenuItem;
import file.NewGraphicsMenuItem;
import line.*;
import listener.MousePaintListener;
import listener.SetMousePaintListener;

import javax.swing.*;
import java.awt.*;

public class DrawingJFrame extends JFrame {
	private final int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;
	private MousePaintListener paintListener;
	private JMenuBar menuBar;
	private PenBehaviorComboBox penRelateComboBox;
	private DrawingJPanel drawPanel;

	public DrawingJFrame() {
		super("Drawing Software");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		drawPanel = new DrawingJPanel(FRAME_WIDTH, FRAME_HEIGHT);
		add(drawPanel);
		setMenuBar();
	}
	
	public synchronized void addMousePaintListener(MousePaintListener mpl) {
		addMouseListener(mpl);
		addMouseMotionListener(mpl);
	}

	public MousePaintListener getMousePaintListener() {
		return this.paintListener;
	}

	public Component[] add(Component[] comp) {
		Component[] values = new Component[comp.length];
		for (int i = 0; i < comp.length; i++) values[i] = super.add(comp[i]);
		return values;
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (!b) return;
		paintListener = new MousePaintListener(drawPanel);
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
		PenBehavior[] penBehaviors = {new SetNormalPen("pen"),
				new SetShape("line", 2), new SetShape("triangle", 3)};
		PenBehaviorComboBox penRelate = new PenBehaviorComboBox(penBehaviors);
		return penRelate;
	}
}
