import java.net._
import java.io._
import java.util._

import scala.collection.JavaConversions._

object FTPServer {

  def main(args: Array[String]) {
    val soc = new ServerSocket(5217)
    println("FTP Server Started on Port Number 5217")
    while (true) {
      println("Waiting for Connection ...")
      val t = new transferfile(soc.accept())
    }
  }
}

class transferfile(soc: Socket) extends Runnable {

  var ClientSoc: Socket = _

  var din: DataInputStream = _

  var dout: DataOutputStream = _

  try {
    ClientSoc = soc
    din = new DataInputStream(ClientSoc.getInputStream)
    dout = new DataOutputStream(ClientSoc.getOutputStream)
    println("FTP Client Connected ...")
    run()
    //start()
  } catch {
    case ex: Exception => 
  }

  def SendFile() {
    val filename = din.readUTF()
    val f = new File(filename)
    if (!f.exists()) {
      dout.writeUTF("File Not Found")
      return
    } else {
      dout.writeUTF("READY")
      val fin = new FileInputStream(f)
      var ch: Int = 0
      do {
        ch = fin.read()
        dout.writeUTF(String.valueOf(ch))
      } while (ch != -1);
      fin.close()
      dout.writeUTF("File Receive Successfully")
    }
  }

  def ReceiveFile() {
    val filename = din.readUTF()
    if (filename.compareTo("File not found") == 0) {
      return
    }
    val f = new File(filename)
    var option: String = null
    if (f.exists()) {
      dout.writeUTF("File Already Exists")
      option = din.readUTF()
    } else {
      dout.writeUTF("SendFile")
      option = "Y"
    }
    if (option.compareTo("Y") == 0) {
      val fout = new FileOutputStream(f)
      var ch: Int = 0
      var temp: String = null
      do {
        temp = din.readUTF()
        ch = java.lang.Integer.parseInt(temp)
        if (ch != -1) {
          fout.write(ch)
        }
      } while (ch != -1);
      fout.close()
      dout.writeUTF("File Send Successfully")
    } else {
      return
    }
  }

  def run() {
    while (true) {
      try {
        println("Waiting for Command ...")
        val Command = din.readUTF()
        if (Command.compareTo("GET") == 0) {
          println("\tGET Command Received ...")
          SendFile()
         
        } else if (Command.compareTo("SEND") == 0) {
          println("\tSEND Command Receiced ...")
          ReceiveFile()
         
        } else if (Command.compareTo("DISCONNECT") == 0) {
          println("\tDisconnect Command Received ...")
          System.exit(1)
        }
      } catch {
        case ex: Exception => 
      }
    }
  }
}

