package de.htw.chatclient.views

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.paint.LinearGradientBuilder

import static groovyx.javafx.GroovyFX.start
import javafx.stage.Stage

/**
 * Created by laura on 06.06.16.
 */
class RegisterView {

    void show() throws Exception {
        // super.start(primaryStage)

        start {
            stage(title: "ConnectMe", visible: true) {
                scene(width: 1000, height: 775) {

                    borderPane() {

                        top() {
                            hbox(padding: 25, style: "-fx-background-color: #C8F6FF") {
                                hyperlink(text: "Einloggen")
                                hyperlink(text: "Registrieren")
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

                        /** center example, either construct, center() or standalone node is treated the same.   **/
                        center() {
                            hbox(style: "-fx-background-color: white", alignment: "CENTER") {
                                gridPane(hgap: 5, vgap: 10, padding: 25, alignment: "CENTER") {
                                    /*columnConstraints(minWidth: 200, halignment: "center")
                                    columnConstraints(prefWidth: 200, hgrow: 'always')*/

                                    label("Werde Teil von ConnectMe", style: "-fx-font-size: 24px;", row: 0, columnSpan: 2, halignment: "center",
                                            margin: [0, 0, 10]) {}

                                    label("Benutzername", row: 1, column: 0)
                                    textField(promptText: "Benutzername eingeben", row: 1, column: 1 )

                                    label("E-Mail", row: 2, column: 0)
                                    textField(promptText: "E-Mailadresse eingeben", row: 2, column: 1)

                                    label("Passwort", row: 3, column: 0)
                                    passwordField(promptText: "Passwort eingeben", row: 3, column: 1)

                                    label("Passwort wiederholen", row: 4, column: 0)
                                    passwordField(promptText: "Passwort wiederholen", row: 4, column: 1)

                                    button("Registrier dich jetzt", row: 5, column: 0, style: "-fx-base: #29CCE9;")

                                }

                            }
                        }

                    }
                }
            }
        }
    }
}

