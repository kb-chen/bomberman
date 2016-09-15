import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Piece {

    private String ID;
    private boolean intangible;
    private BufferedImage icon;

    public Piece(String id) {
        icon = null;
        setID(id);
    }

    public void setID(String id) {
        ID = id;
        setCharacteristics();
    }

    public String getID() {
        return ID;
    }

    public void setCharacteristics() {
        if (ID.equals("blank")) {
            intangible = true;
            try{
                icon = ImageIO.read(new File("Resources/blank.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if (ID.equals("softBlock")) {
            intangible = false;
            try{
                icon = ImageIO.read(new File("Resources/softBlock.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if (ID.equals("hardBlock")) {
            intangible = false;
            try{
                icon = ImageIO.read(new File("Resources/hardBlock.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if (ID.equals("bomb")) {
            intangible = true;
            try{
                icon = ImageIO.read(new File("Resources/bomb.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if (ID.equals("bomb2")) {
            intangible = true;
            try{
                icon = ImageIO.read(new File("Resources/bomb2.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if (ID.equals("bomb3")) {
            intangible = true;
            try{
                icon = ImageIO.read(new File("Resources/bomb3.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if (ID.contains("fire")) {
            intangible = true;
        }

        if(ID.equals("fireCenter")){
            try{
                icon = ImageIO.read(new File("Resources/fireCenter.png"));
            }catch(IOException e){e.printStackTrace();}
        }
        if(ID.equals("fireCenter2")){
            try{
                icon = ImageIO.read(new File("Resources/fireCenter2.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if(ID.equals("fireVertical")){
            try{
                icon = ImageIO.read(new File("Resources/fireVertical.png"));
            }catch(IOException e){e.printStackTrace();}
        }
        if(ID.equals("fireVertical2")){
            try{
                icon = ImageIO.read(new File("Resources/fireVertical2.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if(ID.equals("fireHorizontal")){
            try{
                icon = ImageIO.read(new File("Resources/fireHorizontal.png"));
            }catch(IOException e){e.printStackTrace();}
        }
        if(ID.equals("fireHorizontal2")){
            try{
                icon = ImageIO.read(new File("Resources/fireHorizontal2.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if(ID.equals("fireUEnd")){
            try{
                icon = ImageIO.read(new File("Resources/fireUEnd.png"));
            }catch(IOException e){e.printStackTrace();}
        }
        if(ID.equals("fireUEnd2")){
            try{
                icon = ImageIO.read(new File("Resources/fireUEnd2.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if(ID.equals("fireDEnd")){
            try{
                icon = ImageIO.read(new File("Resources/fireDEnd.png"));
            }catch(IOException e){e.printStackTrace();}
        }
        if(ID.equals("fireDEnd2")){
            try{
                icon = ImageIO.read(new File("Resources/fireDEnd2.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if(ID.equals("fireLEnd")){
            try{
                icon = ImageIO.read(new File("Resources/fireLEnd.png"));
            }catch(IOException e){e.printStackTrace();}
        }
        if(ID.equals("fireLEnd2")){
            try{
                icon = ImageIO.read(new File("Resources/fireLEnd2.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if(ID.equals("fireREnd")){
            try{
                icon = ImageIO.read(new File("Resources/fireREnd.png"));
            }catch(IOException e){e.printStackTrace();}
        }
        if(ID.equals("fireREnd2")){
            try{
                icon = ImageIO.read(new File("Resources/fireREnd2.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if (ID.contains("Up")){
            intangible = true;
        }

        if(ID.equals("powerUp")){
            try{
                icon = ImageIO.read(new File("Resources/powerUp.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if(ID.equals("speedUp")){
            try{
                icon = ImageIO.read(new File("Resources/speedUp.png"));
            }catch(IOException e){e.printStackTrace();}
        }

        if(ID.equals("bombsUp")){
            try{
                icon = ImageIO.read(new File("Resources/bombsUp.png"));
            }catch(IOException e){e.printStackTrace();}
        }
    }

    public void drawPiece(Graphics g, int x, int y) {
        g.drawImage(icon, x, y, 48, 48, null);
    }

    public boolean isIntangible() { return intangible; }
    public void setTangible() { intangible = false; }
}
