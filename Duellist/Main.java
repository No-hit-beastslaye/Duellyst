import javafx.application.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;

import javafx.stage.*;
import javafx.event.*;
import javafx.scene.image.*;

import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.scene.Group;

import javafx.geometry.*;
import javafx.scene.media.*;
import javax.sound.sampled.*;
import java.io.File;

public class Main extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override //Boot up
  public void start(Stage Boot)
  {
    //start up achtergrond en viewport voor het eerste scherm.
    Pane screen1 = new Pane();
    Image welc = new Image("Images/back5.gif");
    ImageView backdrop1 = new ImageView(welc);

    //Image wordt aangeroepen en gelinkt met het Main Menu.
    screen1.getChildren().add(backdrop1);

    //Controls screen Pane en achtergrond.
    Pane Con_Screen = new Pane();
    Image C1 = new Image("Images/back5.gif");
    Image C2 = new Image("Images/Controls.png");

    //V1 is voor de achtergrond van het controls scherm, V2 is voor de control mapping.
    ImageView V1 = new ImageView(C1);
    ImageView V2 = new ImageView(C2);

    //Image wordt aangeroepen en gelinkt met het Controls scherm.
    Con_Screen.getChildren().addAll(V1, V2);

    //Positionering van de control mapping.
    V2.setX(390);
    V2.setY(200);

    //Game pane en achtergrond.
    Pane Fight = new Pane();
    Image Game_Back = new Image("Images/");
    Image Protag = new Image("Models/Protagonist/Main_char_Duellist_helmet_5.png");
    Image Antag = new Image("Models/Antagonist/");
    ImageView GV1 = new ImageView(Game_Back);

    //Image wordt aangeroepen en gelinkt met het Controls scherm.
    Fight.getChildren().add(GV1);

    //Text voor het start scherm
    Text intro = new Text();
    intro.setText("Duellist");
    intro.setFont(Font.font("sans-serif", FontWeight.BOLD, FontPosture.REGULAR, 40));
    intro.setFill(Color.BLUE);
    intro.setX(580);
    intro.setY(175);

    //Strings met de namen van de audio.
    String path_Main = "Carpenter_Brut_Duellist_Main_Menu";
    String path_Fight = "Carpenter_Brut_Duellist_Battle";

    //Audio voor het Main Menu
    Media BackMain = new Media(new File("Audio/" + path_Main + ".wav").toURI().toString());
    MediaPlayer AudioPlayer = new MediaPlayer(BackMain);
    AudioPlayer.setAutoPlay(true);
    MediaView Media = new MediaView(AudioPlayer);

    //Button voor de transitie naar het volgende scherm.
    Button play = new Button();
    play.setLayoutX(550);
    play.setLayoutY(400);
    play.setText("       Start the game      ");

    //Button voor het Controls scherm
    Button controls = new Button();
    controls.setLayoutX(550);
    controls.setLayoutY(450);
    controls.setText("           Controls            ");

    Button back = new Button();
    back.setLayoutX(550);
    back.setLayoutY(550);
    back.setText("               Back               ");

    //Button om de game te sluiten
    Button close = new Button();
    close.setLayoutX(550);
    close.setLayoutY(500);
    close.setText("      Close the game      ");

    //Groups with text.
    Group welcText = new Group(screen1, intro, play, controls, close);
    Group Control = new Group(Con_Screen, back);
    Group HUD = new Group(Fight);

    //Scene declaraties
    Scene Welcome = new Scene(welcText, 1250, 750);
    Scene Control_Screen = new Scene(Control, 1250, 750);
    Scene Game = new Scene(HUD,1250, 750);

    //Eventhandler button van het main menu.
    play.setOnAction(new EventHandler<ActionEvent>()
    {
      public void handle(ActionEvent event)
      {
        Boot.setScene(Game);
      }
    });

    //EventHandler Control screen.
    controls.setOnAction(new EventHandler<ActionEvent>()
    {
      public void handle(ActionEvent event)
      {
        Boot.setScene(Control_Screen);
      }
    });

    //EventHandler exit game
    back.setOnAction(new EventHandler<ActionEvent>()
    {
      public void handle(ActionEvent event)
      {
        Boot.setScene(Welcome);
      }
    });

    //EventHandler exit game
    close.setOnAction(new EventHandler<ActionEvent>()
    {
      public void handle(ActionEvent event)
      {
        System.exit(0);
      }
    });

    Boot.setScene(Welcome);
    Boot.setTitle("Duellist");
    Boot.show();
  }

}

/*Documentatie qua links die ik heb gebruikt:

exit(); - https://stackoverflow.com/questions/2670956/how-to-quit-a-java-app-from-within-the-program/2670959

clip.close() - https://stackoverflow.com/questions/11919009/using-javax-sound-sampled-clip-to-play-loop-and-stop-mutiple-sounds-in-a-game
*/
