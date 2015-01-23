
package image.operations;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageImporter {
    
    public ArrayList<ImageCom> images = new ArrayList<>();
    
    public void importImage(File folder) {
        System.out.println("Importing folder "+folder.getAbsolutePath());
        if(folder.isDirectory()){
            File[] listFiles = folder.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            File file = listFiles[i];
            if(file.isDirectory()){
                importImage(file);
            }
            if(file.isFile() && (file.getAbsolutePath().toLowerCase().endsWith(".png") || file.getAbsolutePath().toLowerCase().endsWith(".bmp"))){
                System.out.println("Importing images "+file.getAbsolutePath());
                try {
                    BufferedImage image = ImageIO.read(file);
                    images.add(new ImageCom(image));
                } catch (IOException ex) {
                    Logger.getLogger(ImageImporter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        } else{
            System.out.println("No Directory selected.");
        }
        
    }

    
}
