package de.htw.chatclient

import de.htw.chatclient.controller.MessageController
import de.htw.chatclient.views.MainView
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig


/**
 * @author vera on 31.05.16.
 */
class Main {

    public static void main(String[] args) {
        println('Application started')

        // TODO ifconfig eigene Ip eintragen
        String uri = "http://141.45.201.83:8080/"
        GrizzlyHttpServerFactory.createHttpServer(
                uri.toURI(),
                new ResourceConfig(MessageController.class));

        MainView l = new MainView()
        l.show();
    }


}
