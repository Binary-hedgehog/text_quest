package game.player

import helper.JsonHelper.stringToMap

class Person(val name: String, val race: String, val sex: String) {
  val stats = new Stats()
  val bag = new Bag()
  var reputation = 0
  var className: String = null // ?
  var titles: List[String] = List()
  //var effects: List[Effect] = List ()
  //case class Effect(name: String, effectType: String, value: Int, var duration)
  def newLevel() = "" //?

  var religion = null // or int as Map key?
  def damage: Int = stats.strength + bag.items.values.filter(_.equipped).map(_.damage).sum//+ bag.items.sum(_.damage) + bafs.filter - debafs.filter

  def addTitle = {}
  def dropTitle = {}
  def checkSuccess(statName: String, threshold: Int): Boolean = {
    import scala.util.Random
    // TODO потестить в будущем момент диапазон и что он нам дает
    Random.between(0, 10) + stats.getStatByString(statName) > threshold
  }

  def checkReputation(reqRep: String): Boolean = {
    val some: Map[String, String] = stringToMap(reqRep)
    if (some("comparison") == "less")
      this.reputation < some("value").toInt
    else
      this.reputation > some("value").toInt
  }
}

object Person {


}

