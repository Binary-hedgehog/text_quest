package game.location

import game.player.Person

/**
 * Локация - класс описывающий область с набором событий
 * Каждое действие вызывает несколько возможных событий
 * Инициализируется из JSON файлов
 */
class Location() {
  var events: List[Event] = List()

  def prepareEvents(person: Person): List[Event] = events.filter(_.requirements(person))


  def getEvents(person: Person): List[Event] = {
    import scala.util.Random
    var result = Random.shuffle(prepareEvents(person)).take(3)
    // TODO make always 3 choice
    result
  }


  def runEvent = {

  }
}
