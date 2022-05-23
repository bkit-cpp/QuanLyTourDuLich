package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PassWordFielAmination extends JPasswordField {
	
	private Color backgroundColor = Color.WHITE;
	private int radius = 0;
	private int width = 0;
	private int height = 0;
	private int borderWeight = 1;
	private Color borderColor;
	private boolean fontt = false;
	
	public boolean getFontt() {
		return fontt;
	}

	public void setFontt(Boolean fontt) {
		this.fontt = fontt;
	}
	
	public PassWordFielAmination() {
		setBackground(new Color(255, 255, 255, 0));
		setOpaque(false);
		setMargin(getMargin());
		setMaximumSize(getSize());
		setMinimumSize(getSize());
		setBorder(getBorder());
	}
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		width = getWidth();
		height = getHeight();
		if (!fontt)
			setFont(new Font("Tahoma", Font.BOLD, height * 4 / 7));
		else
			setFont(new Font("Tahoma", Font.BOLD, height * 3 / 7));
		
		if (radius == 0) 
			radius = height;
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, width, height, radius, radius);
		super.paintComponent(g);
		g2.dispose();
	}
	
	public void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
        if (borderWeight >= 2) {
        	g2.setColor(borderColor);
        	g2.drawRoundRect(1, 1, getWidth()-3, getHeight()-3, radius, radius);
        } 
        if (borderWeight >= 3) {
        	g2.setColor(borderColor);
        	g2.drawRoundRect(2, 2, getWidth()-5, getHeight()-5, radius, radius);
        } 
        if (borderWeight == 4) {
        	g2.setColor(borderColor);
        	g2.drawRoundRect(3, 3, getWidth()-7, getHeight()-7, radius, radius);
        }
        g2.dispose();
   }

}
