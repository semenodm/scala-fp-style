package monads

trait Monad[F[_]] {
  def pure[A](value: A): F[A]

  def flatMap[A, B](value: F[A])(f: A => F[B]): F[B]

  def map[A, B](value: F[A])(f: A => B): F[B] = flatMap(value)(v => pure(f(v)))
}

object Monad {

  implicit class MonadSyntax[F[_], A](self: F[A]) {

    def pure(value: A)(implicit monad: Monad[F]): F[A] = monad.pure(value)

    def map[B](fn: A => B)(implicit monad: Monad[F]): F[B] = monad.map(self)(fn)

    def flatMap[B](fn: A => F[B])(implicit monad: Monad[F]): F[B] = monad.flatMap(self)(fn)
  }

}
