package functors

trait Functor[F[_]] {
  def map[A, B](f: F[A])(fn: A => B): F[B]
}

object Functor {
  implicit class FunctorSyntax[F[_], A](self: F[A]) {
    def map[B](fn: A => B)(implicit functor: Functor[F]): F[B] = functor.map(self)(fn)
  }
}
