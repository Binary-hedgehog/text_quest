import connector.Connector
import game.Constants.StartLocationName
import game.location.Location
import game.location.Location.changeLocation
import game.player.Person

object Main {

  def main(args: Array[String]): Unit = {
    // init connector
    // init all Locations and Events
    // init other files (items, classes, races)
    // init Person
     // init all locations
    val locations: List[Location] = List()
    var currentLocation: Location = changeLocation(StartLocationName, locations)
    val person = new Person("John", "elf", "male") // implicit val?
    val connector: Connector = null

    val eventName = scala.io.StdIn.readLine()
    println(eventName)
  }
}