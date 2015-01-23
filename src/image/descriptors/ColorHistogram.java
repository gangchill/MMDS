package image.descriptors;

import image.operations.GetSubImage;

import java.awt.image.BufferedImage;

public class ColorHistogram {

public static double[][] getColorHistogram(BufferedImage image, int bins, int cells){
        
        BufferedImage[] images = GetSubImage.calculateSubImage(image, cells);
        
        double[][] vector = new double[3*cells*cells][bins];
        
        for (int i = 0; i < images.length; i++) {
            BufferedImage bufferedImage = images[i];
            double[][] colorHistogramFromSubimage = getColorHistogramFromSubimage(bufferedImage, bins);
            for (int j = 0; j < bins; j++) {
                vector[(i*3)+0][j] = colorHistogramFromSubimage[0][j];
                vector[(i*3)+1][j] = colorHistogramFromSubimage[1][j];
                vector[(i*3)+2][j] = colorHistogramFromSubimage[2][j];
            }
        }

        return vector;
    }
    
    private static double[][] getColorHistogramFromSubimage(BufferedImage image, int bins){
        
        int[] r = new int[bins];
        int[] g = new int[bins];
        int[] b = new int[bins];
        
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int rgb = image.getRGB(j, i);                
                int red   = (rgb & 0x00ff0000) >> 16;
                int green = (rgb & 0x0000ff00) >> 8;
                int blue  =  rgb & 0x000000ff;
                r[red / (int)Math.rint(256/(bins-1))]++;
                g[green / (int)Math.rint(256/(bins-1))]++;
                b[blue / (int)Math.rint(256/(bins-1))]++;
            }
        }
        
        int pixel = (image.getWidth() * image.getHeight());
        double[][] vector = new double[3][bins];
        for (int i = 0; i < r.length; i++) {
            vector[0][i] = (double)r[i]/(pixel*3);
            vector[1][i] = (double)g[i]/(pixel*3);
            vector[2][i] = (double)b[i]/(pixel*3);
        }        
        return vector;
    }
	
}
