/*
float map(value, min1, max1, min2, max2)
{
	float relativePos = value - min1;
	float range1 = max1 - min1;
	float range2 = max2 - min2;
	return min2 + (relativePos / range1 * range2);
}
*/

package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{
	int mode = 0;
	float rectX = 0;
	float squareX = 0;
	float squareY = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	
	public void draw()
	{
		background(0);

		switch(mode)	
		{
			case 0:
			{
				float rectW = width / 5;
				// if mouse pointer cross the right border
				if (mouseX >= rectX + rectW)
				{
					rectX += rectW;
				}
				// if mouse pointer cross the left border
				else if (mouseX <= rectX)
				{
					rectX -= rectW;
				}
				// draw rectangle
				noStroke();
				fill(map(1, 0, 2, 0, 255), 255, 255);
				rectMode(CORNER);
				rect(rectX, 0, rectW, height);
				break;
			}
			case 1:
				float squareW = width / 5;
				// if mouse pointer cross the right border
				if (mouseX >= squareX + squareW)
				{
					squareX += squareW;
				}
				// if mouse pointer cross the left border
				else if (mouseX <= squareX)
				{
					squareX -= squareW;
				}
				// if mouse pointer cross the down border
				else if (mouseY >= squareY + squareW)
				{
					squareY += squareW;
				}
				// if mouse pointer cross the top border
				else if (mouseY <= squareY)
				{
					squareY -= squareW;
				}
				// draw square
				noStroke();
				fill(map(1, 0, 2, 0, 255), 255, 255);
				rectMode(CORNER);
				square(squareX, squareY, squareW);
				break;
			case 2:
			{
				rectX = width / 2;
				float rectW = 2 * width / 5;
				float rectH = height / 5;
				
				// if the mouse pointer outside the shape
				if (mouseX >= rectX + (rectW / 2) || mouseX <= rectX - (rectW / 2) || mouseY >= rectX + (rectH / 2) || mouseY <= rectX - (rectH / 2))
				{
					// draw ryan colour shape
					fill(map(1, 0, 2, 0, 255), 255, 255);				
				}
				else
				{
					// draw red colour shape
					fill(0, 255, 255);
				}
				noStroke();
				rectMode(CENTER);
				rect(rectX, rectX, rectW, rectH);
				break;
			}
			case 3:
				noStroke();
				rectMode(CORNER);
				int bars = mouseX / 5;
				float barW = width / (float)bars;
				
				for (int i = 0; i < bars; i++)
				{
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, width), 0, barW, height);
				}
				break;
				/*
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
				textSize(15);
				int gap = 42;
				int mark = gap;
				for (int num = -5; num < 6; num++)
				{
					fill(0, 0, 255);
					// vertical text
					text(str(num), mark, gap / 2);
					// horizontal text
					text(str(num), gap / 2, mark);

					stroke(85, 255, 255);
					// horizontal line
					line(mark, gap, mark, gap * 11);
					// vertical line
					line(gap, mark, gap * 11, mark);
					
					mark += gap;
				}
				break;
			case 9:
				noStroke();
				rectMode(CORNER);
				shapeX = shapeY = 0;
				shapeW = shapeH = 25;
				// horizontal
				for (int i = 1; i < 21; i++)
				{
					shapeX = 0;
					// vertical
					for (int j = 1; j < 21; j++)
					{
						// if index i and j are both even or odd
						if (i % 2 == j % 2)
						{
							shapeHue = 149;
						}
						// if one index is odd, one index is even, vice versa
						else
						{
							shapeHue = 170;
						}
						// draw square
						fill(shapeHue, 255, 255);
						rect(shapeX, shapeY, shapeW, shapeH);
						// increment of hue and shape x
						shapeX += shapeW;
					}
					// increment of shape y
					shapeY += shapeH;
				}

				fill(0,0,255);
				stroke(0,0,255);
				line(250, 250, 250, 50);
				line(250, 250, 250 * sin(50), 50  * sin(50));
				break;
			*/
		}
	}
}
