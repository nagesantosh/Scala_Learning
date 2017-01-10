package chapter1

object StrinUtilities extends App {
  
  println("******* Working with Strings *******")
  
  //concatenate strings
  
  val s1 = "Hello"
  val s2 = "World"
  
  println(s"String-1 ${s1}") //String-1 Hello
  println(s"String-2 ${s2}") //String-2 World
  
  val s3 = s1 + s2
  println(s"String-3 ${s3}") //String-3 HelloWorld
  
  //print string char by char
  
  s3.foreach(println) // H e l l o W o r l d
  
  
  for(c <- s3)println(c) //// H e l l o W o r l d

  //treating string as byte sequence
  
  s3.getBytes.foreach(println) //72 101 108 108 111 87 111 114 108 100
  
  //checking string equalities
  
  val s4 = "H" + "ello"
  val s5 = "hello"
  
  println(s4 == s5) //false
  println(s4.toLowerCase() == s5) //true
  
  //creating multiple lines string
  
  val s6 = """This is Scala
              It is functional language
              This is multiple line string""".stripMargin.replaceAll("\n", " ")

  println(s6) //This is Scala              It is functional language              This is multiple line string
  
  //splitting  string

  s6.split(" ").foreach(println)
  
  val s7 = "eggs, milk, butter, Coco Puffs"
  println(s7.split(",")) //[Ljava.lang.String;@1540e19d
  
  println(s7.split(",").map(_.trim)) //[Ljava.lang.String;@677327b6
  
  //string interpolation
  
  val s8 = "Santosh"
  val s9 = 10
  val s10 = 50.00
  
  println(s"${s8} is ${s9+1} years old and his weight is ${s10} pounds") //Santosh is 11 years old and his weight is 50.0 pounds

  println(f"${s8} is ${s9+1} years old and his weight is ${s10}%.3f pounds") //Santosh is 11 years old and his weight is 50.000 pounds
  
}