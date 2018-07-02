import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
//raiz de n por c
class GirasolDegradado
{
    public static void main(String args[])
    {
        int           i;
        int           x=0, y=0, re=0, pixeles=300, constante=5;
        double        ang=137.5, r=0;
        int           c;
        BufferedImage img = new BufferedImage(pixeles, pixeles, BufferedImage.TYPE_INT_RGB);
        int           col1=(0 << 16) | (0 << 8) | 255;
        c=(int)Math.pow((pixeles / (2 * constante)), 2);
        for (i=1; r < pixeles / 2 - 3; i++)
        {
            x=(int)(r * (Math.cos(ang * Math.PI / 180)));
            y=(int)(r * (Math.sin(ang * Math.PI / 180)));
            //if(x<100&y<100&x>0&y>0)
            col1=(dameColor(255, 30, 0, c, i) << 16) | (dameColor(255, 30, 0, c, i) << 8) | dameColor(0, 0, 0, c, i);
            if (c == 0)
                c=255;
            pinta(x, y, col1, 3, pixeles, img);
            ang=ang + 137.5;
            r  =constante * Math.sqrt(i);
        }
        File f = new File("girasol_ec15.png");
        try {
            ImageIO.write(img, "PNG", f);
        }catch (IOException e) {
            System.out.println("image not saved.");
        }
    }

    static void pinta(int x, int y, int color, int tamano, int pixeles, BufferedImage img)
    {
        for (int i=0; i < tamano; i++)
            for (int j=0; j < tamano; j++)
                img.setRGB(x + (pixeles / 2) + i, y + (pixeles / 2) + j, color);
    }

    public static int dameColor(int colorI, int colorF, int escalaI, int escalaF, int puntoActual)
    {
        return colorI + (colorF - colorI) * (puntoActual - escalaI) / (escalaF - escalaI);
    }
}
