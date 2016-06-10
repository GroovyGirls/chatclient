package de.htw.chatclient.views

/**
 * Created by laura on 08.06.16.
 */
import static groovyx.javafx.GroovyFX.start


start {
    stage (title: "TEST", show: true) {
        scene (fill: groovyblue, width: 429, height: 420) {
            text("Hello World")
        }
    }

}
