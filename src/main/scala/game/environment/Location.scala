package game.environment

import game.player.Person

/**
 * Локация - класс описывающий область с набором событий
 * Каждое действие вызывает несколько возможных событий
 * Инициализируется из JSON файлов
 */
class Location(val name: String, events: List[String] = List()) {


  def prepareEvents(person: Person): List[Event] = null//events.filter(_.requirements(person))


  def getEvents(person: Person): List[Event] = {
    import scala.util.Random
    var result = Random.shuffle(prepareEvents(person)).take(3)
    // TODO make always 3 choice
    result
  }


  def runEvent = {

  }
}

object Location {
  def changeLocation(name: String, locations: List[Location]): Location = locations.filter(_.name == name).head
}