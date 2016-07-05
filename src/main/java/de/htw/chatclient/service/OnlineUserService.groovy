package de.htw.chatclient.service

import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException


/**
 * @author vera on 21.06.16.
 */
class OnlineUserService {

    /**
     *
     * @return HashMap mit OnlineUsern
     */
    def getOnlineUser() {
        def http = new HTTPBuilder(Util.URL)
        HashMap<String, String> result
        try {
            http.get(path: '/onlineUser') { resp ->
                def jsonSlurper = new JsonSlurper()
                def content = resp.entity.content.text
                result = jsonSlurper.parseText(content)
            }
        } catch (HttpResponseException e) {
            println(e)
            result = new HashMap<>()
        }
        result
    }

}
