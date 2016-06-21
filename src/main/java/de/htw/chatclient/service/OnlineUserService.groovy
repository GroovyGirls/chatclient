package de.htw.chatclient.service

import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException

import javax.ws.rs.core.MediaType

/**
 * @author vera on 21.06.16.
 */
class OnlineUserService {

    def getOnlineUser() {

        def http = new HTTPBuilder(Util.URL)

        HashMap<String, String> result

        try {
            http.get(path: '/onlineUser') { resp ->

                def jsonSlurper = new JsonSlurper()
                def content = resp.entity.content.text
                result = jsonSlurper.parseText(content)
                // TODO anhand des statusCode booelan an Oberfläche übergeben

            }
        } catch (HttpResponseException e) {
            println(e)
            result = new HashMap<>()
        }
        result
    }

}
