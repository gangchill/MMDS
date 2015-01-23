package image.descriptors;

import image.operations.GetSubImage;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class EdgeHistogram {
	
public static double[][] getEdgeHistogram(BufferedImage image, double threshold, int blockSize){
        
        double[][] vector = new double[1][80];
        
        int total = 0;
        
        BufferedImage[] images = GetSubImage.calculateSubImage(image, 4);
        for (int i = 0; i < images.length; i++) {
            int[] edgeTypeCounter = new int[5];
            BufferedImage[] subBlocks = GetSubImage.extractBlocks(images[i], blockSize); //multiple of 2 ?
            for (int j = 0; j < subBlocks.length; j++) {
                int edgeType = getEdgeType(subBlocks[j], threshold);
                if(edgeType!=-1){
                    edgeTypeCounter[edgeType]++;
                    total++;
                } 
            }
            vector[0][i*5 +0] = edgeTypeCounter[0];
            vector[0][i*5 +1] = edgeTypeCounter[1];
            vector[0][i*5 +2] = edgeTypeCounter[2];
            vector[0][i*5 +3] = edgeTypeCounter[3];
            vector[0][i*5 +4] = edgeTypeCounter[4];
        }
        
        
        for (int i = 0; i < 80; i++) {
            vector[0][i] = vector[0][i] / (double)total;
            System.out.print(vector[0][i]+" ");
        }
        System.out.println();
         
        return vector;
    }
    
    private static int getEdgeType(BufferedImage block, double threshold){
        BufferedImage[] subimages = GetSubImage.calculateSubImage(block, 2);
        double[] luminanceMean = new double[4];
        luminanceMean[0] = getLuminanceMean(subimages[0]);
        luminanceMean[1] = getLuminanceMean(subimages[1]);
        luminanceMean[2] = getLuminanceMean(subimages[2]);
        luminanceMean[3] = getLuminanceMean(subimages[3]);

        double[] ver_edge_filter = {1, -1, 1, -1};
        double[] hor_edge_filter = {1, 1, -1, -1};
        double[] dia45_edge_filter = {Math.sqrt(2), 0, 0, Math.sqrt(2)};
        double[] dia135_edge_filter = {0, Math.sqrt(2), Math.sqrt(2), 0};
        double[] nond_edge_filter = {2, -2, -2, 2};

        double[] convolution = new double[5];
        convolution[0] = convolve(luminanceMean, ver_edge_filter);
        convolution[1] = convolve(luminanceMean, hor_edge_filter);
        convolution[2] = convolve(luminanceMean, dia45_edge_filter);
        convolution[3] = convolve(luminanceMean, dia135_edge_filter);
        convolution[4] = convolve(luminanceMean, nond_edge_filter);        
        
        double max = Math.max(convolution[0], Math.max(convolution[1], Math.max(convolution[2], Math.max(convolution[3], convolution[4]))));
        if(max<threshold) return -1;
        for (int i = 0; i < convolution.length; i++) {
            if(convolution[i]==max) return i;
        }
        return -1;
    }
    
    static double getLuminanceMean(BufferedImage image) {
        double mean = 0;
        int width = image.getWidth();
        int height = image.getHeight();
        for (int k = 0; k < width; k++) {
            for (int l = 0; l < height; l++) {
                int rgb = image.getRGB(k, l);
                int red   = (rgb & 0x00ff0000) >> 16;
                int green = (rgb & 0x0000ff00) >> 8;
                int blue  =  rgb & 0x000000ff;
                mean += getLuminance(new Color(red,green,blue));
            }
        }
        mean = mean/(width*height);
        return mean;
    }
    
    static double convolve(double[] a, double[] b){
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }

    private static double getLuminance(Color c){
        return 0.2126*(c.getRed()/255) + 0.7152*(c.getGreen()/255) + 0.0722*(c.getBlue()/255);
    }
    

}
