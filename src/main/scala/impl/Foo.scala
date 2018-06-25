package impl

import functors.Functor
import monads.Monad

case class Foo[A](value: A)

object Foo {

  implicit object FooFunctor extends Functor[Foo] {
    override def map[A, B](f: Foo[A])(fn: A => B): Foo[B] = Foo(fn(f.value))
  }

  implicit object FooMonad extends Monad[Foo] {
    override def pure[A](value: A): Foo[A] = Foo(value)

    override def flatMap[A, B](value: Foo[A])(f: A => Foo[B]): Foo[B] = value match {
      case Foo(v) => f(v)
    }
  }

}

