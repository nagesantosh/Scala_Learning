package chapter3

object ControlStructuresSwitch extends App{
  
  var i = 4
    val month = i match {
    case 1  => "January"
    case 2  => "February"
    case 3  => "March"
    case 4  => "April"
    case 5  => "May"
    case 6  => "June"
    case 7  => "July"
    case 8  => "August"
    case 9  => "September"
    case 10 => "October"
    case 11 => "November"
    case 12 => "December"
    case _  => "Invalid month"
   }  
   println(month)
   
   //Matching multiple conditions with one case statement using pipe 
  var j = 4
  val evenOdd = j match {
    case 1 | 3 | 5 | 7 | 9 => println(s"$j is odd")
    case 2 | 4 | 6 | 8 | 10 => println(s"$j is even")
  }
   
  val cmd = "exit"
  cmd match {
    case "start" | "go" => println("starting")
    case "stop" | "quit" | "exit" => println("stopping")
    case _ => println("doing nothing")
  }
  
  //use a match expression as the body of a method
   
   def isTrue(a: Any) = a match {
    case 0 | "" => false
    case _ => true
  }
   
  i = 5465 
  i match {
  case 0 => println("1")
  case 1 => println("2")
  case default => println(s"You gave me: $default")
 }
}