
package image.operations;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ColorConversion {
    
    public static BufferedImage convertImageToBW(BufferedImage image){
        BufferedImage imageBW = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        Graphics g = imageBW.getGraphics();  
        g.drawImage(image, 0, 0, null);  
        g.dispose();
        return imageBW;
    }
    
}
