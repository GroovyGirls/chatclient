package de.htw.chatclient

import de.htw.chatclient.service.LoginService
import de.htw.chatclient.service.RegisterService
import de.htw.chatclient.views.LoginView
import de.htw.chatclient.views.RegisterView


/**
* @author vera on 31.05.16.
*/
class Main {

    public static void main(String[] args) {
        println('Application started')
        //Application.launch(Test.class);
        //Application.launch(LoginView.class);

        //LoginView l = new LoginView()
        //l.show();//start(primaryStage)
        RegisterView r = new RegisterView()
        r.show();//start(primaryStage)
        //new Test().start(new Stage())

        // Beispielhafter Aufruf für Regestrierung eines Users
        // true --> User wurde regestriert
        // false --> mit der Mail gibt es bereits einen User
        RegisterService registerController = new RegisterService();
        boolean register = registerController.register('Anna', 'mail422@mail.de', '123')

        println(register)

        println("start Login")
        // Beispielaufruf für Login
        // true --> user ist nun eingeloggt
        // false --> einloggen hat nicht funktioniert
        LoginService loginService = new LoginService();
        boolean login = loginService.login('mail@mail.de', '123')
        println("ende Login mit ${login}")
    }


}
