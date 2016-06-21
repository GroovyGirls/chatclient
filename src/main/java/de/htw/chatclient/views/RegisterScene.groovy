package de.htw.chatclient.views

import de.htw.chatclient.service.RegisterService
import groovyx.javafx.SceneGraphBuilder

/**
 * @author vera on 21.06.16.
 */
class RegisterScene {

    public static Object registerScene(SceneGraphBuilder sceneGraphBuilder) {
        sceneGraphBuilder.build {
          //  stage(title: "ConnectMe Login", visible: true) {
                scene(id: "registerScene", width: 1000, height: 775) {

                    borderPane() {

                        top() {
                            hbox(padding: 25, style: "-fx-background-color: #C8F6FF") {
                                hyperlink(text: "Einloggen") {
                                    onMouseClicked { e ->
                                        println("Einlogen")
                                        // TODO hier fliegt Exception
                                        sceneGraphBuilder.primaryStage.setScene(LoginScene.loginSCene(sceneGraphBuilder))
                                    }
                                }
                                //hyperlink(text: "Registrieren")
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
                                    textField(id: "usernameTextField", promptText: "z.B. anna123", row: 1, column: 1)

                                    label("E-Mail", row: 2, column: 0)
                                    textField(id: "emailTextField", promptText: "z.B. user@123.de", row: 2, column: 1)

                                    label("Passwort", row: 3, column: 0)
                                    passwordField(id: "passwordField", promptText: "Passwort eingeben", row: 3, column: 1)

                                    label("Passwort wiederholen", row: 4, column: 0)
                                    passwordField(promptText: "Passwort wiederholen", row: 4, column: 1)

                                    button(id: "registrationButton", "Registrier dich jetzt", row: 5, column: 0, columnSpan: 2, style: "-fx-base: #29CCE9;") {
                                        onMouseClicked { e ->
                                            RegisterService registerService = new RegisterService();
                                            String name = usernameTextField.getText()
                                            String mail = emailTextField.getText()
                                            String password = passwordField.getText()
                                            // TODO prüfen, ob Passwort = Wiederholung und ob alle Felder gesetzt

                                            def registerSuccessfull = registerService.register(name, mail, password)

                                            if (registerSuccessfull) {
                                                // TODO bestätigen
                                                new MainView().show()
                                            } else {
                                                // TODO Fehlermeldung für Benutzer

                                            }

                                        }
                                    }
                                    registrationButton.setMinWidth(310)

                                }

                            }
                        }

                    }
                }

            }
        }
    }
