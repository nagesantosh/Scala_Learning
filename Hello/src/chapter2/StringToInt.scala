package chapter2

object StringToInt extends App{
  
    println("******** Numerical operations in Scala ********")
  
  //String to int and other data types
  
  val int = "100".toInt
  println(s"String 100 to Integer :${int}")
    
  val dub = "100".toDouble
  println(s"String 100 to Integer :${dub}")
    
  val flot = "100".toFloat
  println(s"String 100 to Integer :${flot}")
    
  // scala doesn`t support incremental operators like ++ & -- 

  var a =10;
  println(s"Value of a is ${a}")  
  
  a+=1;
  println(s"Incremented value of a is ${a}")
  
  // generating random numbers 
  
  var ranNo = scala.util.Random
  
  println(s"Randaom number generated is :${ranNo}")
  
  println(s"Randaom number generated is :${ranNo.nextInt}")
  
  println(s"Randaom number generated is :${ranNo.nextInt(100)}")
  
  // generating random characters
  
  println(s"Randaom number generated is :${ranNo.nextPrintableChar}")
  
  
  var range = 0 to ranNo.nextInt(100)
  println(range)  
}