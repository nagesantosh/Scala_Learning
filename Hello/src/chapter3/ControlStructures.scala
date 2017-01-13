package chapter3

import util.control.Breaks._

object NumberOperations extends App{
  
  println("******** Control Structures in Scala ********")
  
  val fruits = List("Apple","Mango","Banana","Pineapple","Orange","Mosambi")
  for(a <- fruits) println(a)
  
  fruits.foreach(println)

  for(i<-0 until fruits.length)
  {
    println(s"$i is ${fruits(i)}")
  }
  println("**********************************************")
  for((e,counts)<-fruits.zipWithIndex){
    println(s"$counts is $e")
  }
  
  //multiple line loop
  
  for{
    i <- 1 to 10
    j <- 11 to 20
  }println(s"i = $i and j = $j")
  
  
  //even numbers using multi line loop
  
  for{
    i <- 1 to 10
    if i%2 == 0
  }println(s"$i is even")
  
  for {
    i <- 1 to 10
    if i > 3
    if i < 6
    if i % 2 == 0
  } println(i)
  
  //Implementing break and continue
  
  println("\n=== BREAK EXAMPLE ===")
   
  breakable {
			for (i <- 1 to 10) {
					println(i)
			if (i > 4) 
				break // break out of the for loop
	}
}
  
  println("\n=== CONTINUE EXAMPLE ===")
  val searchMe = "peter piper picked a peck of pickled peppers"
  var numPs = 0
  for (i <- 0 until searchMe.length) {
      breakable {
          if (searchMe.charAt(i) != 'p') {
                break // break out of the 'breakable', continue the outside loop
          } else {
              numPs += 1
          }
      }
  }
  println("Found " + numPs + " p's in the string.")
}