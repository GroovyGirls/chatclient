package de.htw.chatclient

import de.htw.chatclient.controller.MessageController
import de.htw.chatclient.service.LoginService
import de.htw.chatclient.service.LogoutService
import de.htw.chatclient.service.OnlineUserService
import de.htw.chatclient.service.RegisterService
import de.htw.chatclient.views.MainView
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig


/**
 * @author vera on 31.05.16.
 */
class Main {

    public static void main(String[] args) {
        println('Application started')

        // TODO ifconfig ip con wlan0
        String uri = "http://192.168.178.21:8080/"
        GrizzlyHttpServerFactory.createHttpServer(
                uri.toURI(),
                new ResourceConfig(MessageController.class));

        MainView l = new MainView()
        l.show();//start(primaryStage)
        //MessengerView m = new MessengerView()
        //m.show();
        //RegisterView r = new RegisterView()
        //r.show();//start(primaryStage)
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
        boolean login = loginService.login('mail422@mail.de', '123')
        println("ende Login mit ${login}")




        println("start onlineUser")
        OnlineUserService onlineUserService = new OnlineUserService()
        def onlineUser = onlineUserService.getOnlineUser()
        println(onlineUser)
        println("ende onlineUser")


        println("start logout")
        LogoutService logoutService = new LogoutService();
        logoutService.logout()
        println("logout ende")
    }


}
