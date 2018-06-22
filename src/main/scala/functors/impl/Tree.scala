package functors.impl

import functors.Functor

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A])
  extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object Tree {

  implicit object TreeFunctor extends Functor[Tree] {
    override def map[A, B](f: Tree[A])(fn: A => B): Tree[B] = f match {
      case Branch(left, right) => Branch(map(left)(fn), map(right)(fn))
      case Leaf(value) => Leaf(fn(value))
    }
  }
}