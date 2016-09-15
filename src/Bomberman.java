import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bomberman {

    public static void main(String[] args) {
        JFrame j = new JFrame();
        MyPanel m = new MyPanel();
        j.setSize(m.getSize());
        j.add(m);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Audio.playMenu();
    }
}

class MyPanel extends JPanel implements MouseListener, KeyListener, ActionListener{

    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;

    private Timer timer;
    private int count, time;
    Arena arena;
    private int timeVictory;

    int background;

    Audio audio;

    public MyPanel()
    {
        p1 = new Player(1);
        p2 = new Player(2);
        p3 = new Player(3);
        p4 = new Player(4);

        timer = new Timer(5,this);
        timer.start();
        count = 0;
        time = 0;
        arena = new Arena(15);

        setSize(735, 750);
        setVisible(true);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);

        background = 1;

        audio = new Audio(0);
        timeVictory = 10000;
    }

    public void reset()
    {
        timer.stop();

        p1 = new Player(1);
        p2 = new Player(2);
        p3 = new Player(3);
        p4 = new Player(4);

        timer = new Timer(5,this);
        timer.start();
        count = 0;
        time = 0;
        arena = new Arena(15);

        background = 1;

        audio = new Audio(0);
        timeVictory = 10000;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        if(background == 1) {GUI.drawStartScreen1(g);}
        if(background == 2) {GUI.drawStartScreen2(g);}
        if(background == 3) {GUI.drawStartScreen3(g);}
        if(background == 4) {GUI.drawStartScreen4(g);}
        if(background == 5) {GUI.drawStartScreen5(g);}
        if(background == 6) {GUI.drawStartScreen6(g);}
        if(background == 7) {GUI.drawPlayScreen1(g);}
        if(background == 8) {GUI.drawPlayScreen2(g);}
        if(background == 9) {GUI.drawPlayScreen3(g);}
        if(background == 10) {GUI.drawPlayScreen4(g);}
        if(background == 11) {GUI.drawPlayScreen5(g);}
        if(background == 12) {GUI.drawPlayScreen6(g);}
        if(background == 13) {GUI.drawHowToPlay(g);}
        if(background == 14) {GUI.drawControls(g);}

        if(background == 15)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 800, 800);

            arena.drawArena(g);

            g.setColor(Color.BLUE);
            if (p1.doesExist()) p1.drawPlayer(g);
            if (p2.doesExist()) p2.drawPlayer(g);
            if (p3.doesExist()) p3.drawPlayer(g);
            if (p4.doesExist()) p4.drawPlayer(g);

            if(p1.isWinner() || p2.isWinner() || p3.isWinner() || p4.isWinner())
            {
                g.setColor(Color.WHITE);
                g.fillRect(90, 310, 540, 95);
                g.setColor(Color.BLACK);
                g.fillRect(100, 320, 520, 75);
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("MSGothic", Font.BOLD, 64));
            if(p1.isWinner()) g.drawString("Player 1 Wins!", 150, 375);
            if(p2.isWinner()) g.drawString("Player 2 Wins!", 150, 375);
            if(p3.isWinner()) g.drawString("Player 3 Wins!", 150, 375);
            if(p4.isWinner()) g.drawString("Player 4 Wins!", 150, 375);
        }
    }

    @Override
    public void mousePressed(MouseEvent e){}
    @Override
    public void mouseClicked(MouseEvent e){}
    @Override
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        char ch = e.getKeyChar();

        if(background == 15)
        {
            if (ch == 'q' && p1.getNumBombs() < p1.getMaxBombs() && p1.doesExist() && p1.isAlive()) {
                int r = (p1.getY() + 21) / 48;
                int c = (p1.getX() + 21) / 48;
                p1.addBomb(r, c, time);
                arena.dropBomb(p1.getLastBomb());
                Audio.playBombDrop();
            }

            if (key == KeyEvent.VK_NUMPAD0 && p2.getNumBombs() < p2.getMaxBombs() && p2.doesExist() && p2.isAlive()) {
                int r = (p2.getY() + 21) / 48;
                int c = (p2.getX() + 21) / 48;
                p2.addBomb(r, c, time);
                arena.dropBomb(p2.getLastBomb());
                Audio.playBombDrop();
            }

            if (ch == 'u' && p3.getNumBombs() < p3.getMaxBombs() && p3.doesExist() && p3.isAlive()) {
                int r = (p3.getY() + 21) / 48;
                int c = (p3.getX() + 21) / 48;
                p3.addBomb(r, c, time);
                arena.dropBomb(p3.getLastBomb());
                Audio.playBombDrop();
            }

            if (key == KeyEvent.VK_NUMPAD7 && p4.getNumBombs() < p4.getMaxBombs() && p4.doesExist() && p4.isAlive()) {
                int r = (p4.getY() + 21) / 48;
                int c = (p4.getX() + 21) / 48;
                p4.addBomb(r, c, time);
                arena.dropBomb(p4.getLastBomb());
                Audio.playBombDrop();
            }

            if (ch == 'w' || ch == 's') p1.setYDirection(0);
            if (ch == 'a' || ch == 'd') p1.setXDirection(0);

            if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) p2.setYDirection(0);
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) p2.setXDirection(0);

            if (ch == 'i' || ch == 'k') p3.setYDirection(0);
            if (ch == 'j' || ch == 'l') p3.setXDirection(0);

            if (key == KeyEvent.VK_NUMPAD8 || key == KeyEvent.VK_NUMPAD5) p4.setYDirection(0);
            if (key == KeyEvent.VK_NUMPAD4 || key == KeyEvent.VK_NUMPAD6) p4.setXDirection(0);
        }
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        char ch = e.getKeyChar();

        if(background == 1 || background == 2)
        {
            if(key == KeyEvent.VK_UP) {background = 5; Audio.playMenuMove();}
            if(key == KeyEvent.VK_DOWN) {background = 3; Audio.playMenuMove();}
            if(key == KeyEvent.VK_SPACE) {background = 7; Audio.playMenuSelect();}
            return;
        }

        if(background == 3 || background == 4)
        {
            if(key == KeyEvent.VK_UP) {background = 1; Audio.playMenuMove();}
            if(key == KeyEvent.VK_DOWN) {background = 5; Audio.playMenuMove();}
            if(key == KeyEvent.VK_SPACE) {background = 13; Audio.playMenuSelect();}
            return;
        }

        if(background == 5 || background == 6)
        {
            if(key == KeyEvent.VK_UP) {background = 3; Audio.playMenuMove();}
            if(key == KeyEvent.VK_DOWN) {background = 1; Audio.playMenuMove();}
            if(key == KeyEvent.VK_SPACE) {background = 14; Audio.playMenuSelect();}
            return;
        }

        if(background == 7 || background == 8)
        {
            if(key == KeyEvent.VK_UP) {background = 11; Audio.playMenuMove();}
            if(key == KeyEvent.VK_DOWN) {background = 9;Audio.playMenuMove();}
            if(key == KeyEvent.VK_SPACE)
            {
                p1.setExist(true);
                p2.setExist(true);
                background = 15;
                //audio.stopMenu();
                Audio.playMenuSelect();
            }
            if(key == KeyEvent.VK_BACK_SPACE) {background = 1; Audio.playMenuMove();}
            return;
        }

        if(background == 9 || background == 10)
        {
            if(key == KeyEvent.VK_UP) {background = 7; Audio.playMenuMove();}
            if(key == KeyEvent.VK_DOWN) {background = 11; Audio.playMenuMove();}
            if(key == KeyEvent.VK_SPACE)
            {
                p1.setExist(true);
                p2.setExist(true);
                p3.setExist(true);
                background = 15;
                //audio.stopMenu();
                Audio.playMenuSelect();
            }
            if(key == KeyEvent.VK_BACK_SPACE) {background = 1; Audio.playMenuMove();}
            return;
        }

        if(background == 11 || background == 12)
        {
            if(key == KeyEvent.VK_UP) {
                background = 9;
                Audio.playMenuMove();
            }
            if(key == KeyEvent.VK_DOWN) {
                background = 7;
                Audio.playMenuMove();
            }
            if(key == KeyEvent.VK_SPACE)
            {
                p1.setExist(true);
                p2.setExist(true);
                p3.setExist(true);
                p4.setExist(true);
                background = 15;
                //audio.stopMenu();
                Audio.playMenuSelect();
            }
            if(key == KeyEvent.VK_BACK_SPACE)
                background = 1; Audio.playMenuMove();
        }

        if(background == 13)
        {
            if(key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE)
                background = 3; Audio.playMenuMove();
            return;
        }

        if(background == 14)
        {
            if(key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE)
                background = 5; Audio.playMenuMove();
            return;
        }

        if(background == 15)
        {
            if (ch == 'w')
                p1.setYDirection(-1);
            if (ch == 's')
                p1.setYDirection(1);
            if (ch == 'a')
                p1.setXDirection(-1);
            if (ch == 'd')
                p1.setXDirection(1);

            if (key == KeyEvent.VK_UP)
                p2.setYDirection(-1);
            if (key == KeyEvent.VK_DOWN)
                p2.setYDirection(1);
            if (key == KeyEvent.VK_LEFT)
                p2.setXDirection(-1);
            if (key == KeyEvent.VK_RIGHT)
                p2.setXDirection(1);

            if (ch == 'i')
                p3.setYDirection(-1);
            if (ch == 'k')
                p3.setYDirection(1);
            if (ch == 'j')
                p3.setXDirection(-1);
            if (ch == 'l')
                p3.setXDirection(1);

            if (key == KeyEvent.VK_NUMPAD8)
                p4.setYDirection(-1);
            if (key == KeyEvent.VK_NUMPAD5)
                p4.setYDirection(1);
            if (key == KeyEvent.VK_NUMPAD4)
                p4.setXDirection(-1);
            if (key == KeyEvent.VK_NUMPAD6)
                p4.setXDirection(1);

            if(key == KeyEvent.VK_BACK_SPACE)
                reset();
        }
    }
    @Override
    public void keyTyped(KeyEvent e){}

    public void actionPerformed(ActionEvent e) {
        count++;
        if((count%20)==0) {
            time++;

            if (background == 1 && (time / 5) % 2 == 0) background = 2;
            if (background == 2 && (time / 5) % 2 == 1) background = 1;
            if (background == 3 && (time / 5) % 2 == 0) background = 4;
            if (background == 4 && (time / 5) % 2 == 1) background = 3;
            if (background == 5 && (time / 5) % 2 == 0) background = 6;
            if (background == 6 && (time / 5) % 2 == 1) background = 5;
            if (background == 7 && (time / 5) % 2 == 0) background = 8;
            if (background == 8 && (time / 5) % 2 == 1) background = 7;
            if (background == 9 && (time / 5) % 2 == 0) background = 10;
            if (background == 10 && (time / 5) % 2 == 1) background = 9;
            if (background == 11 && (time / 5) % 2 == 0) background = 12;
            if (background == 12 && (time / 5) % 2 == 1) background = 11;
        }

        if (background == 15) {
            if((count%20)==0) {
                for (int k = 0; k < p1.getNumBombs(); k++) {
                    if (time == p1.getBomb(k).getStart() + 5)
                        arena.bomb2(p1.getBomb(k));
                    if (time == p1.getBomb(k).getStart() + 10) {
                        arena.bomb3(p1.getBomb(k));
                        arena.setTangible(p1.getBomb(k));
                    }
                    if (time == p1.getBomb(k).getStart() + 15)
                        arena.bomb2(p1.getBomb(k));
                    if (time == p1.getBomb(k).getStart() + 20)
                        arena.dropBomb(p1.getBomb(k));
                    if (time == p1.getBomb(k).getStart() + 25)
                        arena.bomb2(p1.getBomb(k));
                    if (time == p1.getBomb(k).getStart() + 30)
                        arena.bomb3(p1.getBomb(k));
                    if (time == p1.getBomb(k).getStart() + 35)
                        arena.bomb2(p1.getBomb(k));
                    if (time == p1.getBomb(k).getStartExplosion()) {
                        for (int i = 0; i < p1.getNumBombs(); i++)
                            if (p1.getBomb(i).inRange(p1.getBomb(k)))
                                p1.getBomb(i).setStart(p1.getBomb(k).getStart());

                        for (int i = 0; i < p2.getNumBombs(); i++)
                            if (p2.getBomb(i).inRange(p1.getBomb(k)))
                                p2.getBomb(i).setStart(p1.getBomb(k).getStart());

                        for (int i = 0; i < p3.getNumBombs(); i++)
                            if (p3.getBomb(i).inRange(p1.getBomb(k)))
                                p3.getBomb(i).setStart(p1.getBomb(k).getStart());

                        for (int i = 0; i < p4.getNumBombs(); i++)
                            if (p4.getBomb(i).inRange(p1.getBomb(k)))
                                p4.getBomb(i).setStart(p1.getBomb(k).getStart());
                    }
                    if (time == p1.getBomb(k).getStartExplosion())
                    {
                        arena.explode(p1.getBomb(k));
                        Audio.playBombExplode();
                    }
                    if (time == p1.getBomb(k).getStartExplosion() + 1)
                        arena.expand(p1.getBomb(k));
                    if (time == p1.getBomb(k).getStartExplosion() + 4)
                        arena.unexpand(p1.getBomb(k));
                    if (time == p1.getBomb(k).getStartExplosion() + 5) {
                        arena.clearFire(p1.getBomb(k));
                        p1.removeBomb(k);
                        k--;
                    }
                }

                for (int k = 0; k < p2.getNumBombs(); k++) {
                    if (time == p2.getBomb(k).getStart() + 5)
                        arena.bomb2(p2.getBomb(k));
                    if (time == p2.getBomb(k).getStart() + 10) {
                        arena.bomb3(p2.getBomb(k));
                        arena.setTangible(p2.getBomb(k));
                    }
                    if (time == p2.getBomb(k).getStart() + 15)
                        arena.bomb2(p2.getBomb(k));
                    if (time == p2.getBomb(k).getStart() + 20)
                        arena.dropBomb(p2.getBomb(k));
                    if (time == p2.getBomb(k).getStart() + 25)
                        arena.bomb2(p2.getBomb(k));
                    if (time == p2.getBomb(k).getStart() + 30)
                        arena.bomb3(p2.getBomb(k));
                    if (time == p2.getBomb(k).getStart() + 35)
                        arena.bomb2(p2.getBomb(k));
                    if (time == p2.getBomb(k).getStartExplosion()) {
                        for (int i = 0; i < p1.getNumBombs(); i++)
                            if (p1.getBomb(i).inRange(p2.getBomb(k)))
                                p1.getBomb(i).setStart(p2.getBomb(k).getStart());

                        for (int i = 0; i < p2.getNumBombs(); i++)
                            if (p2.getBomb(i).inRange(p2.getBomb(k)))
                                p2.getBomb(i).setStart(p2.getBomb(k).getStart());

                        for (int i = 0; i < p3.getNumBombs(); i++)
                            if (p3.getBomb(i).inRange(p2.getBomb(k)))
                                p3.getBomb(i).setStart(p2.getBomb(k).getStart());

                        for (int i = 0; i < p4.getNumBombs(); i++)
                            if (p4.getBomb(i).inRange(p2.getBomb(k)))
                                p4.getBomb(i).setStart(p2.getBomb(k).getStart());
                    }
                    if (time == p2.getBomb(k).getStartExplosion())
                    {
                        arena.explode(p2.getBomb(k));
                        Audio.playBombExplode();
                    }
                    if (time == p2.getBomb(k).getStartExplosion() + 1)
                        arena.expand(p2.getBomb(k));
                    if (time == p2.getBomb(k).getStartExplosion() + 4)
                        arena.unexpand(p2.getBomb(k));
                    if (time == p2.getBomb(k).getStartExplosion() + 5) {
                        arena.clearFire(p2.getBomb(k));
                        p2.removeBomb(k);
                        k--;
                    }
                }

                for (int k = 0; k < p3.getNumBombs(); k++) {
                    if (time == p3.getBomb(k).getStart() + 5)
                        arena.bomb2(p3.getBomb(k));
                    if (time == p3.getBomb(k).getStart() + 10) {
                        arena.bomb3(p3.getBomb(k));
                        arena.setTangible(p3.getBomb(k));
                    }
                    if (time == p3.getBomb(k).getStart() + 15)
                        arena.bomb2(p3.getBomb(k));
                    if (time == p3.getBomb(k).getStart() + 20)
                        arena.dropBomb(p3.getBomb(k));
                    if (time == p3.getBomb(k).getStart() + 25)
                        arena.bomb2(p3.getBomb(k));
                    if (time == p3.getBomb(k).getStart() + 30)
                        arena.bomb3(p3.getBomb(k));
                    if (time == p3.getBomb(k).getStart() + 35)
                        arena.bomb2(p3.getBomb(k));
                    if (time == p3.getBomb(k).getStartExplosion()) {
                        for (int i = 0; i < p1.getNumBombs(); i++)
                            if (p1.getBomb(i).inRange(p3.getBomb(k)))
                                p1.getBomb(i).setStart(p3.getBomb(k).getStart());

                        for (int i = 0; i < p2.getNumBombs(); i++)
                            if (p2.getBomb(i).inRange(p3.getBomb(k)))
                                p2.getBomb(i).setStart(p3.getBomb(k).getStart());

                        for (int i = 0; i < p3.getNumBombs(); i++)
                            if (p3.getBomb(i).inRange(p3.getBomb(k)))
                                p3.getBomb(i).setStart(p3.getBomb(k).getStart());

                        for (int i = 0; i < p4.getNumBombs(); i++)
                            if (p4.getBomb(i).inRange(p3.getBomb(k)))
                                p4.getBomb(i).setStart(p3.getBomb(k).getStart());
                    }
                    if (time == p3.getBomb(k).getStartExplosion())
                    {
                        arena.explode(p3.getBomb(k));
                        Audio.playBombExplode();
                    }
                    if (time == p3.getBomb(k).getStartExplosion() + 1)
                        arena.expand(p3.getBomb(k));
                    if (time == p3.getBomb(k).getStartExplosion() + 4)
                        arena.unexpand(p3.getBomb(k));
                    if (time == p3.getBomb(k).getStartExplosion() + 5) {
                        arena.clearFire(p3.getBomb(k));
                        p3.removeBomb(k);
                        k--;
                    }
                }

                for (int k = 0; k < p4.getNumBombs(); k++) {
                    if (time == p4.getBomb(k).getStart() + 5)
                        arena.bomb2(p4.getBomb(k));
                    if (time == p4.getBomb(k).getStart() + 10) {
                        arena.bomb3(p4.getBomb(k));
                        arena.setTangible(p4.getBomb(k));
                    }
                    if (time == p4.getBomb(k).getStart() + 15)
                        arena.bomb2(p4.getBomb(k));
                    if (time == p4.getBomb(k).getStart() + 20)
                        arena.dropBomb(p4.getBomb(k));
                    if (time == p4.getBomb(k).getStart() + 25)
                        arena.bomb2(p4.getBomb(k));
                    if (time == p4.getBomb(k).getStart() + 30)
                        arena.bomb3(p4.getBomb(k));
                    if (time == p4.getBomb(k).getStart() + 35)
                        arena.bomb2(p4.getBomb(k));
                    if (time == p4.getBomb(k).getStartExplosion()) {
                        for (int i = 0; i < p1.getNumBombs(); i++)
                            if (p1.getBomb(i).inRange(p4.getBomb(k)))
                                p1.getBomb(i).setStart(p4.getBomb(k).getStart());

                        for (int i = 0; i < p2.getNumBombs(); i++)
                            if (p2.getBomb(i).inRange(p4.getBomb(k)))
                                p2.getBomb(i).setStart(p4.getBomb(k).getStart());

                        for (int i = 0; i < p3.getNumBombs(); i++)
                            if (p3.getBomb(i).inRange(p4.getBomb(k)))
                                p3.getBomb(i).setStart(p4.getBomb(k).getStart());

                        for (int i = 0; i < p4.getNumBombs(); i++)
                            if (p4.getBomb(i).inRange(p4.getBomb(k)))
                                p4.getBomb(i).setStart(p4.getBomb(k).getStart());
                    }
                    if (time == p4.getBomb(k).getStartExplosion())
                    {
                        arena.explode(p4.getBomb(k));
                        Audio.playBombExplode();
                    }
                    if (time == p4.getBomb(k).getStartExplosion() + 1)
                        arena.expand(p4.getBomb(k));
                    if (time == p4.getBomb(k).getStartExplosion() + 4)
                        arena.unexpand(p4.getBomb(k));
                    if (time == p4.getBomb(k).getStartExplosion() + 5) {
                        arena.clearFire(p4.getBomb(k));
                        p4.removeBomb(k);
                        k--;
                    }
                }

                if (p1.doesExist() && !p2.doesExist() && !p3.doesExist() && !p4.doesExist())
                {
                    p1.win();
                    if(time < timeVictory) timeVictory = time;
                }
                if ((time/3) % 2 == 1) p1.win2();
                if ((time/3) % 2 == 0) p1.win1();

                if (!p1.doesExist() && p2.doesExist() && !p3.doesExist() && !p4.doesExist())
                {
                    p2.win();
                    if(time < timeVictory) timeVictory = time;
                }
                if ((time/3) % 2 == 1) p2.win2();
                if ((time/3) % 2 == 0) p2.win1();

                if (!p1.doesExist() && !p2.doesExist() && p3.doesExist() && !p4.doesExist())
                {
                    p3.win();
                    if(time < timeVictory) timeVictory = time;
                }
                if ((time/3) % 2 == 1) p3.win2();
                if ((time/3) % 2 == 0) p3.win1();

                if (!p1.doesExist() && !p2.doesExist() && !p3.doesExist() && p4.doesExist())
                {
                    p4.win();
                    if(time < timeVictory) timeVictory = time;
                }
                if ((time/3) % 2 == 1) p4.win2();
                if ((time/3) % 2 == 0) p4.win1();

                if(time == timeVictory + 1) Audio.playVictory();
            }

            if (arena.getPiece((p1.getY() + 21) / 48, (p1.getX() + 21) / 48).getID().contains("fire"))
                p1.die(time);
            if (arena.getPiece((p2.getY() + 21) / 48, (p2.getX() + 21) / 48).getID().contains("fire"))
                p2.die(time);
            if (arena.getPiece((p3.getY() + 21) / 48, (p3.getX() + 21) / 48).getID().contains("fire"))
                p3.die(time);
            if (arena.getPiece((p4.getY() + 21) / 48, (p4.getX() + 21) / 48).getID().contains("fire"))
                p4.die(time);

            if (time == p1.getTOD() + 1)
                p1.die2();
            if (time == p1.getTOD() + 2)
                p1.die3();
            if (time == p1.getTOD() + 3)
                p1.die4();

            if (time == p2.getTOD() + 1)
                p2.die2();
            if (time == p2.getTOD() + 2)
                p2.die3();
            if (time == p2.getTOD() + 3)
                p2.die4();

            if (time == p3.getTOD() + 1)
                p3.die2();
            if (time == p3.getTOD() + 2)
                p3.die3();
            if (time == p3.getTOD() + 3)
                p3.die4();

            if (time == p4.getTOD() + 1)
                p4.die2();
            if (time == p4.getTOD() + 2)
                p4.die3();
            if (time == p4.getTOD() + 3)
                p4.die4();

            if(count%(9 - p1.getSpeed()) == 0) {
                if(count%((9 - p1.getSpeed()/2)*2) == 0) p1.incrementWalk();
                if (p1.getXDirection() == 1 && p1.getY() / 48 == (p1.getY() + 41) / 48 && arena.getPiece(p1.getY() / 48, (p1.getX() + 44) / 48).isIntangible())
                    p1.incrementX();
                if (p1.getXDirection() == -1 && p1.getY() / 48 == (p1.getY() + 41) / 48 && arena.getPiece(p1.getY() / 48, (p1.getX() - 2) / 48).isIntangible())
                    p1.decrementX();
                if (p1.getYDirection() == 1 && p1.getX() / 48 == (p1.getX() + 41) / 48 && arena.getPiece((p1.getY() + 44) / 48, p1.getX() / 48).isIntangible())
                    p1.incrementY();
                if (p1.getYDirection() == -1 && p1.getX() / 48 == (p1.getX() + 41) / 48 && arena.getPiece((p1.getY() - 2) / 48, p1.getX() / 48).isIntangible())
                    p1.decrementY();
            }
            if(count%(9 - p2.getSpeed()) == 0) {
                if(count%((9 - p2.getSpeed()/2)*2) == 0) p2.incrementWalk();
                if (p2.getXDirection() == 1 && p2.getY() / 48 == (p2.getY() + 41) / 48 && arena.getPiece(p2.getY() / 48, (p2.getX() + 44) / 48).isIntangible())
                    p2.incrementX();
                if (p2.getXDirection() == -1 && p2.getY() / 48 == (p2.getY() + 41) / 48 && arena.getPiece(p2.getY() / 48, (p2.getX() - 2) / 48).isIntangible())
                    p2.decrementX();
                if (p2.getYDirection() == 1 && p2.getX() / 48 == (p2.getX() + 41) / 48 && arena.getPiece((p2.getY() + 44) / 48, p2.getX() / 48).isIntangible())
                    p2.incrementY();
                if (p2.getYDirection() == -1 && p2.getX() / 48 == (p2.getX() + 41) / 48 && arena.getPiece((p2.getY() - 2) / 48, p2.getX() / 48).isIntangible())
                    p2.decrementY();
            }

            if(count%(9 - p3.getSpeed()) == 0) {
                if(count%((9 - p3.getSpeed()/2)*2) == 0) p3.incrementWalk();
                if (p3.getXDirection() == 1 && p3.getY() / 48 == (p3.getY() + 41) / 48 && arena.getPiece(p3.getY() / 48, (p3.getX() + 44) / 48).isIntangible())
                    p3.incrementX();
                if (p3.getXDirection() == -1 && p3.getY() / 48 == (p3.getY() + 41) / 48 && arena.getPiece(p3.getY() / 48, (p3.getX() - 2) / 48).isIntangible())
                    p3.decrementX();
                if (p3.getYDirection() == 1 && p3.getX() / 48 == (p3.getX() + 41) / 48 && arena.getPiece((p3.getY() + 44) / 48, p3.getX() / 48).isIntangible())
                    p3.incrementY();
                if (p3.getYDirection() == -1 && p3.getX() / 48 == (p3.getX() + 41) / 48 && arena.getPiece((p3.getY() - 2) / 48, p3.getX() / 48).isIntangible())
                    p3.decrementY();
            }

            if(count%(9 - p4.getSpeed()) == 0) {
                if(count%((9 - p4.getSpeed()/2)*2) == 0) p4.incrementWalk();
                if (p4.getXDirection() == 1 && p4.getY() / 48 == (p4.getY() + 41) / 48 && arena.getPiece(p4.getY() / 48, (p4.getX() + 44) / 48).isIntangible())
                    p4.incrementX();
                if (p4.getXDirection() == -1 && p4.getY() / 48 == (p4.getY() + 41) / 48 && arena.getPiece(p4.getY() / 48, (p4.getX() - 2) / 48).isIntangible())
                    p4.decrementX();
                if (p4.getYDirection() == 1 && p4.getX() / 48 == (p4.getX() + 41) / 48 && arena.getPiece((p4.getY() + 44) / 48, p4.getX() / 48).isIntangible())
                    p4.incrementY();
                if (p4.getYDirection() == -1 && p4.getX() / 48 == (p4.getX() + 41) / 48 && arena.getPiece((p4.getY() - 2) / 48, p4.getX() / 48).isIntangible())
                    p4.decrementY();
            }

            if (arena.getPiece((p1.getY() + 21) / 48, (p1.getX() + 21) / 48).getID().equals("speedUp")) {
                arena.getPiece((p1.getY() + 21) / 48, (p1.getX() + 21) / 48).setID("blank");
                p1.incrementSpeed();
            }
            if (arena.getPiece((p1.getY() + 21) / 48, (p1.getX() + 21) / 48).getID().equals("powerUp")) {
                arena.getPiece((p1.getY() + 21) / 48, (p1.getX() + 21) / 48).setID("blank");
                p1.incrementPower();
            }
            if (arena.getPiece((p1.getY() + 21) / 48, (p1.getX() + 21) / 48).getID().equals("bombsUp")) {
                arena.getPiece((p1.getY() + 21) / 48, (p1.getX() + 21) / 48).setID("blank");
                p1.incrementMaxBombs();
            }

            if (arena.getPiece((p2.getY() + 21) / 48, (p2.getX() + 21) / 48).getID().equals("speedUp")) {
                arena.getPiece((p2.getY() + 21) / 48, (p2.getX() + 21) / 48).setID("blank");
                p2.incrementSpeed();
            }
            if (arena.getPiece((p2.getY() + 21) / 48, (p2.getX() + 21) / 48).getID().equals("powerUp")) {
                arena.getPiece((p2.getY() + 21) / 48, (p2.getX() + 21) / 48).setID("blank");
                p2.incrementPower();
            }
            if (arena.getPiece((p2.getY() + 21) / 48, (p2.getX() + 21) / 48).getID().equals("bombsUp")) {
                arena.getPiece((p2.getY() + 21) / 48, (p2.getX() + 21) / 48).setID("blank");
                p2.incrementMaxBombs();
            }

            if (arena.getPiece((p3.getY() + 21) / 48, (p3.getX() + 21) / 48).getID().equals("speedUp")) {
                arena.getPiece((p3.getY() + 21) / 48, (p3.getX() + 21) / 48).setID("blank");
                p3.incrementSpeed();
            }
            if (arena.getPiece((p3.getY() + 21) / 48, (p3.getX() + 21) / 48).getID().equals("powerUp")) {
                arena.getPiece((p3.getY() + 21) / 48, (p3.getX() + 21) / 48).setID("blank");
                p3.incrementPower();
            }
            if (arena.getPiece((p3.getY() + 21) / 48, (p3.getX() + 21) / 48).getID().equals("bombsUp")) {
                arena.getPiece((p3.getY() + 21) / 48, (p3.getX() + 21) / 48).setID("blank");
                p3.incrementMaxBombs();
            }

            if (arena.getPiece((p4.getY() + 21) / 48, (p4.getX() + 21) / 48).getID().equals("speedUp")) {
                arena.getPiece((p4.getY() + 21) / 48, (p4.getX() + 21) / 48).setID("blank");
                p4.incrementSpeed();
            }
            if (arena.getPiece((p4.getY() + 21) / 48, (p4.getX() + 21) / 48).getID().equals("powerUp")) {
                arena.getPiece((p4.getY() + 21) / 48, (p4.getX() + 21) / 48).setID("blank");
                p4.incrementPower();
            }
            if (arena.getPiece((p4.getY() + 21) / 48, (p4.getX() + 21) / 48).getID().equals("bombsUp")) {
                arena.getPiece((p4.getY() + 21) / 48, (p4.getX() + 21) / 48).setID("blank");
                p4.incrementMaxBombs();
            }
        }
        repaint();

    }
}