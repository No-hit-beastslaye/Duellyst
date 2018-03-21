import javafx.application.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;

import javafx.stage.*;
import javafx.event.*;
import javafx.scene.image.*;

import javafx.scene.text.*;
import javafx.scene.Group;

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
    ImageView backdrop1 = new ImageView();

    //Image wordt aangeroepen en gelinkt met het Main Menu.
    backdrop1 = new ImageView(welc);
    screen1.getChildren().add(backdrop1);

    //Controls screen Pane en achtergrond.
    Pane Con_Screen = new Pane();
    Image C1 = new Image("Images/back2.png");
    Image C2 = new Image("Images/Controls.png");
    ImageView V1 = new ImageView();

    //Image wordt aangeroepen en gelinkt met het Controls scherm.
    V1 = new ImageView(C1);
    Con_Screen.getChildren().add(V1);

    //Text voor het start scherm
    Text intro = new Text();
    intro.setText("Duellist");
    intro.setFont(Font.font("sans-serif", FontWeight.BOLD, FontPosture.REGULAR, 40));
    intro.setFill(Color.BLUE);
    intro.setX(540);
    intro.setY(175);

    //Audio declaratie voor het eerste scherm.
    String path = "Audio/Main_Menu.wav";


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
    Group HUD = new Group();

    //Scene declaraties
    final Scene Welcome = new Scene(welcText, 1250, 750);
    final Scene Control_Screen = new Scene(Control, 1250, 750);
    final Scene Game = new Scene(HUD,1250, 750);

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

*/
