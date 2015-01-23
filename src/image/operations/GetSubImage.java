package image.operations;

import java.awt.image.BufferedImage;

public class GetSubImage {
	

    public static BufferedImage[] calculateSubImage(BufferedImage image, int cells){
        BufferedImage[] images = new BufferedImage[cells * cells];
        
        int width = image.getWidth();
        int height = image.getHeight();
        
        int pixel_w = (int) Math.ceil(width/cells);
        int pixel_h = (int) Math.ceil(height/cells);
        
        int counter = 0;     

        for (int j = 0; j < cells; j++) {
            for (int i = 0; i < cells; i++) {
                int temp_w = pixel_w;
                int temp_h = pixel_h;
                if (i == cells - 1) {
                    temp_w = width - i * pixel_w;
                }
                if (j == cells - 1) {
                    temp_h = height - j * pixel_h;
                }

                images[counter] = image.getSubimage(i * pixel_w, j * pixel_h, temp_w, temp_h);

                counter++;
            }
        }
        
        return images;
    }
    
    
    public static BufferedImage[] extractBlocks(BufferedImage image, int blockSize){
        
        int width = image.getWidth();
        int height = image.getHeight();
        int w = width / blockSize;
        int h = height / blockSize;

        BufferedImage[] images = new BufferedImage[w*h];
        int counter = 0;     

        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                images[counter++] = image.getSubimage(i * blockSize, j * blockSize, blockSize, blockSize);
            }
        }
        
        return images;
    }

}
