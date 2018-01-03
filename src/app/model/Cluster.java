package app.model;

public class Cluster
{
    private int id;

    private int red;

    private int green;

    private int blue;

    private int redCount;

    private int greenCount;

    private int blueCount;

    private int pixelCount;

    public Cluster(int id, int rgb)
    {
        this.id = id;

        RGB colorRGB = new RGB(rgb);
        this.red = colorRGB.getRed();
        this.green = colorRGB.getGreen();
        this.blue = colorRGB.getBlue();
    }

    public int getId()
    {
        return this.id;
    }

    public int getRGB() {
        int r = redCount / pixelCount;
        int g = greenCount / pixelCount;
        int b = blueCount / pixelCount;
        return 0xff000000 | r << 16 | g << 8 | b;
    }

    public void clear()
    {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.redCount = 0;
        this.greenCount = 0;
        this.blueCount = 0;
    }

    public void addPixel(int rgb)
    {
        RGB colorRGB = new RGB(rgb);
        this.redCount += colorRGB.getRed();
        this.greenCount += colorRGB.getGreen();
        this.blueCount += colorRGB.getBlue();
        this.pixelCount++;
        this.recalculate();
    }

    public void removePixel(int rgb)
    {
        RGB colorRGB = new RGB(rgb);
        this.redCount -= colorRGB.getRed();
        this.greenCount -= colorRGB.getGreen();
        this.blueCount -= colorRGB.getBlue();
        this.pixelCount--;
        this.recalculate();
    }

    public int distance(int rgb)
    {
        RGB colorRGB = new RGB(rgb);
        int rx = Math.abs(this.red - colorRGB.getRed());
        int gx = Math.abs(this.green - colorRGB.getGreen());
        int bx = Math.abs(this.blue - colorRGB.getBlue());
        return (rx + gx + bx) / 3;
    }

    private void recalculate()
    {
        this.red = redCount / pixelCount;
        this.green = greenCount / pixelCount;
        this.blue = blueCount / pixelCount;
    }
}
