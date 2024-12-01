import connector.Connector
import game.location.Location
import game.player.Person

object Main {
  def main(args: Array[String]): Unit = {
    // init connector
    // init all Locations and Events
    // init other files (items, classes, races)
    // init Person
    val locations = List()
    var currentLocation = new Location()
    val person = new Person("John", "elf", "male")
    val connector: Connector = null



    val eventName = scala.io.StdIn.readLine()
    println(eventName)
  }
}