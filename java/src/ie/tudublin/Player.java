package ie.tudublin;

public class Player 
{
    float x, y;
    float fx, fy;
    float w;
    float halfW;
    int c;

    YASC yasc;

    float rotation;
    
    public Player(float x, float y, float w, int c, YASC yasc)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.c = c;
        halfW = w / 2.0f;
        this.yasc = yasc;
        this.rotation = 0;
    }

    void render()
    {
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);

        // noFill();
        yasc.stroke(c, 255, 255);

        /*
        triangle(x, y, x, y - halfW, x - halfW, y + halfW);
        triangle(x, y, x, y - halfW, x + halfW, y + halfW);
        */

        yasc.line(-halfW, halfW, 0, -halfW);
        yasc.line(0, -halfW, halfW, halfW);
        yasc.line(halfW, halfW, 0, 0);
        yasc.line(0, 0, -halfW, halfW);
        yasc.popMatrix();
    }

    public void update()
    {
        if (yasc.keyPressed)
        {
            if (yasc.key == 'w')
            {
                x += fx;
                y += fy;
            }
            if (yasc.key == 's')
            {
                x -= fx;
                y -= fy;
            }
            if (yasc.key == 'a')
            {
                rotation -= 0.01f;
            }
            if (yasc.key == 'd')
            {
                rotation += 0.01f;
            }
        }
        fx = YASC.sin(rotation);
        fy = - YASC.cos(rotation);
    }
}
