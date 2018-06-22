package functors

import functors.impl.Foo

object Test extends App {

  val fa = Foo[Int](100)
  import Functor._
  import impl._

  println(fa.map(_ + 100))


  val tree :Tree[Int] = Branch(Leaf(10), Leaf(20))



  println(tree.map(i => i * i))
}
