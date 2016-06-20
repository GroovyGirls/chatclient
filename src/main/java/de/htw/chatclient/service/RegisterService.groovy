package de.htw.chatclient.service

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException

import javax.ws.rs.core.MediaType

/**
 * Created by vera on 31.05.16.
 */
class RegisterService {

    /**
     *
     * @param name
     * @param mail
     * @param password
     * @return true wenn der User erfolgreich regestriert wurde und false falls die Regestrierung nicht erfolgreich war.
     */
    def register(String name, String mail, String password) {
        def http = new HTTPBuilder('http://localhost:8081')
        def postBody = [name: name, mail: mail, password: password] // will be url-encoded

        boolean result = false


        try {
            http.post(path: '/register', body: postBody,
                    requestContentType: MediaType.APPLICATION_JSON) { resp ->

                // TODO anhand des statusCode booelan an Oberfläche übergeben
                println "POST Success: ${resp.statusLine}"
                if (resp.statusLine.statusCode == 200) {
                    result = true
                }
            }
        } catch (HttpResponseException e) {
            result = false
        }
        result
    }
}
