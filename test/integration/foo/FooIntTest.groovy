package foo

class FooIntTest extends GroovyTestCase {

  FooService fooService

  void testList() {
    Bar bar = new Bar(name: 'first').save()
    Bar bar2 = new Bar(name: 'second').save()

    Foo foo = new Foo(bar: bar).save()
    Foo foo2 = new Foo(bar: bar2).save()
    Foo foo3 = new Foo(bar: null).save()

    List<Foo> foos = fooService.list()

    assert foos.size() == 1
  }
}