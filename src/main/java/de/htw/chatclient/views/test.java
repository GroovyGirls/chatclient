package de.htw.chatclient.views;

import de.htw.chatclient.service.RegisterService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    private TextField usernameTextField;
    private TextField emailTextField;
    private Button registrationButton;
    private PasswordField passwordField;

    @Override
    public void start(final Stage primaryStage) {

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

        Text scenetitle = new Text("Werde Teil von ConnectMe");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label UsernameLabel = new Label("Benutzername:");
        grid.add(UsernameLabel, 0, 1);

        usernameTextField = new TextField();
        grid.add(usernameTextField, 1, 1);

        Label EmailLabel = new Label("E-Mail:");
        grid.add(EmailLabel, 0, 2);

        emailTextField = new TextField();
        grid.add(emailTextField, 1, 2);

        Label PasswortLabel = new Label("Passwort:");
        grid.add(PasswortLabel, 0, 3);

        passwordField = new PasswordField();
        grid.add(passwordField, 1, 3);

        Label PwConfirmationLabel = new Label("Passwort wiederholen");
        grid.add(PwConfirmationLabel, 0, 4);

        PasswordField PwConfirmationField = new PasswordField();
        grid.add(PwConfirmationField, 1, 4);

        //TO DO: Button nicht final machen
        registrationButton = new Button("Registrier dich jetzt");
        registrationButton.setStyle("-fx-base: #29CCE9;");
        grid.add(registrationButton, 0, 5);

        Scene scene = new Scene(border, 1000, 775);
        primaryStage.setScene(scene);

        //******** EventHandler *********
        registrationButton.setOnAction(new EventHandler<ActionEvent>() {
            //@Override
            public void handle(ActionEvent event) {
                String name = usernameTextField.getText();
                String email = emailTextField.getText();
                String passwort = passwordField.getText();

                RegisterService regService = new RegisterService();
                //TODO prüfe ob Mail, Name, PW vorhanden
                boolean isSuccessful = (Boolean)regService.register(name, email, passwort);
                if (isSuccessful){
                    registrationButton.setText("success");
                }
                else {
                    registrationButton.setText("fail");
                }
            }
        });

        //******** EventHandler *********
        loginHyperlink.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //new LoginView().start(primaryStage);
            }
        });

        //******** EventHandler *********
        RegistrierenHyperlink.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new Test().start(primaryStage);
            }
        });


        primaryStage.show();


    }



}
