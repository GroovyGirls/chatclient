package de.htw.chatclient

import de.htw.chatclient.service.RegisterService
import groovyx.net.http.HttpResponseException

import javax.ws.rs.core.Response

/**
 * Created by vera on 31.05.16.
 */
class Main {

    static void main(String[] args) {
        println('Application started')

// Beispielhafter Aufruf für Regestrierung eines Users
// 200 OK --> User wurde regestriert
// 409 CONFLICT --> mit der Mail gibt es bereits einen User
        RegisterService registerController = new RegisterService();
        try {

            def register = registerController.register('Anna', 'mail2@mail.de', '123') // 200 Ok wenn User regestriert
        } catch (e) {
            if (e instanceof HttpResponseException) {
                e.statusCode == Response.Status.CONFLICT.statusCode // Conflict wenn email bereits regestriert
                println("status code: " + e.statusCode)
            }
            println("error: " + e)
        }

    }

}
