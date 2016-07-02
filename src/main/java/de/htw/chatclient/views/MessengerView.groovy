package de.htw.chatclient.views

import de.htw.chatclient.Message
import de.htw.chatclient.service.MessageService
import de.htw.chatclient.service.OnlineUserService
import groovyx.javafx.SceneGraphBuilder


/**
 * Created by Sarah on 26.06.16.
 */
class MessengerView {


    public static Object build(SceneGraphBuilder sceneGraphBuilder) {
        MessageService messageService = new MessageService()
        sceneGraphBuilder.build {

            borderPane(id: "pane", width: 1000, height: 775) {

                top() {
                    hbox(padding: 25, style: "-fx-background-color: #C8F6FF") {
                        hyperlink(text: "Ausloggen") {
                            onMouseClicked { e ->
                                pane.getChildren().setAll(LoginView.build(sceneGraphBuilder))
                            }
                        }
                    }
                }
                right(align: "center") {
                    hbox(padding: 25, style: "-fx-background-color: white") {}
                }
                left(align: "center") {
                    hbox(padding: 25, style: "-fx-background-color: grey") {
                        gridPane(hgap: 20, vgap: 12, padding: 25) {


                            OnlineUserService onlineUserService = new OnlineUserService()
                            def onlineuser = onlineUserService.getOnlineUser().keySet()
                            int i = 0
                            for (String mail : onlineuser) {
                                hyperlink(id: mail, text: mail, row: i) {
                                    onMouseClicked { e ->
                                        String hyperMail = e.source.text
                                        println("Klick auf $hyperMail")
                                        Store.dialogPartnerMail = hyperMail
                                        println("dialogPartnerMail auf $Store.dialogPartnerMail gesetzt")
                                        pane.getChildren().setAll(MessengerView.build(sceneGraphBuilder))
                                    }
                                    i++
                                }
                            }
                        }
                    }
                }
                bottom(align: "center") {
                    hbox(padding: 25, style: "-fx-background-color: white") {}
                }

                center() {
                    hbox(style: "-fx-background-color: white", alignment: "CENTER") {
                        gridPane(hgap: 20, vgap: 12, padding: 25, alignment: "CENTER") {

                            def conversation = messageService.getConnversation(Store.dialogPartnerMail)
                            int i = 0
                            for (Message actual : conversation) {
                                label(text: actual.senderMail, row: i, column: 0, style: "-fx-text-fill: red")
                                i++
                                label(text: actual.textMessage, row: i, column: 0)
                                i++
                            }

                            if (Store.dialogPartnerMail.equals(null)){
                                label(text: "Klicke einen Onlineuser an, um Chat zu starten")
                            } else {
                                textField(id: "messagetextfield", text: "message", row: i, column: 0)
                                button(text: "senden", row: i, column: 1) {
                                    onMouseClicked { e ->
                                        // TODO Mail nicht hardcoden
                                        println("send Message")
                                        messageService.send(new Message(senderMail: Store.ownerMail, receiverMail: Store.dialogPartnerMail, textMessage: messagetextfield.getText()))
                                        pane.getChildren().setAll(MessengerView.build(sceneGraphBuilder))

                                    }
                                }
                            }

                        }

                    }
                }

            }
        }
    }


}
