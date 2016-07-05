package de.htw.chatclient.service

import de.htw.chatclient.views.Store
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException

import javax.ws.rs.core.MediaType

/**
 * @author vera on 20.06.16.
 */
class LogoutService {

    /**
     *
     * @return true , wenn user erfolgreich ausgelogt, ansonsten false
     */
    def logout() {
        def http = new HTTPBuilder(Util.URL)
        boolean result = false
        try {
            http.post(path: '/logout', requestContentType: MediaType.APPLICATION_JSON) {
                resp ->
                    def statusCode = resp.responseBase.statusline.statusCode
                    if (statusCode == 200) {
                        def messageService = new MessageService()
                        messageService.clearMessages()
                        Store.ownerMail = null
                        Store.dialogPartnerMail = null
                        result = true
                    }
            }
        } catch (HttpResponseException e) {
            println(e)
        }
        result
    }
}
