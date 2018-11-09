package controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.HashMap;

/*

Controller fil för att hantera våra övriga controllers
 */

public class ViewController {

        private static HashMap<String, Pane> screenHolder = new HashMap<>(); //Hashmap som håller alla layouts med ett namn + plats där resursen finns
        private static Scene main; //Huvudscenen Rootlayout

        //Konstruktor
        public ViewController(Scene main) {
            this.main = main;
        }

        //Lägga till i listan
        public void addScreen(String name, Pane pane){
            screenHolder.put(name, pane);
        }

        //Aktivera layout
        public static void activate(String name){
            main.setRoot( screenHolder.get(name) );
        }




}


