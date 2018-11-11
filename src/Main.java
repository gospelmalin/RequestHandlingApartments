import controller.ViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Request;
import repository.RequestRepository;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

public class Main extends Application {
	 //PrimaryStage
    private Stage primaryStage;
 
    //BorderPane of RootLayout
    private BorderPane rootLayout;
    public static Scene scene;
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
            scene = new Scene(rootLayout); //rootLayout sent to scene.
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
            loader.setLocation(Main.class.getResource("view/StartView.fxml"));
            //loader.setLocation(Main.class.getResource("view/AreaView.fxml"));
            //BorderPane startView = (BorderPane) loader.load();
            AnchorPane startView = (AnchorPane) loader.load();

            //Create an instance of ViewController to hold the different views. We need Scene which is the "foundation" of the view
            ViewController viewcontroller = new ViewController(scene);
            //Add all the views we want in our project here
            viewcontroller.addScreen("RequestView", FXMLLoader.load(getClass().getResource( "view/RequestViewLayout.fxml" ))); //Name + location
            viewcontroller.addScreen("DistrictView", FXMLLoader.load(getClass().getResource( "view/DistrictView.fxml" )));
            viewcontroller.addScreen("AddRequest", FXMLLoader.load(getClass().getResource( "view/AddRequestLayout.fxml" )));
            viewcontroller.addScreen("AdminForm", FXMLLoader.load(getClass().getResource( "view/AdminFormView.fxml" )));
            viewcontroller.addScreen("EditRequest", FXMLLoader.load(getClass().getResource( "view/EditRequestLayout.fxml" )));
            viewcontroller.addScreen("StartView", FXMLLoader.load(getClass().getResource( "view/StartView.fxml" )));
            viewcontroller.addScreen("EditApartment", FXMLLoader.load(getClass().getResource("view/EditApartmentLayout.fxml")));


            //ViewControllers(scene);
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
		//DistrictRepository dr = new DistrictRepository();
		//PersonRepository pr = new PersonRepository();
		
		
		// TEST ADD person
		//Person person1 = new Person();
		//person1.setFirstName("Maria");
		//person1.setLastName("Gustavsson");
		//person1.setFullName("Maria", "Gustavsson");
		//pr.add(person1);
		//Person person2 = new Person();
		//person2.setFirstName("Fredrik");
		//person2.setLastName("Holmberg");
		//person2.setFullName("Fredrik", "Holmberg");
		//pr.add(person2);
		//Person person3 = new Person();
		//person3.setFirstName("Hans");
		//person3.setLastName("Johnsson");
		//person3.setFullName("Hans", "Johnsson");
		//pr.add(person3);
		//Person person4 = new Person();
		//person4.setFirstName("Fia");
		//person4.setLastName("Gardner");
		//person4.setFullName("Fia", "Gardner");
		//pr.add(person4);
		
		
		// TEST GET Person2
		/*
		Person person = pr.get(2);
		System.out.println(person.getPersonId());
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
		System.out.println(person.getFullName());
		System.out.println(pr.get(2).toString());
		*/
		
		// TEST GET ALL Persons and printout
		//ArrayList<Person> persons = pr.getAll();
		//persons.forEach(p -> System.out.println(p.toString()));
		
		// TEST UPDATE person3
		//Person person = pr.get(3);
		//person.setFirstName("Leif");
		//pr.update(person);
		
		// TEST Delete person4
		//Person person = pr.get(4);
		//System.out.println(person.getFullName());
		//pr.remove(person);  
		  
		// TEST GET ALL Persons and printout
		//ArrayList<Person> persons = pr.getAll();
		//persons.forEach(p -> System.out.println(p.toString()));
		
		// TEST ADD status
		// sr.addStatus("TEST 7");
		// District district = new District();
		// district.setName("Strandgatan");
		// dr.add(district);
		
		// TEST GET Status 1
		// Status status = sr.getStatus(2);
		// System.out.println(status.getStatus());
		// System.out.println(sr.get(2).toString());
		
		// TEST GET ALL Districts and printout
		// ArrayList<District> districts = dr.getAll();
		// districts.forEach(d -> System.out.println(d.toString()));
		
	//	RequestRepository rr = new RequestRepository();
		//Calendar currenttime = Calendar.getInstance();
	   // Date sqldate = new Date((currenttime.getTime()).getTime());
		//Date sqldate = new java.sql.Date(currenttime.getTime());
		//System.out.println(sqldate);
	    
		//Request req = new Request(1, 2,"'Rico Medina'", sqldate, 1,"Duck Creek Road", "10A", 25, "Duck Creek", "This is too bad", "Completed", 3, sqldate, 9,"Cameron Delae");
	//	Request req = new Request(13, 2,"'Miriam Shell'", sqldate, 1,"Greater Forest Road", "3510", 5, "The Forest", "Freezer empty", "Completed", 3, sqldate, 9,"Cameron Delae");
		
		
	//	rr.add(req);

		launch(args);

	}

}


