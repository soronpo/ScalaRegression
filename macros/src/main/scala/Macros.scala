import scala.reflect.macros.whitebox.Context

trait Foo
trait FooW[W] extends Foo {
  def + [R](that : FooW[R]) = ???
}
object Foo {
  final implicit class StringSyntax(val sc: StringContext) extends AnyVal {
    def w[W](args: Foo*) : FooW[W] = macro Macro.fooStringInterpolator
  }

}

object Macro {
   def fooStringInterpolator(c: Context)(args: c.Expr[Foo]*): c.Tree = {
    import c.universe._
     q"new FooW[Int]{}"
  }
}
