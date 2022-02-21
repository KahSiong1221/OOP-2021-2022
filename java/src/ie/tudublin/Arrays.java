package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet{

    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    float[] a1 = new float[100];
    float[] a2;
    int maxIndex = 0;
    int minIndex = 0;

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        colorMode(HSB);
        for (int i = 0; i < rainfall.length; i++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        for (float r:rainfall)
        {
            println(r);
        }

        /*
        int i = 0;
        for (float r:rainfall)
        {
            println(r + "\t" + months[i]);
            i++;
        }
        */

        for (int j = rainfall.length - 1; j >= 0; j--)
        {
            println(rainfall[j] + "\t" + months[j]);
        }

        /* my solution:

        float min = rainfall[0];
        float max = rainfall[0];
        float total = rainfall[0];
        for (int k = 1; k < rainfall.length; k++)
        {
            if (rainfall[k] < min)
            {
                min = rainfall[k];
            }
            if (rainfall[k] > max)
            {
                max = rainfall[k];
            }
            total += rainfall[k];
        }

        float average = total / rainfall.length;

        println("Min: " + min + ", Max: " + max + ", Total: " + total + ", Average: " + average);

        */

        //Lecturer solution:
        for (int i = 0; i < rainfall.length; i++)
        {
            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            }
        }
        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);
    }

    public void draw()
    {
        background(0);
        noStroke();
        float barX = 0;
        float barH = 0;
        for (int i = 0; i < rainfall.length; i++)
        {
            fill(map(i, 0, rainfall.length, 0, 255), 255, 255);
            barH = map(rainfall[i], 0, rainfall[maxIndex], 0, height);
            rect(barX, height - barH, width / (float)rainfall.length, barH);
            fill(255);
            textAlign(CENTER, CENTER);
            text(months[i], barX + (width / (float)rainfall.length / 2), height - 50);
            barX += width / (float)rainfall.length;
        }

        /*
        Lecture solution:

        float w = width / (float)rainfall.length;

        for (int i = 0; i < rainfall.length; i++)
        {
            float x = map(i, 0, rainfall.length, 0, width);
            int c  = (int)map(i, 0, rainfall.length, 0, 255);
            fill(c, 255, 255);
            float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
            rect(x, height, w, h);
        }
        */
    }
}
