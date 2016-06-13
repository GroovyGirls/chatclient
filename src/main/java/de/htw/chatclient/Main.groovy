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
        //Application.launch(Test.class);
        Application.launch(LoginView.class);

// Beispielhafter Aufruf für Regestrierung eines Users
// true --> User wurde regestriert
// false --> mit der Mail gibt es bereits einen User
        RegisterService registerController = new RegisterService();


        //RegisterView r = new RegisterView()
        //r.show();//start(primaryStage)
        //new Test().start(new Stage())
        new LoginView().start(new Stage())


        try {

            def register = registerController.register('Anna', 'mail@mail.de', '123') // 200 Ok wenn User regestriert
        } catch (e) {
            if (e instanceof HttpResponseException) {
                e.statusCode == Response.Status.CONFLICT.statusCode // Conflict wenn email bereits regestriert
                println("status code: " + e.statusCode)
            }
            println("error: " + e)
        }

        println(register)
    }

}
