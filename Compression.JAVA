import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import javax.imageio.*;
import javax.imageio.stream.*;

public class Compression {

  public static void main(String[] args) throws IOException {

	  BufferedImage image = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
      Graphics g = image.getGraphics();

      g.drawString("Hey", 20,20);
      g.drawString("There", 25,40);
      g.drawString("How", 30,60);
      g.drawString("Are", 35,80);
      g.drawString("You", 40,100);
      
     

    File compressedImageFile = new File("hmm.jpg");
    OutputStream os = new FileOutputStream(compressedImageFile);
    Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
    ImageWriter writer = (ImageWriter) writers.next();
    ImageOutputStream ios = ImageIO.createImageOutputStream(os);
    writer.setOutput(ios)
    ImageWriteParam param = writer.getDefaultWriteParam();
    param.setCompressionMode(ImageWriteParam.MODE_DEFAULT);
    param.setCompressionQuality(1f);  // Change the quality value
    writer.write(null, new IIOImage(image, null, null), param);

    os.close();
    ios.close();
    writer.dispose();
  }
}
