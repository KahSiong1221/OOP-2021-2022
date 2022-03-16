package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {


    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };

    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    //float[] a1 = new float[100];
    //float[] a2;
    int minIndex = 0;
    int maxIndex = 0;
    float sum;

    int mode = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}
        

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        background(0);
        colorMode(HSB);

        for (int i = 0; i < rainfall.length; i++)
        {
            println(rainfall[i] + "\t" + months[i]);

            sum += rainfall[i];
        }

        for (float r:rainfall)
        {
            println(r);
        }
        
        int j = 0;
        for (float r:rainfall)
        {
            println(r + "\t" + months[j]);
            j++;
        }

        for (int i = rainfall.length - 1; i >= 0; i--)
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        for(int i = 1; i < rainfall.length; i++)
        {
            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            else if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            } 
        }

        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);
    }

    public void draw()
    {
        switch (mode) 
        {
            // bar chart
			case 0:
            {
                background(0);
                noStroke();

                float barWidth = width / (float)rainfall.length;

                for (int i = 0; i < rainfall.length; i++)
                {
                    float barX = map(i, 0, rainfall.length, 0, width);
                    int barColour = (int)map(i, 0, rainfall.length, 0, 255);
                    float barHeight = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);

                    fill(barColour, 255, 255);
                    rect(barX, height, barWidth, barHeight);

                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(months[i], barX + (barWidth / 2), height - 50);
                }

                break;
            }
            case 1:
            {
                background(0);
                stroke(255);

                float border = width * 0.1f;

                // axis
                fill(255);
                line(border, border, border, height - border);
                line(border, height - border, height - border, height - border);

                textAlign(CENTER, CENTER);
                for (int i = 0; i <= 120; i += 10)
                {
                    float markY = map(i, 0, 120, height - border, border);
                    
                    text(i, border / 2, markY);
                    line(border - border / 5, markY, border, markY);
                }

                // title
                text("Rainfall Bar Chart", width / 2, border / 2);

                // bar and month
                float barWidth = (width - 2 * border) / (float)rainfall.length;

                for (int i = 0; i < rainfall.length; i++)
                {
                    float barX = map(i, 0, rainfall.length, border, width - border);
                    float barHeight = map(rainfall[i], 0, rainfall[maxIndex], 0, -(height - 2 * border));
                    float barColour = map(i, 0, rainfall.length, 0, 255);

                    fill(barColour, 255, 255);
                    rect(barX, height - border, barWidth, barHeight);

                    fill(255);
                    text(months[i], barX + barWidth / 2, height - border / 2);
                }

                break;
            }
            case 2:
            {
                background(0);
                stroke(255);

                float border = width * 0.1f;

                // axis
                fill(255);
                line(border, border, border, height - border);
                line(border, height - border, height - border, height - border);

                textAlign(CENTER, CENTER);
                for (int i = 0; i <= 120; i += 10)
                {
                    float markY = map(i, 0, 120, height - border, border);
                    
                    text(i, border / 2, markY);
                    line(border - border / 5, markY, border, markY);
                }

                // title
                text("Rainfall Trend Chart", width / 2, border / 2);

                // trend line and month
                float gap = (width - 2 * border) / (float)rainfall.length;
                float startX = border + gap / 2;
                float startY = map(rainfall[0], 0, 120, height - border, border);

                text(months[0], startX, height - border / 2);
                
                for (int i = 1; i < rainfall.length; i++)
                {
                    fill(255);
                    float endX = map(i, 0, rainfall.length - 1, border + (gap / 2), width - border - (gap / 2));
                    float endY = map(rainfall[i], 0, 120, height - border, border);
                    line(startX, startY, endX, endY);

                    fill(255);
                    text(months[i], endX, height - border / 2);

                    startX = endX;
                    startY = endY;
                }

                break;
            }
            case 3:
            {
                background(0);

                // title
                fill(255);
                text("Rainfall Piechart", width / 2, (width * 0.1f) / 2);

                float startAngle = 0;

                // pie chart
                for (int i = 0; i < rainfall.length; i++)
                {
                    // arc
                    float colour = map(i, 0, rainfall.length, 0, 255);
                    float angle = map(rainfall[i], 0, sum, 0, TWO_PI);
                    fill(colour, 255, 255);
                    arc(width / 2, height / 2, mouseX * 2, mouseX * 2, startAngle, startAngle + angle, PIE);

                    // text
                    float theta = startAngle + (angle * 0.5f);
                    float x = width / 2 + cos(theta) * (mouseX * 1.2f);
                    float y = height / 2 + sin(theta) * (mouseX * 1.2f);
                    fill(255);
                    text(months[i], x, y);

                    startAngle += angle;
                }


                break;
            }
            /*
            case 2:
                background(0);
                float r = mouseX;
                float cx = width / 2;
                float cy = height / 2;
                stroke(255);
                noFill();
                //circle(cx, cy, r * 2.0f);
                float tot = 0;
                for(float f:rainfall)
                {
                    tot += f;
                }
                float start = 0;
                for(int i = 0 ; i < rainfall.length ; i ++)
                {
                    float val = map(rainfall[i], 0, tot, 0, TWO_PI);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    noStroke();
                    fill(c, 255, 255);
                    arc(cx, cy, r * 2, r * 2, start, start + val, PIE);
                    
                    float theta = start + (val * 0.5f);
                    float x = cx + cos(theta) * (r * 1.2f);
                    float y = cy + sin(theta) * (r * 1.2f);
                    fill(255);
                    text(months[i], x, y);
                    start = start + val;
                    
                }

                break;  
            */   
        }  
    }  
}
