package app.model;

import app.model.Containers.ClusterContainer;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ImageProcessor
{
    private static final int NOT_IN_CLUSTER = -1;

    private ClusterContainer clusters;

    public ImageProcessor()
    {

    }

    public BufferedImage segmentate(BufferedImage image, int k)
    {
        this.createClusters(image, k);
        int[] lookup = new int[image.getWidth() * image.getHeight()];
        Arrays.fill(lookup, NOT_IN_CLUSTER);

        boolean pixelChangedCluster = true;
        while (pixelChangedCluster)
        {
            pixelChangedCluster = false;

            for(int x = 0; x < image.getWidth(); x++) {
                for(int y = 0; y < image.getHeight(); y++) {
                    int currPixel = image.getRGB(x, y);
                    Cluster minCluster = clusters.minimal(currPixel);
                    int currLookup = lookup[x + image.getWidth() * y];
                    if(currLookup != minCluster.getId()) {

                        //Continouous
                        if(currLookup != NOT_IN_CLUSTER) {
                            this.clusters.getCluster(currLookup).removePixel(currPixel);
                        }
                        minCluster.addPixel(currPixel);
                        pixelChangedCluster = true;
                        lookup[x + image.getWidth() * y] = minCluster.getId();
                    }
                }
            }
        }

        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                int clustedId = lookup[x + image.getWidth() * y];
                result.setRGB(x, y, this.clusters.getCluster(clustedId).getRGB());
            }
        }

        return result;
    }

    private void createClusters(BufferedImage image, int k)
    {
        if(this.clusters == null) {
            this.clusters = new ClusterContainer();
        } else {
            this.clusters.clear();
        }
        this.clusters.createClusters(image, k);
    }
}
