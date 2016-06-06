package de.htw.chatclient.views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by laura on 30.05.16.
 */
public class Test extends Application {


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

        Hyperlink LoginHyperlink = new Hyperlink();
        LoginHyperlink.setText("Einloggen");

        Hyperlink RegistrierenHyperlink = new Hyperlink();
        RegistrierenHyperlink.setText("Registrieren");

        header.getChildren().addAll(LoginHyperlink, RegistrierenHyperlink);

        Text scenetitle = new Text("Werde Teil von ConnectMe");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label UsernameLabel = new Label("Username:");
        grid.add(UsernameLabel, 0, 1);

        TextField UsernameTextField = new TextField();
        grid.add(UsernameTextField, 1, 1);

        Label EmailLabel = new Label("E-Mail");
        grid.add(EmailLabel, 0, 2);

        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 2);

        Label PasswortLabel = new Label("Password:");
        grid.add(PasswortLabel, 0, 3);

        PasswordField PasswortField = new PasswordField();
        grid.add(PasswortField, 1, 3);

        Label PwConfirmationLabel = new Label("Passwort wiederholen");
        grid.add(PwConfirmationLabel, 0, 4);

        PasswordField PwConfirmationField = new PasswordField();
        grid.add(PwConfirmationField, 1, 4);

        Button RegistrationButton = new Button("Registrier dich jetzt");
        RegistrationButton.setStyle("-fx-base: #29CCE9;");
        grid.add(RegistrationButton, 0, 5);

        Scene scene = new Scene(border, 1000, 775);
        primaryStage.setScene(scene);

        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }


}
