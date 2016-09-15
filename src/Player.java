import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player {

    private int port;
    private int numBombs;
    private int maxBombs;
    private int power;
    private int speed;
    private boolean exist;
    private boolean alive;
    private int x, y;
    private int xDirection, yDirection;
    private ArrayList<Bomb> bombs;
    private BufferedImage icon;
    private int lastDirection;
    private int walkState;
    private int TOD;
    private boolean winner;

    public Player(int p) {
        port = p;
        numBombs = 0;
        maxBombs = 1;
        power = 1;
        speed = 1;
        if(port == 1){x = 51; y = 51;}
        if(port == 2){x = 627; y = 627;}
        if(port == 3){x = 627; y = 51;}
        if(port == 4){x = 51; y = 627;}
        bombs = new ArrayList<Bomb>();
        icon = null;
        lastDirection = 0;
        walkState = 0;
        TOD = 10000;
        alive = true;
        winner = false;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getSpeed() { return speed; }
    public void incrementX() { x+=3; }
    public void incrementY() { y+=3; }
    public void decrementX() { x-=3; }
    public void decrementY() { y-=3; }

    public void setXDirection(int x){
        xDirection = x;
        if(x == 1) lastDirection = 1;
        if(x == -1) lastDirection = 3;
    }
    public void setYDirection(int y){
        yDirection = y;
        if(y == 1) lastDirection = 0;
        if(y == -1) lastDirection = 2;}
    public int getXDirection(){ return xDirection; }
    public int getYDirection(){ return yDirection; }

    public void addBomb(int r, int c, int time){ bombs.add(new Bomb(r,c,power,time)); numBombs++; }
    public void removeBomb(int k) {bombs.remove(k); numBombs--; }
    public Bomb getBomb(int k){ return bombs.get(k); }
    public Bomb getLastBomb(){ return bombs.get(bombs.size()-1); }

    public int getNumBombs() { return numBombs; }
    public int getMaxBombs() { return maxBombs; }

    public void setExist(boolean b){ exist = b; }
    public boolean doesExist(){ return exist; }

    public boolean isAlive(){ return alive; }
    public int getTOD(){ return TOD; }
    public void die(int time){
        TOD = time;
        alive = false;
        try {
            icon = ImageIO.read(new File("Resources/die1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void die2(){
        try {
            icon = ImageIO.read(new File("Resources/die2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void die3(){
        try {
            icon = ImageIO.read(new File("Resources/die3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void die4(){
        setExist(false);
        try {
            icon = ImageIO.read(new File("Resources/die4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawPlayer(Graphics g)
    {
        if(alive && !winner) {
            if (xDirection == 0 && yDirection == 0) {
                if (lastDirection == 0)
                    try {
                        icon = ImageIO.read(new File("Resources/standDown.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                if (lastDirection == 1)
                    try {
                        icon = ImageIO.read(new File("Resources/standRight.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                if (lastDirection == 2)
                    try {
                        icon = ImageIO.read(new File("Resources/standUp.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                if (lastDirection == 3)
                    try {
                        icon = ImageIO.read(new File("Resources/standLeft.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            if (xDirection == 1) {
                if (walkState % 2 == 0)
                    try {
                        icon = ImageIO.read(new File("Resources/standRight.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (walkState % 4 == 1)
                    try {
                        icon = ImageIO.read(new File("Resources/walkRight1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (walkState % 4 == 3)
                    try {
                        icon = ImageIO.read(new File("Resources/walkRight2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            if (xDirection == -1) {
                if (walkState % 2 == 0)
                    try {
                        icon = ImageIO.read(new File("Resources/standLeft.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (walkState % 4 == 1)
                    try {
                        icon = ImageIO.read(new File("Resources/walkLeft1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (walkState % 4 == 3)
                    try {
                        icon = ImageIO.read(new File("Resources/walkLeft2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            if (yDirection == 1) {
                if (walkState % 2 == 0)
                    try {
                        icon = ImageIO.read(new File("Resources/standDown.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (walkState % 4 == 1)
                    try {
                        icon = ImageIO.read(new File("Resources/walkDown1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (walkState % 4 == 3)
                    try {
                        icon = ImageIO.read(new File("Resources/walkDown2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            if (yDirection == -1) {
                if (walkState % 2 == 0)
                    try {
                        icon = ImageIO.read(new File("Resources/standUp.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (walkState % 4 == 1)
                    try {
                        icon = ImageIO.read(new File("Resources/walkUp1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (walkState % 4 == 3)
                    try {
                        icon = ImageIO.read(new File("Resources/walkUp2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }

        g.drawImage(icon, x - 6, y - 30, 54, 72, null);
    }

    public void incrementWalk(){ walkState++; }

    public void incrementPower(){ power++; }
    public void incrementSpeed(){ if(speed<8) speed++; }
    public void incrementMaxBombs(){ maxBombs++; }

    public boolean isWinner(){ return winner; }
    public void win()
    {
        winner = true;
    }

    public void win1()
    {
        if (winner) {
            try {
                icon = ImageIO.read(new File("Resources/win1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void win2()
    {
        if (winner) {
            try {
                icon = ImageIO.read(new File("Resources/win2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

