package game.location

import game.Constants.statsList
import game.player.Person

case class Choice(name: String, requirements: List[Requirement] = List(), exam: Map[String, Int] = Map(),
                  result: Map[String, Map[String, String]]) {
  def examination(person: Person): Boolean =
    if (exam.nonEmpty)
      person.checkSuccess(exam.keys.head, exam.values.head)
    else
      true

  def isAvailable(person: Person): Boolean = false

  def getResult(person: Person): Unit =
    if (examination(person))
      applyResult(result("success"), person)
    else
      applyResult(result("unsuccessful"), person)


  def applyResult(res: Map[String, String], person: Person): Unit = {
    res.foreach {
      case (k, v) => k match {
        case "reputation" => person.reputation += v.toInt
        case "gold" => person.bag.gold(v.toInt)
        case "class" => person.className = v
        case "title_add" => null//person.addTitle // ++ List(v)
        case "title_drop" => null//person.titles +=
        //      case "reputation" => person.reputation += v.toInt
        //case "location" => changeLocation(v, ) // change main location
        case k if statsList.contains(k) => person.stats.appendStatByString(k, v.toInt)
        //       case k if statsList.contains(k)  => person.stats.appendStatByString(k, v.toInt)

      }
    }
  }

}
