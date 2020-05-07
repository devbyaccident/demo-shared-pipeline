@Grab('io.github.http-builder-ng:http-builder-ng-core:0.16.1')
import static groovyx.net.http.HttpBuilder.configure
 
def call(def uri) {

    def http = configure {
        request.uri = "${uri}"
    }.get()

}