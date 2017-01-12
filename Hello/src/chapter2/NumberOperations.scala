package chapter2

object NumberOperations extends App{
  
  println("******** Numerical operations in Scala ********")
  
  //Creating a Range, List, or Array of Numbers
  
  val r1 = 1 to 10
  println(r1)          //Range(1, 3, 5, 7, 9)
  
  val r2 = 1 to 10 by 2
  println(r2)          //Range(1, 4, 7, 10)
  
  val r3 = 1 to 10 by 3
  println(r3)          //3.141592653589793
  
  //Numbers to array and list
  val r4 = (1 to 10).toArray
  val r5 = (1 to 10).toList
  
  //Formatting Numbers and Currency
  
  val pi = scala.math.Pi
  println(pi)
  println(f"$pi%1.5f")   //3.14159
  
  val formatter = java.text.NumberFormat.getIntegerInstance
  
  println(formatter.format(100000000))    //100,000,000
  
  val locale = new java.util.Locale("de", "DE")
  val formatter1 = java.text.NumberFormat.getIntegerInstance(locale)
  println(formatter1.format(10000000))
  
  val formatter2 = java.text.NumberFormat.getCurrencyInstance
  println(formatter2.format(10000000))
  
  println(formatter2.format(123.456789))
  
}