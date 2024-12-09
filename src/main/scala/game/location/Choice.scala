package game.location

import game.player.Person

case class Choice(name: String, requirements: List[Requirement], exam: Map[String, Int], result: Map[String, Map[String, Any]]) {
  def examination(person: Person): Boolean = person.checkSuccess(exam.keys.head, exam.values.head)

  def isAvailable(person: Person): Boolean = false

  def getResult(person: Person): Unit =
    if (examination(person))
      applyResult(result("success"), person)
    else
      applyResult(result("unsuccessful"), person)




  def applyResult(res: Map[String, Any], person: Person): Unit = {
    res.keys.foreach {
      case key@"reputation" => person.reputation += res(key).toString.toInt
      case key@"gold"       => person.gold += res(key).toString.toInt
      case key@"class"      => person.className = res(key).toString
      case key@"title_add"  => person.titles ++ List(res(key).toString)
//      case key@"title_drop" => person.titles +=
//      case key@"reputation" => person.reputation += res(key).toString.toInt
      case key@_            => person.stats.appendStatByString(key, res(key).toString.toInt)
    }
  }
}
