package de.htw.chatclient.service

import groovyx.net.http.HTTPBuilder
import javax.ws.rs.core.MediaType

/**
 * Created by Ju on 19.06.2016.
 */
class LoginService {

        def login(String mail, String pwd) {
            def http = new HTTPBuilder('http://localhost:8081')
            def postBody = [mail: mail, password: pwd] // will be url-encoded

            http.post(path: '/login', body: postBody,
                    requestContentType: MediaType.APPLICATION_JSON) { resp ->

                // TODO statusCode an Oberfläche übergeben
                println "POST Success: ${resp.statusLine}"
                println "Loginabfrage hat geklappt"
                assert resp.statusLine.statusCode == 200
            }
        }
}
