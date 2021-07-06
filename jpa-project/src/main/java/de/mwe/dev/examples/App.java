/**
 * 
 */
package de.mwe.dev.examples;


import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Mars
 *
 */
public class App extends Application{


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("JPA-Project");
		BorderPane border = new BorderPane();
		
		ListView<String> list = new ListView<>();
		ObservableList<String> items = FXCollections.observableArrayList("eins", "zwei", "drei");
		list.setItems(items);
		list.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("Gewählt wurde:" + list.getSelectionModel().getSelectedItem());
				
			}
		});
		
		border.setLeft(list);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10,10,10,10));
		
		Label vornameLabel = new Label("Vorname");
		grid.add(vornameLabel, 0, 0);
		
		TextField vornameTextField = new TextField();
		grid.add(vornameTextField, 1, 0);
		
		Label nachnameLabel = new Label("Nachname");
		grid.add(nachnameLabel, 0, 1);
		
		TextField nachnameTextField = new TextField();
		grid.add(nachnameTextField, 1, 1);
		
		Label bildLabel = new Label("Passbild");
		grid.add(bildLabel, 0, 2);

		// TODO
//		Image bild = new Image("maxmustermann.png", 0, 100, true, false);
//		ImageView bildView = new ImageView();
//		bildView.setImage(bild);
//		grid.add(bildView, 1, 2);
		
		FileChooser fileChooser = new FileChooser();
		Button neuesBildBtn = new Button("Bild wählen");
		neuesBildBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				File file = fileChooser.showOpenDialog(primaryStage);
				if(file != null) {
					// Datei laden und im Bild anzeigen
				}
				
			}
		});
		
		grid.add(neuesBildBtn, 1, 3);
		
		Label geburtsdatumLabel = new Label("Geburtsdatum");
		grid.add(geburtsdatumLabel, 0, 4);
		
		DatePicker geburtsdatumDatePicker = new DatePicker();
		grid.add(geburtsdatumDatePicker, 1, 4);
		
		Label geschlechtLabel = new Label("Geschlecht");
		grid.add(geschlechtLabel, 0, 5);
		
		FlowPane geschlechtPane = new FlowPane();
		
		ToggleGroup toggleGroup = new ToggleGroup();
		RadioButton maennlichRadioButton = new RadioButton("Männlich");
		maennlichRadioButton.setToggleGroup(toggleGroup);
		maennlichRadioButton.setSelected(true);
		maennlichRadioButton.setPadding(new Insets(0,10,0,0));
		
		RadioButton weiblichRadioButton = new RadioButton("Weiblich");
		weiblichRadioButton.setToggleGroup(toggleGroup);

		geschlechtPane.getChildren().addAll(maennlichRadioButton, weiblichRadioButton);
		grid.add(geschlechtPane, 1, 5);
		
		Label kommentarLabel = new Label("Kommentar");
		grid.add(kommentarLabel, 0, 6);
		
		TextField kommentarTextField = new TextField();
		grid.add(kommentarTextField, 1, 6);
		
		// buttons
		FlowPane buttonPane = new FlowPane();
		Button neuButton = new Button("Neue Person");
		neuButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Person anlegen");
				
			}
		});
		
		Button speicherButton = new Button("Speichere Person");
		speicherButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Person speichern");
				
			}
		});
		Button loeschButton = new Button("Lösche Person");
		loeschButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Person löschen");
				
			}
		});
		buttonPane.getChildren().addAll(neuButton, speicherButton, loeschButton);
		grid.add(buttonPane, 0, 7,2,1);
		
		border.setCenter(grid);
		
		
		primaryStage.setScene(new Scene(border, 750,380));
		primaryStage.show();
	}

}
