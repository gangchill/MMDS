
package image.operations;

import image.descriptors.ColorHistogram;
import image.descriptors.EdgeHistogram;

import java.awt.image.BufferedImage;

public class ImageCom implements Comparable<ImageCom> {
    public BufferedImage image;
    public BufferedImage grayImage;
    
    public double[][] featureVector;

    public ImageCom(BufferedImage image) {
        this.image = image;
        this.grayImage = ColorConversion.convertImageToBW(image);
    }
    
    public double distance = 0;

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(ImageCom o) {
        return Double.compare(this.distance, o.distance);
    }
    
    public void setFeature(String feature, double param0, double param1){
        if(feature.equals("ColorHistogram")) this.featureVector = ColorHistogram.getColorHistogram(image, (int)param0, (int)param1);
        if(feature.equals("EdgeHistogram")) this.featureVector = EdgeHistogram.getEdgeHistogram(image, param1, (int)param0);
    }
    
    
    
    
}
