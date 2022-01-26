package ie.tudublin;

public class Cat extends Animal
{
    private int numLives;

    public int getNumLives()
    {
        return numLives;
    }
    
    public Cat(String name)
    {
        super(name);
        this.numLives = 9;
    }

    public void kill()
    {
        numLives = getNumLives();

        if (numLives > 0)
        {
            numLives -= 1;
            System.out.println("Ouch!");
        }
        else
        {
            System.out.println("Dead");
        }
    }
}