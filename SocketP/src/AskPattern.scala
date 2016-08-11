import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern._
import scala.concurrent.duration._
import akka.util.Timeout
import scala.concurrent.ExecutionContext.Implicits.global

object AskPattern extends App {
  
  case object AskName
  case class NameResponse(name :String)
  
  class AskActor(val name:String) extends Actor{
    
    def receive = {
      
      case AskName => 
        Thread.sleep(10000)
        sender ! NameResponse(name)
    }
    def foo = println("Normal Method...")
    
  }
  
  val system = ActorSystem("SimpleSystem")
  val actor =   system.actorOf(Props(new AskActor("Pat")), "AskActor")
  
  implicit val timeout = Timeout(1.seconds)
  
  val answer = actor ? AskName
  answer.foreach (n => println(" Name is "+n))
  
  system.shutdown()
}