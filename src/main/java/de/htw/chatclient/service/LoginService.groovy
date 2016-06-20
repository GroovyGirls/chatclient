package de.htw.chatclient.service

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException

import javax.ws.rs.core.MediaType

/**
 * @author vera on 13.06.16.
 */
class LoginService {

    /**
     *
     * @param mail
     * @param password
     * @return true, wenn user eingelogt, ansonsten false
     */
    def login(String mail, String password){

        def http = new HTTPBuilder('http://localhost:8081')
        def postBody = [mail: mail, password: password] // will be url-encoded

        boolean result = false

        try {
            http.post(path: '/login', body: postBody,
                    requestContentType: MediaType.APPLICATION_JSON) { resp ->

                // TODO anhand des statusCode booelan an Oberfläche übergeben
                if (resp.statusLine.statusCode == 200) {
                    result = true
                }
            }
        } catch (HttpResponseException e) {
            println(e)
            result = false
        }
        result
    }
    }

