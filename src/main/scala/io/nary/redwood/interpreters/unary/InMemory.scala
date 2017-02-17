package io.nary.redwood

package interpreters
package unary

import algebra.unary._

import scalaz.{Tree, ~>}
import scalaz.Tree._

object InMemory extends (UnaryOp[Tree, ?] ~> Tree) {
  import UnaryOp._

  override def apply[A](fa: UnaryOp[Tree, A]): Tree[A] = fa match {
    case Rename(tree, guid, name) ⇒ 
  }
}
