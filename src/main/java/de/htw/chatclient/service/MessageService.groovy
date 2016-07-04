package de.htw.chatclient.service

import de.htw.chatclient.Message
import de.htw.chatclient.MessageStore
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException

import javax.ws.rs.core.MediaType

/**
 * @author vera
 */
class MessageService {

    MessageStore messageStore = MessageStore.getMessageStore()

    /**
     * Senden einer Nachricht an die in der Message enthaltenen receiverMail. Die Message wird im MessageStore gespeichert.
     * @param message
     */
    void send(Message message) {
        String receiverMail = message.receiverMail

        OnlineUserService onlineUserService = new OnlineUserService()

        Map<String, String> onlineUser = onlineUserService.getOnlineUser()
        String ipAdress = onlineUser.get(receiverMail)
        def port = ":8080"
        def http = new HTTPBuilder("http://$ipAdress$port")

        def postBody = [senderMail: message.senderMail, receiverMail: message.receiverMail, date: message.date, textMessage: message.textMessage]
        // will be url-encoded


        try {
            http.post(path: '/message', body: postBody,
                    requestContentType: MediaType.APPLICATION_JSON)
        } catch (HttpResponseException e) {
            println(e)
            // TODO Fehlerbehandlung
        }

        messageStore.addMessage(message)
    }

    /**
     * Wird vom Controller aufgerufen, wenn eine Nachricht eingeht. Die Nachricht wird im MessageStore gespeichert.
     * @param message
     */
    void receive(Message message) {
        messageStore.addMessage(message)
        // TODO Meldung in View
    }

    LinkedList<Message> getConnversation(String mail) {
        messageStore.getConversation(mail)
    }

    void clearMessages() {
        messageStore.clearMessageStore()
    }

}
