package app.model;

import javafx.stage.Stage;

public class App
{
    private Stage stage;

    private Image originalImage;

    private Image processedImage;

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public Stage getStage()
    {
        return this.stage;
    }

    public void setOriginalImage(Image originalImage)
    {
        this.originalImage = originalImage;
    }

    public Image getOriginalImage()
    {
        return this.originalImage;
    }

    public void setProcessedImage(Image processedImage)
    {
        this.processedImage = processedImage;
    }

    public Image getProcessedImage()
    {
        return processedImage;
    }
}
