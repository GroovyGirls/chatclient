package de.htw.chatclient

import de.htw.chatclient.service.RegisterService
import de.htw.chatclient.views.RegisterView
import de.htw.chatclient.views.Test
import groovyx.net.http.HttpResponseException
import javafx.application.Application
import javafx.stage.Stage

import javax.ws.rs.core.Response

/**
 * Created by vera on 31.05.16.
 */
class Main  {

    public static void main(String[] args) {
        println('Application started')
        Application.launch(Test.class);

// Beispielhafter Aufruf für Regestrierung eines Users
// 200 OK --> User wurde regestriert
// 409 CONFLICT --> mit der Mail gibt es bereits einen User
        RegisterService registerController = new RegisterService();


        //RegisterView r = new RegisterView()
        //r.show();//start(primaryStage)
        new Test().start(new Stage())


        try {

            def register = registerController.register('Anna', 'mail@mail.de', '123') // 200 Ok wenn User regestriert
        } catch (e) {
            if (e instanceof HttpResponseException) {
                e.statusCode == Response.Status.CONFLICT.statusCode // Conflict wenn email bereits regestriert
                println("status code: " + e.statusCode)
            }
            println("error: " + e)
        }

    }


}
