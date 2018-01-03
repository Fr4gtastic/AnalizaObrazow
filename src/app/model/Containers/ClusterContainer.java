package app.model.Containers;

import app.model.Cluster;

import java.awt.image.BufferedImage;

public class ClusterContainer {
    private Cluster[] clusters;

    public ClusterContainer()
    {

    }

    public void createClusters(BufferedImage image, int k)
    {
        this.clusters = new Cluster[k];
        int x = 0, y = 0;
        int dx = image.getWidth() / k;
        int dy = image.getHeight() / k;
        for(int i = 0; i < k; i++) {
            this.clusters[i] = new Cluster(i, image.getRGB(x, y));
            x += dx;
            y += dy;
        }
    }

    public Cluster getCluster(int id)
    {
        return this.clusters[id];
    }

    public int size()
    {
        return this.clusters.length;
    }

    public Cluster minimal(int rgb)
    {
        int min = Integer.MAX_VALUE;
        int distance;
        int minimalId = -1;
        for(int i = 0; i < this.size(); i++) {
            distance = this.getCluster(i).distance(rgb);
            if(distance < min) {
                min = distance;
                minimalId = i;
            }
        }
        return this.getCluster(minimalId);
    }

    public void clear()
    {
        this.clusters = null;
    }
}
