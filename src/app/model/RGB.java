package app.model;

public class RGB
{
    private int red;

    private int green;

    private int blue;

    public RGB(int rgb)
    {
        this.red = rgb >> 16&0x000000FF;
        this.green = rgb >> 8&0x000000FF;
        this.blue = rgb >> 0&0x000000FF;
    }

    public int getRed()
    {
        return this.red;
    }

    public int getGreen()
    {
        return this.green;
    }

    public int getBlue()
    {
        return this.blue;
    }
}
