package functors

import impl.{Branch, Foo, Leaf, Tree}
import cats.syntax.functor._

object Test extends App {


  def doTestCustomFunctor: Unit = {
    val fa = Foo[Int](100)
    import Functor.FunctorSyntax

    println(fa.map(_ + 100))
  }

  def doTestCatsFunctor: Unit = {
    val tree: Tree[Int] = Branch(Leaf(10), Leaf(20))


    import impl.Tree._

    println(tree.map(i => i * i))
  }


  doTestCustomFunctor
  doTestCatsFunctor


}
