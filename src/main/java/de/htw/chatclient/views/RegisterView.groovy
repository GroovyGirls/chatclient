package de.htw.chatclient.views

import javafx.application.Application

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
                        top(align: "center", margin: [10, 0, 10, 0]) {
                            hbox(height: 100)
                        }
                        right(align: "center", margin: [0, 10, 0, 1]) {
                            button(text: "right")
                        }
                        left(align: "center", margin: [0, 10]) {
                            button(text: "left")
                        }
                        bottom(align: "center", margin: [10, 0]) {
                            button(text: "bottom")
                        }
                        /** center example, either construct, center() or standalone node is treated the same.   **/
                        //center(align: "center") {
                        label(text: "center")
                        //}
                    }

                    hbox(padding: 80) {
                        text(text: "Groovy", style: "-fx-font-size: 80pt") {
                            fill linearGradient(endX: 0, stops: [palegreen, seagreen])
                        }
                        text(text: "FX", style: "-fx-font-size: 80pt") {
                            fill linearGradient(endX: 0, stops: [cyan, dodgerblue])
                            effect dropShadow(color: dodgerblue, radius: 25, spread: 0.25)
                        }
                    }
                }
            }
        }
    }
}


