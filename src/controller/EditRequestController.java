package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EditRequestController {

	  @FXML
	    private ComboBox<?> selectRequestIdCombo;

	    @FXML
	    private ComboBox<?> selectResolverNameCombo;

	    @FXML
	    private ComboBox<?> selectStatusCombo;

	    @FXML
	    private Button updateRequestBtn;

	    @FXML
	    private TableView<?> requestTable;

	    @FXML
	    private TableColumn<?, ?> requestIdColumn;

	    @FXML
	    private TableColumn<?, ?> reportedByColumn;

	    @FXML
	    private TableColumn<?, ?> requestDateColumn;

	    @FXML
	    private TableColumn<?, ?> addressColumn;

	    @FXML
	    private TableColumn<?, ?> houseNoColumn;

	    @FXML
	    private TableColumn<?, ?> apartmentNoColumn;

	    @FXML
	    private TableColumn<?, ?> districtColumn;

	    @FXML
	    private TableColumn<?, ?> descriptionColumn;

	    @FXML
	    private TableColumn<?, ?> statusColumn;

	    @FXML
	    private TableColumn<?, ?> completionDateColumn;

	    @FXML
	    private TableColumn<?, ?> resolvedByColumn;

	    @FXML
	    void goHome(ActionEvent event) {

	    }
}
