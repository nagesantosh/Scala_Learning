/*

object HelloWorld {
   def main(args: Array[String]) {
      println("Hello, world!")
   }
}*/
/*
    trait Similarity {
      def isSimilar(x: Any): Boolean
      def isNotSimilar(x: Any): Boolean = !isSimilar(x)
    }

    class Point(xc: Int, yc: Int) extends Similarity {
      var x: Int = xc
      var y: Int = yc
      def isSimilar(obj: Any) =
        obj.isInstanceOf[Point] &&
        obj.asInstanceOf[Point].x == x
    }
    object TraitsTest extends App {
      val p1 = new Point(2, 3)
      val p2 = new Point(2, 4)
      val p3 = new Point(3, 3)
      println(p1.isNotSimilar(p2))
      println(p1.isNotSimilar(p3))
      println(p1.isNotSimilar(2))
    }
*/

/*    object UnifiedTypes extends App {
      val set = new scala.collection.mutable.LinkedHashSet[Any]
      set += "This is a string"  // add a string
      set += 732                 // add a number
      set += 'c'                 // add a character
      set += true                // add a boolean value
      set += main _              // add the main function
      val iter: Iterator[Any] = set.iterator
      while (iter.hasNext) {
        println(iter.next.toString())
      }
    }

*/

/**
 * @author synerzip
 */
/*object TestApp {
  
  def main(args: Array[String]): Unit = {
   
    print("hiiii")
  }
  
}*/

/*import java.util.{Date,Locale}
import java.text.DateFormat
import java.text.DateFormat._

*//**
 * @author synerzip
 *//*
object IndiaDate {

  def main(args: Array[String]): Unit = {
    
    val now = new Date
    val df = getDateInstance(LONG,Locale.ENGLISH)
    println(df format now)
  }
}*/


/*object Timer {
    def oncePerSecond(callback: () => Unit) {
            while (true) { callback(); Thread sleep 1000 }
        }

    def timeFlies() {
          println("time flies like an arrow...")
    }
  
    def main(args: Array[String]) {
        oncePerSecond(timeFlies)
}
}*/