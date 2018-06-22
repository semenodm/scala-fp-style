package functors.impl

import functors.Functor

case class Foo[A](value: A)

object Foo {
  implicit object FooFunctor extends Functor[Foo] {
    override def map[A, B](f: Foo[A])(fn: A => B): Foo[B] = Foo(fn(f.value))
  }
}

