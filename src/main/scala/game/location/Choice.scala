package game.location

import game.player.Person

case class Choice(name: String, requirements: List[Requirement], exam: Map[String, Int], result: Map[String, Map[String, Int]]) {
  def examination(person: Person): Boolean = person.checkSuccess(exam.keys.head, exam.values.head)
  def isAvailable(person: Person): Boolean = false
  def getResult(person: Person): Unit = {
//    if (examination(person))
//      result

  }
}
