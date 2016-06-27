package de.htw.chatclient.views

import de.htw.chatclient.Message
import de.htw.chatclient.Test
import de.htw.chatclient.service.LoginService
import de.htw.chatclient.service.OnlineUserService
import groovyx.javafx.SceneGraphBuilder

import static groovyx.javafx.GroovyFX.start

/**
 * Created by Sarah on 26.06.16.
 */
class MessengerView {


//    void show() throws Exception {
//        // super.start(primaryStage)
//        start {

    public static Object build(SceneGraphBuilder sceneGraphBuilder) {
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
                                hyperlink(id: mail, text: mail, row: i)
                                i++
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
                            def message = Test.getMessage()
                            int i = 0
                            for (Message actual : message) {
                                label(text: actual.senderMail, row: i, column: 0, style: "-fx-text-fill: red")
                                i++
                                label(text: actual.textMessage, row: i, column: 0)
                                i++
                            }
                            //label(text:"test", row: 0, columnSpan: 2)
                            textField(id: "messagetextfield", text:"message", row: i, column:0)
                            button(text: "senden", row: i, column: 1){
                                onMouseClicked{  e ->
                                    // TODO Mail nicht hardcoden
                                    Test.getMessage().add(new Message(senderMail: "1", textMessage: messagetextfield.getText()))
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
