package de.htw.chatclient.views

import groovyx.javafx.SceneGraphBuilder
import javafx.scene.image.Image

import static groovyx.javafx.GroovyFX.start

/**
 * @autor laura on 06.06.16.
 */
class MainView {

    void show() throws Exception {
        // super.start(primaryStage)
        start {

            logo = "../images/logo.jpg"
            //imageURL = "http://www.nasa.gov/images/content/611907main_image_2134_800-600.jpg"
            //"C:/Users/Nadia/Documents/6Semester/ModScript/ConnectMeLogo.jpg"
            // "C://Users//Nadia//Documents//6Semester//ModScript//ConnectMeLogo.jpg"
            // "http://www.nasa.gov/images/content/611907main_image_2134_800-600.jpg"
            //"C:\Users\Nadia\Documents\6Semester\ModScript\ConnectMeLogo.jpg"
            SceneGraphBuilder sceneGraphBuilder = new SceneGraphBuilder()

            stage(title: "ConnectMe Login", visible: true) {
                scene(id: "scene", width: 1000, height: 775) {
                    borderPane(id: "pane") {

                        top() {
                            hbox(padding: 25, style: "-fx-background-color: #C8F6FF") {

                                hyperlink(text: "Registrieren") {
                                    onMouseClicked { e ->
                                        def node = RegisterView.build(sceneGraphBuilder)
                                        println(node.getClass())
                                        pane.getChildren().setAll(node)
                                    }
                                }
                                hyperlink(text: "Login") {
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
                                    //TODO Bild einfügen
                                    //imageView(logo) {
                                    //}
                                    text(text: "ConnectMe ist ein Peer to Peer Messenger,\num mit deinen Freunden in Kontakt zu bleiben.\nRegistrier dich jetzt und werde Teil unserer Community.") {

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