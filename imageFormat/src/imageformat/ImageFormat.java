/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageformat;
	 
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.stream.ImageInputStream;
import com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageReaderSpi;
import com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageReader;
import com.sun.media.imageio.plugins.jpeg2000.J2KImageReadParam;



/**
 *
 * @author Faraz
 */
public class ImageFormat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException
    {// READ IMAGE 
        File file = new File("G:\\jp2_images");
        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f.getName());
            ImageInputStream iis = null;
            BufferedImage image=null;
            try {
            iis = ImageIO.createImageInputStream(f);
         //   com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageReaderSpi j2kImageReaderSpi = new com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageReaderSpi();
         //   com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageReader j2kReader = new com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageReader(j2kImageReaderSpi);
		    
	    J2KImageReaderSpi j2kImageReaderSpi = new J2KImageReaderSpi();
            J2KImageReader j2kReader = new J2KImageReader(j2kImageReaderSpi);
            j2kReader.setInput(iis, true);
            image = j2kReader.read(0, new J2KImageReadParam());
            String name = f.getName();

            name = name.substring(0, name.length() - 1) + "g";
            FileOutputStream output = new FileOutputStream("G:\\converted_image\\" + name);
            ImageIO.write(image, "jpg", output);
            }
            catch (Exception e){
            e.printStackTrace();
            }

        }    
    } 
}
    
    
 
