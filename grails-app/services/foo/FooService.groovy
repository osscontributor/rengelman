package foo

class FooService {

 List<Foo> list() {
    Foo.where {
      bar?.name == 'first'
    }.list()
  }
}
