

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Area;
import model.Status;
import repository.AreaRepository;
import repository.StatusRepository;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
	 //PrimaryStage
    private Stage primaryStage;
 
    //BorderPane of RootLayout
    private BorderPane rootLayout;
   // private VBox rootLayout;
   // private AnchorPane rootLayout;
 
    @Override
    public void start(Stage primaryStage) {
        //Declare a primary stage (will be used for everything)
        this.primaryStage = primaryStage;
 
        //Set primary stage title
        this.primaryStage.setTitle("Request Handling System for Apartments - an App by JTMM");
 
        //Initialize RootLayout
        initRootLayout();
 
        //Display the Start View
        showStartView();
        
        //Display the View
       // String location = "view/StartView.fxml";
         //showView(location);
    }
 
    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //Load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
          //  rootLayout = (VBox) loader.load();
           // rootLayout = (AnchorPane) loader.load();
 
            
            //Show the scene holding the root layout.
            Scene scene = new Scene(rootLayout); //rootLayout sent to scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.
 
            /*//Give the controller access to the main.
            RootLayoutController controller = loader.getController();
            controller.setMain(this);*/
 
            //Show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
        	System.err.println("An IO exception occured when initilizing root layout");
            e.printStackTrace();
        }
    }
 
    
    //Shows the start view inside the root layout.
  
    public void showStartView() {
        try {
            //Load StartView from StartView.fxml
            FXMLLoader loader = new FXMLLoader();
            //loader.setLocation(Main.class.getResource("view/StartView.fxml"));          <--- Har �ndrat h�r f�r att visa area bilden
            loader.setLocation(Main.class.getResource("view/AreaView.fxml"));
            //BorderPane startView = (BorderPane) loader.load();
            AnchorPane startView = (AnchorPane) loader.load();
 
            // Set Start view into the center of root layout.
            rootLayout.setCenter(startView);
            //rootLayout.set(startView);
          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    public void showView(String location) {
        try {
            //Load View from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(location));
            AnchorPane view = (AnchorPane) loader.load();
 
            // Set view into the center of root layout.
           // rootLayout.setCenter(view);
          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

	public static void main(String[] args) {
		
		
		// TEST
		//StatusRepository sr = new StatusRepository();
		//AreaRepository ar = new AreaRepository();
		
		// TEST ADD status
		// sr.addStatus("TEST 7");
		// Area area = new Area();
		// area.setName("Sj�gatan");
		// ar.add(area);
		
		// TEST GET Status 1
		// Status status = sr.getStatus(2);
		// System.out.println(status.getStatus());
		// System.out.println(ar.get(2).toString());
		
		// TEST GET ALL Areas and printout
		// ArrayList<Area> areas = ar.getAll();
		// areas.forEach(a -> System.out.println(a.toString()));

		launch(args);

	}

}


