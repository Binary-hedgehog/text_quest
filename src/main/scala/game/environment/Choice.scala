package game.environment

import game.Constants.statsList
import game.player.Person

case class Choice(name: String, requirements: Requirement, exam: Map[String, Int],
                  success: Map[String, String], failure: Map[String, String]) {
  def examination(person: Person): Boolean =
    if (exam.nonEmpty)
      person.checkSuccess(exam.keys.head, exam.values.head)
    else
      true

  def isAvailable(person: Person): Boolean = requirements.isAvailable(person)


  def getResult(person: Person): Unit =
    if (examination(person))
      applyResult(success, person)
    else
      applyResult(failure, person)


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
