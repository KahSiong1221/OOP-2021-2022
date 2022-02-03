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

        playerX = width / 2;
        playerY = height - 50;
        playerWidth = 50;

        resetBug();
        bugWidth = 15;
        bugHeight = 3 * bugWidth / 2;
	}
	
    private void resetBug() {
        bugX = random(bugWidth / 2, width - (bugWidth / 2));
        bugY = 50;
    }

    public void drawPlayer(float x, float y, float w)
    {
        strokeWeight(2);
        stroke(0, 255, 255);
        noFill();
        circle(x, y, w / 2);
        line(x, y - w / 4, x, y - ( w / 4 + 10));
    }

    public void drawBug(float x, float y, float w, float h)
    {
        strokeWeight(2);
        stroke(255, 255, 0);
        noFill();
        ellipse(x, y, w, h);
        line(x - w / 4, y + h / 2, x - w / 3, y + h);
        line(x + w / 4, y + h / 2, x + w / 3, y + h);
    }

    private void moveBug()
    {
        bugY++;
        bugX = random(bugWidth / 2, width - bugWidth / 2);
    }

	public void draw()
	{	
        background(0);
        drawPlayer(playerX, playerY, playerWidth);
        drawBug(bugX, bugY, bugWidth, bugHeight);
        if ((frameCount % 20) == 0)
        {
            moveBug();
        }

        text("Score: " + score, 20, 20);
	}

    float playerSpeed = 15;
    int score = 0;

    public void keyPressed()
    {
        if (keyCode == LEFT)
        {
            if (playerX >= playerWidth / 2 + 10)
            {
                playerX -= playerSpeed;
            }
        }
        if (keyCode == RIGHT)
        {
            if (playerX <= width - playerWidth / 2 - 10)
            {
                playerX += playerSpeed;
            }
        }
        if (key == ' ')
        {
            float halfW = bugWidth / 2;
            if (playerX > bugX - halfW && playerX < bugX + halfW)
            {
                score++;
                resetBug();
                strokeWeight(2);
                stroke(0, 255, 255);
                line(playerX, 0, playerX, playerY - 20);
            }
            else
            {
                strokeWeight(2);
                stroke(0, 255, 255);
                line(playerX, 0, playerX, playerY - 20);
            }
        }
    }
}
