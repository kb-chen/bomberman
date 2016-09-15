import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio {

    Clip MenuMusic, MenuMove, MenuSelect, BombDrop, BombExplode, Victory, GameSong;
    int useless;

    public Audio(int num)
    {
        useless = num;
    }

    public void playMenu()
    {
        try
        {
            AudioInputStream in1 = AudioSystem.getAudioInputStream(new File("Resources/MenuMusic.wav"));
            MenuMusic = AudioSystem.getClip();
            MenuMusic.open(in1);
            MenuMusic.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void stopMenu()
    {
        MenuMusic.stop();
    }

    public static void playMenuMove()
    {
        try
        {
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("Resources/MenuMove.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playMenuSelect()
    {
        try
        {
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("Resources/MenuSelect.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playBombDrop()
    {
        try
        {
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("Resources/BombDrop.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playBombExplode()
    {
        try
        {
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("Resources/BombExplode.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playVictory()
    {
        try
        {
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("Resources/Victory.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void playGameSong()
    {

    }
}
