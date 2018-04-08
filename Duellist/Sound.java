import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import javax.sound.sampled.*;
import java.util.*;

public class Sound
{
  public String path_Main = "Carpenter_Brut_Duellist_Main_Menu_16_EDIT";
  public String path_Battle = "Carpenter_Brut_Duellist_BattleEDIT";

  //Dit heb je nodig om het in DEZELFDE file af te spelen.
  public static void main(String[] args)
  {
    self.AudioMain();
  }

  //Dit heb je nodig om het muziek in dezelfde file af te kunnen spelen.
  //Anders kan je het importen bij een andere file en dan werkt het gelijk.
  public static Sound self = new Sound();

  public void AudioMain()
  {
    try
    {
        //Path naar de muziek.
        URL url_1 = /*(URL)*/ self.getClass().getResource("Audio/" + path_Main + ".wav");

        //De path wordt gezet op de Audio Input Stream,
        //zodat het later op een Clip gezet kan worden.
        AudioInputStream input_1 = AudioSystem.getAudioInputStream(url_1);

        //Hier wordt het format van je audio file opgehaald.
        DataLine.Info info_1 = new DataLine.Info(Clip.class, input_1.getFormat());

        //Hier wordt de clip gedeclareerd met de informatie van het formaat.
        Clip clip_1 = (Clip) AudioSystem.getLine(info_1);

        //De Audio Input Stream wordt gezet op de clip zodat het afgespeeld kan worden.
        clip_1.open(input_1);

        //Hier wordt de clip gestart.
        clip_1.start();

        //De muziek wordt in een oneindige loop gezet.
        clip_1.loop(Clip.LOOP_CONTINUOUSLY);
    }

    //Een catch heb je nodig om de try statement op te
    //vangen als er een foutmelding is.
    catch (Exception e)
    {
      System.out.println(e.toString());
    }
  }

  //Audio for the fight
  public void AudioBattle()
  {
    try
    {
      URL url_2 = self.getClass().getResource("Audio/" + path_Battle + ".wav");
      AudioInputStream input_2 = AudioSystem.getAudioInputStream(url_2);
      DataLine.Info info_2 = new DataLine.Info(Clip.class, input_2.getFormat());
      Clip clip_2 = (Clip) AudioSystem.getLine(info_2);
      clip_2.open(input_2);
      clip_2.start();
      clip_2.loop(Clip.LOOP_CONTINUOUSLY);
    }

    catch (Exception e)
    {
      System.out.println(e.toString());
    }
  }
}
