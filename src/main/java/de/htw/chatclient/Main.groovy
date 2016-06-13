package de.htw.chatclient

import de.htw.chatclient.service.RegisterService
import de.htw.chatclient.views.LoginView
import de.htw.chatclient.views.RegisterView
import de.htw.chatclient.views.Test
import groovyx.net.http.HttpResponseException
import javafx.application.Application
import javafx.stage.Stage

import javax.ws.rs.core.Response

/**
* @author vera on 31.05.16.
*/
class Main {

    public static void main(String[] args) {
        println('Application started')
        Application.launch(Test.class);
        //Application.launch(LoginView.class);

        //RegisterView r = new RegisterView()
        //r.show();//start(primaryStage)
        new Test().start(new Stage())
        //new LoginView().start(new Stage())

        // Beispielhafter Aufruf für Regestrierung eines Users
        // true --> User wurde regestriert
        // false --> mit der Mail gibt es bereits einen User
        RegisterService registerController = new RegisterService();
        boolean register = registerController.register('Anna', 'mail422@mail.de', '123')

        println(register)
    }

}
