package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{
    Player p1;
    Player p2;
    Health h;

    public void setup()
    {
        p1 = new Player(100, 100, 50, 255, this);
        p2 = new Player(200, 200, 100, 128, this);
        h = new Health(50, this);
        colorMode(HSB);
    }

    public void settings()
    {
        size(500, 500);

    }

    public void draw()
    {
        background(0);

        p1.update();
        p1.render();
        p2.update();
        p2.render();
        h.update();
        h.render();
    }    
}
