package scalikejdbc

import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context
import scalikejdbc._

object AutoApply {

  def apply_impl[A: c.WeakTypeTag](c: Context)(rn: c.Expr[ResultName[A]], rs: c.Expr[WrappedResultSet]): c.Expr[A] = {
    import c.universe._
    val tpe = weakTypeTag[A].tpe
    val declarations = tpe.decls
    val ctor = declarations.collectFirst { case m: MethodSymbol if m.isPrimaryConstructor => m }.get
    val params = ctor.paramLists.head
    val constParams = params.map { field => 
      val name = field.name
      val returnType = tpe.decl(field.name).typeSignature
      q"$rs.get($rn.field(${name.decodedName.toString}))"
    }
    c.Expr[A](q"new ${tpe}(..$constParams)")
  }

  def apply[A](rn: ResultName[A], rs: WrappedResultSet): A = macro apply_impl[A]

}
