package de.htw.chatclient

import de.htw.chatclient.service.RegisterService

/**
* @author vera on 31.05.16.
*/
class Main {

    static void main(String[] args) {
        println('Application started')

// Beispielhafter Aufruf für Regestrierung eines Users
// true --> User wurde regestriert
// false --> mit der Mail gibt es bereits einen User
        RegisterService registerController = new RegisterService();
        boolean register = registerController.register('Anna', 'mail422@mail.de', '123')

        println(register)
    }

}
