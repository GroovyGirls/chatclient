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
                    hbox(padding: 25, style: "-fx-background-color: white; -fx-border-style: solid; -fx-border-width: 2; -fx-border-color: #29CCE9") {
                        gridPane(hgap: 20, vgap: 12, padding: 25) {


                            OnlineUserService onlineUserService = new OnlineUserService()
                            def onlineuser = onlineUserService.getOnlineUser().keySet()
                            int i = 0
                            for (String mail : onlineuser) {
                                if(!mail.equals(Store.ownerMail)){
                                    String color = "#29CCE9"
                                    if(mail.equals(Store.dialogPartnerMail)) {
                                        color = "#FF11DD"
                                    }
                                hyperlink(id: mail, text: mail, row: i, style: "-fx-text-fill: $color") {
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
                }
                bottom(align: "center") {
                    hbox(padding: 25, style: "-fx-background-color: white") {}
                }

                center() {
                    hbox(style: "-fx-background-color: #FFCCDD", alignment: "CENTER") {
                        borderPane(style: "-fx-background-color: grey") {


                            if (Store.dialogPartnerMail.equals(null)){
                                label(text: "Klicke einen Onlineuser an, um Chat zu starten")
                            }else {

                                top() {
                                    hbox(style: "-fx-background-color: white; -fx-min-width: 500; -fx-max-width: 500; -fx-min-height: 500; -fx-max-height: 500;") {
                                        gridPane(hgap: 20, vgap: 12, padding: 25, alignment: "CENTER") {

                                            def conversation = messageService.getConnversation(Store.dialogPartnerMail)
                                            int i = 0
                                            for (Message actual : conversation) {
                                                if (i % 2 == 0) {
                                                    label(text: actual.senderMail, row: i, column: 0, style: "-fx-text-fill: red")
                                                }else{
                                                    label(text: actual.senderMail, row: i, column: 0, style: "-fx-text-fill: green")
                                                }
                                                i++
                                                label(text: actual.textMessage, row: i, column: 0)
                                                i++
                                            }
                                        }
                                    }
                                }



                                bottom() {
                                    hbox() {
                                        gridPane(hgap: 20, vgap: 12, padding: 25, alignment: "CENTER") {
                                            textArea(id: "messagetextfield", promptText: "message", column: 0)
                                            messagetextfield.setPrefWidth(360)
                                            messagetextfield.setPrefHeight(60)
                                            button(text: "senden", style: "-fx-base: #29CCE9", column: 1) {
                                                onMouseClicked { e ->
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
        }
    }


}
