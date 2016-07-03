package de.htw.chatclient

import de.htw.chatclient.service.Util

/**
 * Der Store ist ein Singleton und speichert für alle Gespräche die gesendeten und empfangenen Nachrichten.
 * @author vera
 */
class MessageStore {

    static final MessageStore messageStore = new MessageStore()
    String ownerMail
    static HashMap<String, List<Message>> messages = new HashMap<>()

    private MessageStore() {
    }

    static MessageStore getMessageStore() {
        return messageStore
    }

    def addMessage = { Message message ->
        if (ownerMail == null) {
            throw new IllegalStateException("Owner Mail has not been set yet.")
        }

        String key
        if (message.senderMail.equals(ownerMail)) {
            key = message.receiverMail
        } else {
            key = message.senderMail
        }
        if (!messages.containsKey(key)) {
            messages[key] = new LinkedList<>()
        }
        messages[key].add(message)
    }

    def getConversation(String mail) {
        if (!messages.containsKey(mail)) {
            messages[mail] = new LinkedList<>()
        }
        return messages[mail]
    }

}
