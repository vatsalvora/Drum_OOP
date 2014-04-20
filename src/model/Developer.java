package model;

import java.awt.*;

public class Developer {
	String color;
    Color viewColor;
	public Developer(String color, Color viewColor) {
		this.color = color;
        viewColor = viewColor;
	}
    public Color getViewColor(){return viewColor;}
	public String getColor() {
		return color;
	}
}
