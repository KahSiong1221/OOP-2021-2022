package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		colorMode(RGB);
		background(0);
	}
	
	public void draw()
	{	
		
		background(255, 0, 0); //RGB
		noStroke();

		fill(255, 255, 0);
		circle(250, 250, 400);

		fill(0, 255, 255);
		triangle(250, 10, 50, 410, 450, 410);

		fill(200);
		ellipse(250, 200, 180, 90);

		fill(0);
		circle(250, 200, 60);
		/*
		line(10, 10, 200, 200); // x1, y1, x2, y2
		circle(200, 250, 50); // cx, cy, radius
		ellipse(50, 200, 90, 200); // cx, cy, width, height
		
		stroke(0);
		fill(0, 0 , 255);
		//noFill();
		//noStroke();
		rectMode(CENTER);
		rect(300, 20, 100, 20); //tlx, tly, width, height

		rectMode(CORNER);
		rect(200, 20, 100, 20); //tlx, tly, width, height

		point(20, 300); //px, py

		triangle(10, 400, 50, 450, 300, 200); //x1, y1, x2, y2, x3, y3
		*/
	}
}
