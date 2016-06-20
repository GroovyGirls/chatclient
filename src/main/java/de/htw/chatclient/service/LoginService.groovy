package de.htw.chatclient.service

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException

import javax.ws.rs.core.MediaType

/**
 * @author vera on 13.06.16.
 */
class LoginService {

    private def URL = 'http://localhost:8081'

    /**
     *
     * @param mail
     * @param password
     * @return true, wenn user eingelogt, ansonsten false
     */
    def login(String mail, String password){

        def http = new HTTPBuilder(URL)
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

    def logout(){
        def http = new HTTPBuilder(URL)
        boolean result = false

        try {
            http.post(path: '/logout',  requestContentType: MediaType.APPLICATION_JSON){
                resp ->
                    def statusCode = resp.responseBase.statusline.statusCode
                    if(statusCode == 200) {
                    result = true
                }
            }
        } catch (HttpResponseException e) {
            println(e)
        }
        result
    }
    }

