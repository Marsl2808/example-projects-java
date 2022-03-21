package de.mwe.dev.widgetTable;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

	public String[] icons = { "firefox.png", "eclipse.png", "mail.png", "youtube.png", "textedit.png" };
	
	Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

	@Override
	public void start(Stage stage) throws URISyntaxException {

		Group root = new Group();

		// Dock
		ImageView imgViewDock = new ImageView(new Image(getClass().getResource("dock.png").toURI().toString()));
		imgViewDock.setTranslateX(12);
		imgViewDock.setTranslateY(100);

		root.getChildren().add(imgViewDock);

		imgViewDock.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					if (event.getClickCount() == 2) {
						Platform.exit();
					}
				}
			}
		});

		// images
		for (int i = 0; i < icons.length; i++) {
			ImageView icon = new ImageView(new Image(getClass().getResource(icons[i]).toURI().toString()));
			icon.setTranslateX(65 + 80 * i);
			icon.setTranslateY(100);
			icon.setScaleX(.8);
			icon.setScaleY(.8);
			icon.setEffect(new Reflection());
			zoomIn(icon);
			zoomOut(icon);
			clickIcon(i, icon);
			root.getChildren().add(icon);
		}

		var scene = new Scene(root, 500, 200);
		scene.setFill(Color.TRANSPARENT);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setX((screenSize.getWidth() / 2.0) + 280);
		stage.setY(screenSize.getHeight() - 100);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	private void zoomIn(ImageView icon) {

		icon.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				icon.setScaleX(1.0);
				icon.setScaleY(1.0);
			}
		});
	}

	private void zoomOut(ImageView icon) {

		icon.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				icon.setScaleX(.8);
				icon.setScaleY(.8);
			}
		});
	}

	private void clickIcon(int idx, ImageView icon) {
		icon.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (idx == 0) {
					System.out.println("firefox.png");
					String[] cmd = {"/bin/sh", "-c", "google-chrome"};
					startPrg(cmd);
				} else if (idx == 1) {
					System.out.println("eclipse.png");
					String[] cmd = {"/bin/sh", "-c", "eclipse"};
					startPrg(cmd);					
				} else if (idx == 2) {
					System.out.println("mail.png");
					String[] cmd = {"/bin/sh", "-c", "thunderbird"};
					startPrg(cmd);
				} else if (idx == 3) {
					System.out.println("youtube.png");
					getHostServices().showDocument("https://www.youtube.com/");	
				} else if (idx == 4) {
					System.out.println("textedit.png");		
					String[] cmd = {"/bin/sh", "-c", "gnome-terminal"};
					startPrg(cmd);
				}
			}
		});
	}
	
	private void startPrg(String[] cmd) {
		try {
			System.out.println("starting program...");
			Process process = Runtime.getRuntime().exec(cmd);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end start process...");
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch();
	}

}