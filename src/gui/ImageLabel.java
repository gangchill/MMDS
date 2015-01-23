
package gui;

import image.operations.ImageCom;

import javax.swing.Icon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel{
    
    
	private static final long serialVersionUID = 1L;
	public ImageCom imageFile;

    public ImageLabel(ImageCom imageFile, Icon image) {
        super(image);
        this.imageFile = imageFile;
    }
   
}
