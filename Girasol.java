import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
//raiz de n por c
class Girasol
{
    public static void main(String args[])
    {
        int    pixeles=200, i;
        int    x=0, y=0, r, c=255, re=0;
        double ang=137.5;
        r=pixeles / 2;
        BufferedImage img = new BufferedImage(pixeles, pixeles, BufferedImage.TYPE_INT_RGB);
        int           col1=(0 << 16) | (0 << 8) | 255;
        for (r=0; r < pixeles / 2; r++)

            for (i=0; i < r; i++)
            {
                x=(int)(r * (Math.cos(ang * Math.PI / 180)));
                y=(int)(r * (Math.sin(ang * Math.PI / 180)));
                //if(x<100&y<100&x>0&y>0)
                col1=(re << 16) | (0 << 8) | c;
                re++;
                if (re == 255)
                    c--;
                img.setRGB(x + (pixeles / 2), y + (pixeles / 2), col1);
                ang=ang + 137.5;
            }
        File f = new File("girasol7.png");
        try {
            ImageIO.write(img, "PNG", f);
        }catch (IOException e) {
            System.out.println("image not saved.");
        }
    }
}
