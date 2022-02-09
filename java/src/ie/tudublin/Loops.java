package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{

	int mode = 0;
	float shapeX, shapeY, shapeW, shapeH, shapeX2;
	int shapeHue, size;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		shapeY = 250;
		shapeX = 250;
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
			shapeX = 250;
			shapeY = 250;
		}
		println(mode);
	}

	
	public void draw()
	{
		background(0);

		switch(mode)	
		{
			case 0:
				shapeW = 100;
				shapeH = 500;
				// if mouse pointer cross the right border
				if (mouseX >= shapeX + shapeW / 2)
				{
					shapeX += shapeW / 2;
				}
				// if mouse pointer cross the left border
				else if (mouseX <= shapeX - shapeW / 2)
				{
					shapeX -= shapeW / 2;
				}
				// draw rectangle
				noStroke();
				fill(128,255,255);
				rectMode(CENTER);
				rect(shapeX, shapeY, shapeW, shapeH);
				break;
			case 1:
				shapeW = 100;
				shapeH = 100;
				// if mouse pointer cross the right border
				if (mouseX >= shapeX + shapeW / 2)
				{
					shapeX += shapeW / 2;
				}
				// if mouse pointer cross the left border
				else if (mouseX <= shapeX - shapeW / 2)
				{
					shapeX -= shapeW / 2;
				}
				// if mouse pointer cross the down border
				else if (mouseY >= shapeY + shapeH / 2)
				{
					shapeY += shapeH / 2;
				}
				// if mouse pointer cross the top border
				else if (mouseY <= shapeY - shapeH / 2)
				{
					shapeY -= shapeH / 2;
				}
				// draw square
				noStroke();
				fill(128,255,255);
				rectMode(CENTER);
				rect(shapeX, shapeY, shapeW, shapeH);
				break;
			case 2:
				noStroke();
				shapeW = 200;
				shapeH = 100;
				
				// if the mouse pointer outside the shape
				if (mouseX >= shapeX + shapeW / 2 || mouseX <= shapeX - shapeW / 2 || mouseY >= shapeY + shapeH / 2 || mouseY <= shapeY - shapeH / 2)
				{
					// draw ryan colour shape
					fill(128, 255, 255);
					rectMode(CENTER);
					rect(shapeX, shapeY, shapeW, shapeH);
				}
				else
				{
					// draw red colour shape
					fill(0, 255, 255);
					rectMode(CENTER);
					rect(shapeX, shapeY, shapeW, shapeH);
				}
				break;
			case 3:
				noStroke();
				rectMode(CORNER);
				shapeHue = 0;
				shapeX = shapeY = 0;
				shapeW = 50;
				shapeH = 500;
				// while shape x coordinator within the border
				while (shapeX < width)
				{
					// draw shape
					fill(shapeHue, 255, 255);
					rect(shapeX, shapeY, shapeW, shapeH);
					// increment of shape x and hue
					shapeHue += 18;
					shapeX += 50;
				}
				break;
			case 4:
				noStroke();
				rectMode(CORNER);
				shapeHue = 0;
				shapeX = shapeY = 0;
				shapeW = shapeH = 50;
				// while shape x coordinator within the border
				while (shapeX < width)
				{
					// draw shape
					fill(shapeHue, 255, 255);
					rect(shapeX, shapeY, shapeW, shapeH);
					// increment of shape x, y and hue
					shapeHue += 25;
					shapeX += shapeW;
					shapeY += shapeH;
				}
				break;
			case 5:
				noStroke();
				rectMode(CORNER);
				shapeHue = 0;
				shapeX = shapeY = 0;
				shapeW = shapeH = 50;
				shapeX2 = 500;
				// while shape x coordinator within the border
				while (shapeX < width)
				{
					// draw shape
					fill(shapeHue, 255, 255);
					rect(shapeX, shapeY, shapeW, shapeH);
					rect(shapeX2 - shapeW, shapeY, shapeW, shapeH);
					// increment of shape x, y and hue; decrement of shape x2
					shapeHue += 25;
					shapeX += shapeW;
					shapeX2 -= shapeW;
					shapeY += shapeH;
				}
				break;
			case 6:
				noStroke();
				ellipseMode(CENTER);
				shapeHue = 200;
				for (size = width; size >= 0; size -= 50)
				{
					// draw circle
					fill(shapeHue, 255, 255);
					circle(width / 2, height / 2, size);
					// decrement of hue
					shapeHue -= 18;
				}
				break;
			case 7:
				noStroke();
				ellipseMode(CORNER);
				shapeHue = 0;
				shapeY = 0;
				size = 50;
				// horizontal
				for (int i = 0; i < 10; i++)
				{
					shapeX = 0;
					// increment of starting hue of each line
					shapeHue = 0 + 10 * i;
					// vertical
					for (int j = 0; j < 10; j++)
					{
						// draw circle
						fill(shapeHue, 255, 255);
						circle(shapeX, shapeY, size);
						// increment of hue and shape x
						shapeHue += 10;
						shapeX += size;
					}
					// increment of shape y
					shapeY += size;
				}
				break;
			case 8:
				textAlign(CENTER);
				textSize(10);
				int gap = 42;
				int mark = gap;
				for (int num = -5; num < 6; num++)
				{
					fill(0, 0, 255);
					// vertical text
					text(str(num), mark, gap / 2);
					// horizontal text
					text(str(num), gap / 2, mark);
					
					fill(45, 255, 255);
					// horizontal line
					line(mark, gap, mark, gap * 10);
					// vertical line
					line(gap, mark, gap * 10, mark);
					mark += gap;
				}
				break;
		}
	}
}
