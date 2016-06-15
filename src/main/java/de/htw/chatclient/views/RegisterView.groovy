package de.htw.chatclient.views

import de.htw.chatclient.service.RegisterService
import groovyx.javafx.SceneGraphBuilder
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.layout.GridPane
import sun.tools.jstat.Alignment

import static groovyx.javafx.GroovyFX.start
import javafx.stage.Stage

/**
 * Created by laura on 06.06.16.
 */
class RegisterView {

    void show() throws Exception {
        // super.start(primaryStage)

        start {
            Stage stage = stage(title: "ConnectMe", visible: true) {
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

                        center() {
                            hbox(style: "-fx-background-color: white", alignment: "CENTER") {
                                gridPane(hgap: 20, vgap: 12, padding: 25, alignment: "CENTER") {

                                    label("Werde Teil von ConnectMe", style: "-fx-font-size: 24px;", row: 0, columnSpan: 2, halignment: "center",
                                            margin: [0, 0, 10]) {}

                                    label("Benutzername", row: 1, column: 0)
                                    textField(id: "usernameTextField", promptText: "z.B. anna123", row: 1, column: 1 )

                                    label("E-Mail", row: 2, column: 0)
                                    textField(id: "emailTextField", promptText: "z.B. user@123.de", row: 2, column: 1)

                                    label("Passwort", row: 3, column: 0)
                                    passwordField(id: "passwordField", promptText: "Passwort eingeben", row: 3, column: 1)

                                    label("Passwort wiederholen", row: 4, column: 0)
                                    passwordField(promptText: "Passwort wiederholen", row: 4, column: 1)

                                    button(id: "registrationButton", "Registrier dich jetzt", row: 5, column: 0, columnSpan: 2, style: "-fx-base: #29CCE9;")
                                    registrationButton.setMinWidth(310)

//                                    //******** EventHandler Reg_Button START *********
//                                    registrationButton.setOnAction(new EventHandler<ActionEvent>() {
//                                        //@Override
//                                        public void handle(ActionEvent event) {
//                                            String name = GridPane.this.usernameTextField.getText()
//                                            String email = emailTextField.getText()
//                                            String passwort = passwordField.getText()
//
//                                            RegisterService regService = new RegisterService()
//                                            //TODO prüfe ob Mail, Name, PW vorhanden
//                                            boolean isSuccessful = (Boolean)regService.register(name, email, passwort)
//                                            if (isSuccessful){
//                                                registrationButton.setText("success")
//                                            }
//                                            else {
//                                                registrationButton.setText("fail")
//                                            }
//                                        }
//                                    })
//                                    //******** EventHandler Reg_Button ENDE *********


                                }

                            }
                        }

                    }
                }
            }

            //stage.scene.borderPane.center.hbox.gridPane.registrationButton;
        }


    }
}

