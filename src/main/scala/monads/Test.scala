package monads

import Monad._
import impl.Foo, Foo._

object Test extends App {
  def tupleTC[F[_] : Monad, A, B](fa: F[A], fb: F[B]): F[(A, B)] = {
    fa.flatMap { a => fb.map(b => (a, b)) }
  }


  println(tupleTC(Foo(10), Foo("ten")))
}

