import java.net._
import java.io._
import java.util._

import scala.collection.JavaConversions._

object FTPClient {

  def main(args: Array[String]) {
    val soc = new Socket("127.0.0.1", 5217)
    val t = new transferfileClient(soc)
    t.displayMenu()
  }
}

class transferfileClient(soc: Socket) {

  var ClientSoc: Socket = _

  var din: DataInputStream = _

  var dout: DataOutputStream = _

  var br: BufferedReader = _

  try {
    ClientSoc = soc
    din = new DataInputStream(ClientSoc.getInputStream)
    dout = new DataOutputStream(ClientSoc.getOutputStream)
    br = new BufferedReader(new InputStreamReader(System.in))
  } catch {
    case ex: Exception => 
  }

  def SendFile() {
    var filename: String = null
    System.out.print("Enter File Name :")
    filename = br.readLine()
    val f = new File(filename)
    if (!f.exists()) {
      println("File not Exists...")
      dout.writeUTF("File not found")
      return
    }
    dout.writeUTF(filename)
    val msgFromServer = din.readUTF()
    if (msgFromServer.compareTo("File Already Exists") == 0) {
      var Option: String = null
      println("File Already Exists. Want to OverWrite (Y/N) ?")
      Option = br.readLine()
      if (Option == "Y") {
        dout.writeUTF("Y")
      } else {
        dout.writeUTF("N")
        return
      }
    }
    println("Sending File ...")
    val fin = new FileInputStream(f)
    var ch: Int = 0
    do {
      ch = fin.read()
      dout.writeUTF(String.valueOf(ch))
    } while (ch != -1);
    fin.close()
    println(din.readUTF())
  }

  def ReceiveFile() {
    var fileName: String = null
    System.out.print("Enter File Name :")
    fileName = br.readLine()
    dout.writeUTF(fileName)
    val msgFromServer = din.readUTF()
    if (msgFromServer.compareTo("File Not Found") == 0) {
      println("File not found on Server ...")
      return
    } else if (msgFromServer.compareTo("READY") == 0) {
      println("Receiving File ...")
      val f = new File(fileName)
      if (f.exists()) {
        var Option: String = null
        println("File Already Exists. Want to OverWrite (Y/N) ?")
        Option = br.readLine()
        if (Option == "N") {
          dout.flush()
          return
        }
      }
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
      println(din.readUTF())
    }
  }

  def displayMenu() {
    while (true) {
      println("[ MENU ]")
      println("1. Send File")
      println("2. Receive File")
      println("3. Exit")
      System.out.print("\nEnter Choice :")
      var choice: Int = 0
      choice = java.lang.Integer.parseInt(br.readLine())
      if (choice == 1) {
        dout.writeUTF("SEND")
        SendFile()
      } else if (choice == 2) {
        dout.writeUTF("GET")
        ReceiveFile()
      } else {
        dout.writeUTF("DISCONNECT")
        System.exit(1)
      }
    }
  }
}

