object Test {
  import Foo._
  val a = w"2"
  val b = w"1"
  a + b //compiles

  w"1" + w"2" //compilation error
}