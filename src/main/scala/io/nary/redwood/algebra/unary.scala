package io.nary.redwood.algebra

import scalaz.{Free, Monad}

object unary {

  trait UnaryOp[T, A]

  object UnaryOp {
    final case class Rename[T](tree: T, guid: String, name: String) extends UnaryOp[T, Unit]
    final case class Delete[T](tree: T, guid: String) extends UnaryOp[T, Unit]
    final case class GetBytes[T](tree: T, guid: String) extends UnaryOp[T, Array[Byte]]
  }

  import UnaryOp._

  type Unary[T, A] = Free[UnaryOp[T, ?], A]
  implicit def UnaryMonad[T]: Monad[Unary[T, ?]] = Free.freeMonad[UnaryOp[T, ?]]

  def rename[T](tree: T, guid: String, name: String): Free[UnaryOp[T, ?], Unit] =
    Free.liftF[UnaryOp[T, ?], Unit](Rename[T](tree, guid, name))

  def delete[T](tree: T, guid: String): Free[UnaryOp[T, ?], Unit] =
    Free.liftF[UnaryOp[T, ?], Unit](Delete[T](tree, guid))

  def getBytes[T](tree: T, guid: String): Free[UnaryOp[T, ?], Array[Byte]] =
    Free.liftF[UnaryOp[T, ?], Array[Byte]](GetBytes[T](tree, guid))
}
