package chapter1

object PatternMatch extends App {
  
  println("********** Scala Pattern Matching in String **********")
  
  //finding numerical pattern in given string
  
  val regx = "[0-9]+".r
  val address = "100 kothrud City pride 877"
  val address1 = "Revolution Mall, BigBazar near kothrud City pride"
  
  val matcher = regx.findAllIn(address).toArray
  matcher.foreach(println)                     // 100 877
  
  
  val matcher1 = regx.findAllIn(address1)
  matcher1.foreach(println)                     //none
  
  val address2 = regx.replaceAllIn(address, "x")
  println(address2)                              //x kothrud City pride x

  val pattern = "([0-9]+) ([A-Za-z]+)".r
  val fruits = "100 Apples 200 Mangoes 300 Orange"
  val results = pattern.findAllIn(fruits).toArray
  results.foreach(println) //100 Apples
                           //200 Mangoes
                           //300 Orange
  
  //Accessing a Character in a String
  
  println("Welcome Jandagi".charAt(2)) // l

  println("Welcome Jandagi"(2))        // l
  
  println("Welcome Jandagi"apply(2))   // l
  
  
  //add your own methods to the String class
  
  implicit class StringImprovements(val s: String) {

    def increment = s.map(c => (c + 1).toChar)

  }

  val result = "RXMDQYHO".increment
  println("Applied increment result "+result)

}