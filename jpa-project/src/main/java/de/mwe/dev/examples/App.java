/**
 * 
 */
package de.mwe.dev.examples;


import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import javax.imageio.ImageIO;

import de.mwe.dev.examples.model.Geschlecht;
import de.mwe.dev.examples.model.Person;
import de.mwe.dev.examples.model.PersonDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.ToggleButton;
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

	PersonDAO personDao;
	private Person aktuellePerson;
	private TextField vornameTextField;
	private TextField nachnameTextField;
	private ImageView bildView;
	private DatePicker geburtsdatumDatePicker;
	private ToggleButton maennlichRadioButton;
	private RadioButton weiblichRadioButton;
	private TextField kommentarTextField;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		personDao = new PersonDAO();
		
		primaryStage.setTitle("JPA-Project");
		BorderPane border = new BorderPane();
		
		ListView<Person> list = new ListView<>();
		ObservableList<Person> items = loadItemsFromDataBase();//FXCollections.observableArrayList("eins", "zwei", "drei");
		list.setItems(items);
		list.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("Gewählt wurde:" + list.getSelectionModel().getSelectedItem());
				updateFieldsWithNewPerson(list.getSelectionModel().getSelectedItem());
			}
		});
		
		border.setLeft(list);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10,10,10,10));
		
		Label vornameLabel = new Label("Vorname");
		grid.add(vornameLabel, 0, 0);
		
		vornameTextField = new TextField();
		grid.add(vornameTextField, 1, 0);
		
		Label nachnameLabel = new Label("Nachname");
		grid.add(nachnameLabel, 0, 1);
		
		nachnameTextField = new TextField();
		grid.add(nachnameTextField, 1, 1);
		
		Label bildLabel = new Label("Passbild");
		grid.add(bildLabel, 0, 2);

		Image bild = new Image("maxmustermann.png", 0, 100, true, false);
        bildView = new ImageView();
		bildView.setImage(bild);
		grid.add(bildView, 1, 2);
		
		FileChooser fileChooser = new FileChooser();
		Button neuesBildBtn = new Button("Bild wählen");
		neuesBildBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				File file = fileChooser.showOpenDialog(primaryStage);
				if(file != null) {
					try {
						InputStream is = new BufferedInputStream(new FileInputStream(file));
						Image img = new Image(is,0,100,true,false);
						bildView.setImage(img);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		grid.add(neuesBildBtn, 1, 3);
		
		Label geburtsdatumLabel = new Label("Geburtsdatum");
		grid.add(geburtsdatumLabel, 0, 4);
		
		geburtsdatumDatePicker = new DatePicker();
		grid.add(geburtsdatumDatePicker, 1, 4);
		
		Label geschlechtLabel = new Label("Geschlecht");
		grid.add(geschlechtLabel, 0, 5);
		
		FlowPane geschlechtPane = new FlowPane();
		
		ToggleGroup toggleGroup = new ToggleGroup();
		maennlichRadioButton = new RadioButton("Männlich");
		maennlichRadioButton.setToggleGroup(toggleGroup);
		maennlichRadioButton.setSelected(true);
		maennlichRadioButton.setPadding(new Insets(0,10,0,0));
		
		weiblichRadioButton = new RadioButton("Weiblich");
		weiblichRadioButton.setToggleGroup(toggleGroup);

		geschlechtPane.getChildren().addAll(maennlichRadioButton, weiblichRadioButton);
		grid.add(geschlechtPane, 1, 5);
		
		Label kommentarLabel = new Label("Kommentar");
		grid.add(kommentarLabel, 0, 6);
		
		kommentarTextField = new TextField();
		grid.add(kommentarTextField, 1, 6);
		
		// buttons
		FlowPane buttonPane = new FlowPane();
		Button neuButton = new Button("Neue Person");
		neuButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Person anlegen");
				aktuellePerson = new Person();
				updateFieldsWithNewPerson(aktuellePerson);
				
			}
		});
		
		Button speicherButton = new Button("Speichere Person");
		speicherButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Person speichern");
				
				updatePersonInDBWithFields();
				
				list.getItems().clear();
				list.setItems(loadItemsFromDataBase());
			}

		});
		
		Button loeschButton = new Button("Lösche Person");
		loeschButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Person löschen");
				
				personDao.delete(aktuellePerson.getId());
				
				list.getItems().clear();
				list.setItems(loadItemsFromDataBase());
				
			}
		});
		buttonPane.getChildren().addAll(neuButton, speicherButton, loeschButton);
		grid.add(buttonPane, 0, 7,2,1);
		
		border.setCenter(grid);
		
		
		primaryStage.setScene(new Scene(border, 750,380));
		primaryStage.show();
	}
	public void updatePersonInDBWithFields() {
		
		aktuellePerson.setVorname(vornameTextField.getText());
		aktuellePerson.setNachname(nachnameTextField.getText());
		
		if(geburtsdatumDatePicker.getValue() != null) {
			Date geburtsdatum = java.sql.Date.valueOf(geburtsdatumDatePicker.getValue());
			aktuellePerson.setGeburtsdatum(geburtsdatum);
		} else {
			aktuellePerson.setGeburtsdatum(null);
		}
				
		if(maennlichRadioButton.isSelected())
			aktuellePerson.setGeschlecht(Geschlecht.MAENNLICH);
		else
			aktuellePerson.setGeschlecht(Geschlecht.WEIBLICH);
		
		if(bildView.getImage() != null)
			try {
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				ImageIO.write(SwingFXUtils.fromFXImage(bildView.getImage(), null), "png", outStream);
				aktuellePerson.setPassbild(outStream.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			aktuellePerson.setPassbild(null);
		
		aktuellePerson.setKommentar(kommentarTextField.getText());
		
		personDao.persist(aktuellePerson);
		
	}
		
	@Override
	public void stop() throws Exception {
		super.stop();
		personDao.shutdown();
	}
	
	private ObservableList<Person> loadItemsFromDataBase() {
		return FXCollections.observableArrayList(personDao.findAll());
		
	}
	public void updateFieldsWithNewPerson(Person selectedItem) {
		aktuellePerson = selectedItem;
		
		vornameTextField.setText(aktuellePerson.getVorname());
		nachnameTextField.setText(aktuellePerson.getNachname());
		if(aktuellePerson.getPassbild() != null) {
			Image img = new Image(new ByteArrayInputStream(aktuellePerson.getPassbild(), 0, aktuellePerson.getPassbild().length), 0, 100, true, false);
			bildView.setImage(img);
		}else 
			bildView.setImage(null);
		
		if(aktuellePerson.getGeburtsdatum() != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(aktuellePerson.getGeburtsdatum());
			LocalDate date = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
			geburtsdatumDatePicker.setValue(date);
		}else
			geburtsdatumDatePicker.setValue(null);
		
		if(aktuellePerson.getGeschlecht() != null) {
			if(aktuellePerson.getGeschlecht() == Geschlecht.MAENNLICH) {
				maennlichRadioButton.setSelected(true);
				weiblichRadioButton.setSelected(false);
			}else {
				maennlichRadioButton.setSelected(false);
				weiblichRadioButton.setSelected(true);
			}
		}
		kommentarTextField.setText(aktuellePerson.getKommentar());
		
	} 

}
