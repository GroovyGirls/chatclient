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
            stage(title: "messenger", visible: true) {
                scene(fill: black, width: 530, height: 300) {
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


