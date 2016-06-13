package de.htw.chatclient.views

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Hyperlink
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import javafx.stage.Stage


/**
 * Created by laura on 06.06.16.
 */
class LoginView extends Application {


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("ConnectMe");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(25);
        grid.setVgap(15);
        grid.setPadding(new Insets(0,10,0,10));


        BorderPane border = new BorderPane();
        border.setCenter(grid);

        HBox header = new HBox();
        header.setPadding(new Insets(15, 12, 15, 800));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: #C8F6FF");
        border.setTop(header);

        Hyperlink loginHyperlink = new Hyperlink();
        loginHyperlink.setText("Einloggen");

        Hyperlink RegistrierenHyperlink = new Hyperlink();
        RegistrierenHyperlink.setText("Registrieren");

        header.getChildren().addAll(loginHyperlink, RegistrierenHyperlink);

        Text scenetitle = new Text("Hier kannst du dich anmelden");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label EmailLabel = new Label("E-Mail:");
        grid.add(EmailLabel, 0, 2);

        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 2);

        Label PasswortLabel = new Label("Passwort:");
        grid.add(PasswortLabel, 0, 3);

        PasswordField PasswortField = new PasswordField();
        grid.add(PasswortField, 1, 3);

        Button LoginButton = new Button("Einloggen");
        LoginButton.setStyle("-fx-base: #29CCE9;");
        grid.add(LoginButton, 0, 5);

        Scene scene = new Scene(border, 1000, 775);
        primaryStage.setScene(scene);

        primaryStage.show();

        //******** EventHandler *********
        loginHyperlink.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new LoginView().start(primaryStage);
            }
        });

        //******** EventHandler *********
        RegistrierenHyperlink.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new Test().start(primaryStage);
            }
        });

    }
}
