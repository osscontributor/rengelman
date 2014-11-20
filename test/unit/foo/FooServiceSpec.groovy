package foo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FooService)
@Mock([Bar, Foo])
class FooServiceSpec extends Specification {

    void "test something"() {
        given:
        def bar = new Bar(name: 'first').save()
        def bar2 = new Bar(name: 'second').save()

        new Foo(bar: bar).save()
        new Foo(bar: bar2).save()
        new Foo(bar: null).save()

        when:
        List<Foo> foos = service.list()

        then:
        foos.size() == 1
    }
}
