package de.htw.chatclient.views

import de.htw.chatclient.service.LoginService
import de.htw.chatclient.service.RegisterService
import groovyx.javafx.SceneGraphBuilder
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler

import static groovyx.javafx.GroovyFX.start
import javafx.stage.Stage

/**
 * @autor laura on 06.06.16.
 */
class MainView {

    void show() throws Exception {
        // super.start(primaryStage)
        start {

            //imageURL = "http://www.nasa.gov/images/content/611907main_image_2134_800-600.jpg"
            //"C:/Users/Nadia/Documents/6Semester/ModScript/ConnectMeLogo.jpg"
            // "C://Users//Nadia//Documents//6Semester//ModScript//ConnectMeLogo.jpg"
            // "http://www.nasa.gov/images/content/611907main_image_2134_800-600.jpg"
            //"C:\Users\Nadia\Documents\6Semester\ModScript\ConnectMeLogo.jpg"

            SceneGraphBuilder sceneGraphBuilder = new SceneGraphBuilder()
            LoginScene.loginSCene(sceneGraphBuilder)
            RegisterScene.registerScene(sceneGraphBuilder)

            }
        }





    /*    primaryStage.setTitle("ConnectMe");

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

        RegisterScene scene = new RegisterScene(border, 1000, 775);
        primaryStage.setScene(scene);

        primaryStage.show();

        //******** EventHandler *********
        loginHyperlink.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new MainView().start(primaryStage);
            }
        });

        //******** EventHandler *********
        RegistrierenHyperlink.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new Test().start(primaryStage);
            }
        });

    */
}