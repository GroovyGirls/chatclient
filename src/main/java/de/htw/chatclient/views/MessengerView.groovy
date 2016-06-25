package de.htw.chatclient.views

import de.htw.chatclient.service.LoginService
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
                    hbox(padding: 25, style: "-fx-background-color: white") {}
                }
                bottom(align: "center") {
                    hbox(padding: 25, style: "-fx-background-color: white") {}
                }

                center() {
                    hbox(style: "-fx-background-color: white", alignment: "CENTER") {
                        gridPane(hgap: 20, vgap: 12, padding: 25, alignment: "CENTER") {
                            top() {
                                hbox(style: "-fx-background-color: #C8FFFF")
                            }
                            bottom() {
                                hbox(style: "-fx-background-color: #C8DDFF")
                                textField(id: "message", promtText: "was möchtest du sagen...")
                                button(id: "send", promtText: "Senden")
                            }

                        }

                    }
                }

            }
        }
    }


}
