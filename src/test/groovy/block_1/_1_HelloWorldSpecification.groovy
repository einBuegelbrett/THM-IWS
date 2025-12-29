package block_1

import spock.lang.Specification

class _1_HelloWorldSpecification extends Specification{
    def "should return hello world message"() {
        expect:
        _1_HelloWorld.message() == "Hello world!"
    }
}
