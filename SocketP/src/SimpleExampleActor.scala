import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

object SimpleExampleActor extends App {
  
  class SimpleActor extends Actor{
    
    def receive = {
      
      case s:String => println("String :"+s)
      
      case i:Int => println("Integer :"+i)
      
    }
    def foo = println("Normal Method...")
    
  }
  
  val system = ActorSystem("SimpleSystem")
  val actor =   system.actorOf(Props[SimpleActor], "SimpleActor")
  println("Before String")
  actor ! "Hi Santosh"
  println("After String")
  actor ! 45
  println("After Integer")
  actor ! 'a'
  println("After Character")
  system.shutdown()
}