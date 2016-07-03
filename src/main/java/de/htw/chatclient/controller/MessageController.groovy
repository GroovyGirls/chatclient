package de.htw.chatclient.controller

import de.htw.chatclient.Message
import de.htw.chatclient.service.MessageService

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

/**
 * @author vera
 */
@Path('message')
@Provider
class MessageController {

    MessageService messageService = new MessageService()

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    def getMessage(Message message) {
        try {
            messageService.receive(message)
        } catch (Exception e) {
            // TODO Fehlermeldung
            return Response.serverError().build()
        }
        return Response
                .ok()
                .build()
    }
}
