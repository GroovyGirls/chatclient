package de.htw.chatclient.service

import groovyx.net.http.HTTPBuilder

import javax.ws.rs.core.MediaType

/**
 * Created by vera on 31.05.16.
 */
class RegisterService {

    def register(String name, String mail, String password) {
        def http = new HTTPBuilder('http://localhost:8081')
        def postBody = [name: name, mail: mail, password: password] // will be url-encoded

        http.post(path: '/register', body: postBody,
                requestContentType: MediaType.APPLICATION_JSON) { resp ->

            // TODO statusCode an Oberfläche übergeben
            println "POST Success: ${resp.statusLine}"
            assert resp.statusLine.statusCode == 200
        }
    }
}
