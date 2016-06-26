package de.htw.chatclient

import de.htw.chatclient.service.Util

/**
 * @author vera
 */
class MessageStore {

    static final MessageStore messageStore = new MessageStore()
    String ownerMail
    HashMap<String, List<Message>> messages

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

    def getConversation = { String mail ->
        return messages[mail]
    }

}
