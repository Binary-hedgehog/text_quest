import connector.Connector
import game.environment.{Event, Location}
import game.environment.init.Initialisation.{initEvents, initLocations}
import game.player.Person
import helper.JsonHelper.getJsonValue

object Main {

  def main(args: Array[String]): Unit = {
    // init connector
    // init all Locations and Events
    // init other files (items, classes, races)
    // init Person
     // init all locations

//
//    val eventName = scala.io.StdIn.readLine()
//    println(eventName)
    val a = List(true, false, true).forall(_ == true)
    println(a)


  }

//  def foo(): Unit = {
//        var currentLocation: Location = changeLocation(StartLocationName, locations)
//        val person = new Person("John", "elf", "male") // implicit val?
//        val connector: Connector = null
//  }
  def init(): Unit = {
    val locations: List[Location] = initLocations()
    val events: List[Event] = initEvents()
  }
}