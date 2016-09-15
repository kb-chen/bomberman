import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI {

    //background 1 - Play Game 1
    public static void drawStartScreen1(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/PlayGameStartScreen1.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 2 - Play Game 2
    public static void drawStartScreen2(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/PlayGameStartScreen2.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 3 - How to Play 1
    public static void drawStartScreen3(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/HowToPlayStartScreen1.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 4 - How to Play 2
    public static void drawStartScreen4(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/HowToPlayStartScreen2.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 5 - Controls 1
    public static void drawStartScreen5(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/ControlsStartScreen1.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 6 - Controls 2
    public static void drawStartScreen6(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/ControlsStartScreen2.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 7 - 2 Player 1
    public static void drawPlayScreen1(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/PlayGame2PlayerScreen1.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 8 - 2 player 2
    public static void drawPlayScreen2(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/PlayGame2PlayerScreen2.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 9 - 3 Player 1
    public static void drawPlayScreen3(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/PlayGame3PlayerScreen1.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 10 - 3 Player 2
    public static void drawPlayScreen4(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/PlayGame3PlayerScreen2.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 11 - 4 Player 1
    public static void drawPlayScreen5(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/PlayGame4PlayerScreen1.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 12 - 4 Player 2
    public static void drawPlayScreen6(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/PlayGame4PlayerScreen2.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 13
    public static void drawHowToPlay(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/HowToPlay.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }

    //background 14
    public static void drawControls(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Resources/Controls.png"));
        } catch (IOException ex) {ex.printStackTrace();}

        g.drawImage(img,0,0,720,720,null);
    }
}
