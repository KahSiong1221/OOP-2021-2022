package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{

	int mode = 0;
	float rectX, rectY, rectX2;
	int rectHue, size;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		rectY = 250;
		rectX = 250;
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
			rectY = 250;
			rectX = 250;
		}
		println(mode);
	}

	
	public void draw()
	{
		background(0);

		switch(mode)	
		{
			case 0:
				if (mouseX >= rectX + 50)
				{
					rectX += 50;
				}
				else if (mouseX <= rectX - 50)
				{
					rectX -= 50;
				}
				noStroke();
				fill(128,255,255);
				rectMode(CENTER);
				rect(rectX, rectY, 100, 500);
				break;
			case 1:
				if (mouseX >= rectX + 50)
				{
					rectX += 50;
				}
				else if (mouseX <= rectX - 50)
				{
					rectX -= 50;
				}
				else if (mouseY >= rectY + 50)
				{
					rectY += 50;
				}
				else if (mouseY <= rectY - 50)
				{
					rectY -= 50;
				}
				
				noStroke();
				fill(128,255,255);
				rectMode(CENTER);
				rect(rectX, rectY, 100, 100);
				break;
			case 2:
				noStroke();
				
				if (mouseX >= rectX + 100 || mouseX <= rectX - 100 || mouseY >= rectY + 50 || mouseY <= rectY - 50)
				{
					fill(128, 255, 255);
					rectMode(CENTER);
					rect(rectX, rectY, 200, 100);
				}
				else
				{
					fill(0, 255, 255);
					rectMode(CENTER);
					rect(rectX, rectY, 200, 100);
				}

				break;
			case 3:
				noStroke();
				rectHue = 0;
				rectX = 0;
				while (rectX < 500)
				{
					fill(rectHue, 255, 255);
					rect(rectX + 25, 250, 50, 500);
					rectHue += 18;
					rectX += 50;
				}
				break;
			case 4:
				noStroke();
				rectHue = 0;
				rectX = 0;
				rectY = 0;
				while (rectX < 500)
				{
					fill(rectHue, 255, 255);
					rect(rectX + 25, rectY + 25, 50, 50);
					rectHue += 25;
					rectX += 50;
					rectY += 50;
				}
				break;
			case 5:
				noStroke();
				rectHue = 0;
				rectX = 0;
				rectY = 0;
				rectX2 = 500;
				while (rectX < 500)
				{
					fill(rectHue, 255, 255);
					rect(rectX + 25, rectY + 25, 50, 50);
					rect(rectX2 - 25, rectY + 25, 50, 50);
					rectHue += 25;
					rectX += 50;
					rectX2 -= 50;
					rectY += 50;
				}
				break;
			case 6:
				noStroke();
				rectHue = 200;
				for (size = 500; size >= 0; size -= 50)
				{
					fill(rectHue, 255, 255);
					ellipse(250, 250, size, size);
					rectHue -= 18;
				}
				break;
			case 7:
				noStroke();
				rectHue = 0;
				rectX = 0;
				size = 50;
				while (rectX < 500)
				{
					fill(rectHue, 255, 255);
					ellipse(rectX + 25, 25, size, size);
					rectHue += 18;
					rectX += 50;
				}
				break;
			case 8:
				noStroke();
				rectHue = 0;
				rectX = 0;
				rectY = 0;
				size = 50;
				for (int i = 0; i < 10; i++)
				{
					rectX = 0;
					
					for (int j = 0; j < 10; j++)
					{
						fill(rectHue, 255, 255);
						ellipse(rectX + 25, rectY + 25, size, size);
						rectX += 50;
						rectHue += 10;
					}

					rectY += 50;
				}
				break;
		}
	}
}
