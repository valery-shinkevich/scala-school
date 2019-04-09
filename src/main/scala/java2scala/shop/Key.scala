package java2scala.shop
import java.util.UUID

trait Key[A] {
  def key(a: A): UUID
  def notFound(uuid: UUID): Throwable
}

object Key {
  def notFound[A](uuid: UUID)(implicit key: Key[A]): Throwable = key.notFound(uuid)
  def key[A](a: A)(implicit key: Key[A]): UUID                 = key.key(a)
}