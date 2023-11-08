import scala.collection.mutable.Stack
import scala.collection.immutable.Vector

object Solution {

    sealed trait Path
    case object Root extends Path
    case object Slash extends Path
    case object Dot extends Path
    case object DotDot extends Path
    case class DirOrFile(name: String) extends Path

    implicit class PathOps(path: Path) {
        def asString: String = path match {
            case Root => "/"
            case Slash => "/"
            case Dot => "."
            case DotDot => ".."
            case DirOrFile(name) => s"$name"
        }
    }

    // Given a path, splits it and encodes it
    def parseStringPath(path: String): Vector[Path] = {
        val parts: Array[String] = path.split("/")

        parts.foldLeft(Vector.empty[Path]) {
            (result, part) => part match {
                case "" if (result.isEmpty) => result :+ Root
                case "" => result :+ Slash
                case "." =>  result :+ Dot
                case ".." => result :+ DotDot
                case _ => result :+ DirOrFile(part)
            }
        }
    }

    def simplifyPath(path: String): String = {
        val parsed: Vector[Path] = parseStringPath(path)
        var stack = Stack.empty[Path]
        
        // println(s"$parsed")

        for (pathElement <- parsed) {
            pathElement match {
                case DotDot if (stack.top != Root ) => stack.pop() 
                case Root => stack.push(Root)
                case DirOrFile(name) => stack.push(pathElement)
                case _ => ()
            }
        }

        // println(s"$stack")

        if (stack.size == 0)
            "/"
        else if (stack.size == 1)
            stack.map(_.asString).reverse.mkString("/")
        else 
            stack.map(_.asString).reverse.mkString("/").drop(1)
        
    }
}