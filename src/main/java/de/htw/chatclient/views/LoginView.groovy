package de.htw.chatclient.views

import de.htw.chatclient.service.LoginService
import groovyx.javafx.SceneGraphBuilder
import javafx.scene.control.Alert

/**
 * @author vera on 21.06.16.
 */
class LoginView {

    public static Object build(SceneGraphBuilder sceneGraphBuilder) {
        sceneGraphBuilder.build {

            borderPane(id: "pane", width: 1000, height: 775) {

                top() {
                    hbox(padding: 25, style: "-fx-background-color: #C8F6FF") {
                        hyperlink(text: "Registrieren") {
                            onMouseClicked { e ->
                                pane.getChildren().setAll(RegisterView.build(sceneGraphBuilder))
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

                            label("Logge dich jetzt hier ein", style: "-fx-font-size: 24px;", row: 0, columnSpan: 2, halignment: "center",
                                    margin: [0, 0, 10]) {}

                            label("E-Mail", id: "email", row: 1, column: 0)
                            textField(id: "emailTextField", promptText: "E-Mailadresse eingeben", row: 1, column: 1)

                            label("Passwort", row: 2, column: 0)
                            passwordField(id: "passwordField", promptText: "Passwort eingeben", row: 2, column: 1)


                            button(id: "loginButton", "Einloggen", row: 3, columnSpan: 2, halignment: "center", style: "-fx-base: #29CCE9") {
                                onMouseClicked { e ->

                                    println("Click on LoginButton")
                                    LoginService loginService = new LoginService()
                                    def mail = emailTextField.getText()
                                    def password = passwordField.getText()
                                    if (mail.equals("") || password.equals("")) {
                                        showAlert("Fehlermeldung", "Pflichtfeld nicht ausgefült", "Bitte gebe Email und Password ein.")
                                    } else {
                                        def loginSuccessful = loginService.login(mail, password)
                                        if (loginSuccessful) {
                                            pane.getChildren().setAll(MessengerView.build(sceneGraphBuilder))
                                        } else {
                                            showAlert("Fehlermeldung", "Einloggen nicht möglich", "Passwort oder Mail ist falsch.")
                                        }
                                    }
                                }
                            }
                            loginButton.setMinWidth(280)
                        }

                    }
                }

            }
        }
    }

    private static void showAlert(String title, String header, String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR)
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
