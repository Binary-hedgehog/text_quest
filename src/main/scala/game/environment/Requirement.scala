package game.environment

import game.Constants.statsList
import game.player.Person
import game.player.Person.checkReputation

case class Requirement(req: Map[String, String]) {
  def isAvailable(person: Person): Boolean =
    req.map { case (k, v) =>
      k match {
        case "title" => person.titles.contains(k)
        case k if statsList.contains(k) => false // todo
        case "gold" => person.bag.gold >= v.toInt
        case "race" => person.race == v
        case "reputation" => checkReputation(person, v)
      }
    }.forall(_ == true)
}
