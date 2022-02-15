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
	float offset = 0;

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
			{
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
			}
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
			{
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
			}
			case 4:
			{
				noStroke();
				rectMode(CORNER);
				int squares = mouseX / 10;
				float squareW = width / (float)squares;

				for (int i = 0; i < squares; i++) 
				{
					fill(map(i, 0, squares, 0, 255), 255, 255);
					squareX = map(i, 0, squares, 0, width);
					square(squareX, squareX, squareW);
					square((width - squareW) - squareX, squareX, squareW);
				}
				break;
			}
			case 5:
			{
				noStroke();
				ellipseMode(CENTER);
				int circles = mouseX / 5;
				offset += mouseY / 500.0f;

				for (int i = circles; i > 0; i--)
				{
					// draw circle
					fill(map(i + offset, 0, circles, 0, 255) % 256, 255, 255);
					circle(width / 2, height / 2, map(i, 0, circles, 0, width));
				}
				break;
			}
			case 6:
			{
				background(255);
				noStroke();
				ellipseMode(CORNER);
				int circles = mouseX / 20;
				// diameter of circle
				float circleD = width / (float)circles;
				offset += mouseY / 500.0f;

				for (int i = 0; i < circles; i++)
				{
					for (int j = 0; j < circles; j++)
					{
						float circleHue = map(i + j + offset, 0, circles * 2, 0, 255) % 256;
						fill(circleHue, 255, 255);
						float circleX = map(i, 0, circles, 0, width);
						float circleY = map(j, 0, circles, 0, width);
						circle(circleX, circleY, circleD);
					}
				}
				break;
			}
			case 7:
			{
				textAlign(CENTER);
				textSize(15);
				int lines = mouseX / 20;
				float gap = width / (float)(lines + 1);

				for (int i = 0; i < lines; i++)
				{
					float lineX = map(i, 0, lines - 1, gap, width - gap);
					float num;
					if (lines % 2 == 0)
					{
						num = map(i, 0, lines - 1, 1 - lines / 2, lines / 2);
					}
					else
					{
						num = map(i, 0, lines - 1, 0 - lines / 2, lines / 2);
					}

					fill(0, 0, 255);
					// vertical text
					text((int)num, lineX, gap / 2);
					// horizontal text
					text((int)num, gap / 2, lineX);

					stroke(85, 255, 255);
					// horizontal line
					line(lineX, gap, lineX, height - gap);
					// vertical line
					line(gap, lineX, width - gap, lineX);
				}
				break;
			}
			case 8:
			{
				noStroke();
				rectMode(CORNER);
				int squares = mouseX / 10;
				float squareW = width / (float)squares;
				float squareHue;
				// horizontal
				for (int i = 0; i < squares; i++)
				{
					// vertical
					for (int j = 0; j < squares; j++)
					{
						// if index i and j are both even or odd
						if (i % 2 == j % 2)
						{
							squareHue = map(mouseY, 0, height, 0, 255);
						}
						else
						{
							squareHue = (map(mouseY, 0, height, 0, 255) + 25) % 256;
						}

						squareX = map(i, 0, squares, 0, width);
						squareY = map(j, 0, squares, 0, width);
						// draw square
						fill(squareHue, 255, 255);
						square(squareX, squareY, squareW);
					}
				}
				break;
			}
			case 9:
			{
				stroke(0);
				background(255);
				fill(0, 0, 255);
				line(width / 2, height / 2, width / 2, 50);
				
			}
		}
	}
}
