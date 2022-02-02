package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
    float playerX, playerY, playerWidth;
    float bugX, bugY, bugWidth, bugHeight;

    public void settings()
	{
		size(500, 500);
	}

	public void setup() 
    {
		colorMode(RGB);
		background(0);

        playerX = 250;
        playerY = 450;
        playerWidth = 60;
        bugX = 250;
        bugY = 50;
        bugWidth = 15;
        bugHeight = 3*bugWidth/2;
	}
	
    public void drawPlayer(float x, float y, float w)
    {
        stroke(0, 255, 255);
        fill(0);
        circle(x, y, w/2);
        line(x,y-w/4,x,y-(w/4+10));
    }

    public void drawBug(float x, float y, float w, float h)
    {
        stroke(255, 255, 0);
        fill(0);
        ellipse(x, y, w, h);
        line(x-w/4, y+h/2, x-w/3, y+h);
        line(x+w/4, y+h/2, x+w/3, y+h);
    }

	public void draw()
	{	
        background(0);
        drawPlayer(playerX, playerY, playerWidth);
        drawBug(bugX, bugY, bugWidth, bugHeight);
        if ((frameCount % 60) == 0)
        {
            bugX = random(50, 450);
        }
	}

    public void keyPressed()
    {
        if (keyCode == LEFT)
        {
            if (playerX >= 30)
            {
                playerX -= 10;
            }
        }
        if (keyCode == RIGHT)
        {
            if (playerX <= 470)
            {
                playerX += 10;
            }
        }
        if (key == ' ')
        {
            stroke(0, 255, 255);
            line(playerX,0,playerX,430);
        }
    }
}
