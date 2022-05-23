package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BtnTimKiem extends JButton {
	
	private boolean over;
	private Color color;
	private Color colorClick = new Color(99, 191, 235);
	private int radius = 0;
	private int width = 0;
	private int height = 0;
	private Color colorOver = new Color(46, 173, 233);
	private Color borderColor = new Color(30, 90, 153);
	
	
	public int getWidtht() {
		return width;
	}

	public void setWidtht(int width) {
		this.width = width;
	}

	public int getHeightt() {
		return height;
	}

	public void setHeightt(int height) {
		this.height = height;
	}

	public BtnTimKiem(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public BtnTimKiem(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public BtnTimKiem(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public BtnTimKiem(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public BtnTimKiem(boolean over, Color color, Color colorOver, Color colorClick, Color borderColor, int radius) {
		super();
		this.over = over;
		this.color = color;
		this.colorOver = colorOver;
		this.colorClick = colorClick;
		this.borderColor = borderColor;
		this.radius = radius;
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}

	public Color getColorOver() {
		return colorOver;
	}

	public void setColorOver(Color colorOver) {
		this.colorOver = colorOver;
		repaint();
	}

	public Color getColorClick() {
		return colorClick;
	}

	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
		repaint();
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		repaint();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		repaint();
	}

	public BtnTimKiem() {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBackground(Color.WHITE);
		setContentAreaFilled(false);
		//setRadius(radius);
		setText("Tìm kiếm");
		//setFont(getFont());
		setBorder(null);
		setFocusable(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(Color.white);
				setBackground(colorOver);
				over = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
				over = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(colorClick);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (over) {
					setBackground(colorOver);
				} else {
					setBackground(color); 
				}
			}
		
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		setWidtht(getWidth());
		setHeightt(getHeight());
		width = getWidth();
		height = getHeight();
		setIcon(new ImageIcon(new ImageIcon(".\\img\\them, sua, xoa, tim kiem\\icons8-find-91.png").getImage().getScaledInstance(getWidth() / 6, getHeight() * 3 / 5, Image.SCALE_DEFAULT)));
		setFont(new Font("Tahoma", Font.BOLD, height / 2));
		setRadius(height * 3 / 7);
		if (radius == 0)
			radius = height;
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setColor(borderColor);
		g2.fillRoundRect(0, 0, width, height, radius, radius);
		g2.setColor(getBackground());
		g2.fillRoundRect(2, 2, width - 4, height - 4, radius -4, radius-4 );

		super.paintComponent(g);
		g2.dispose();
	}
}
