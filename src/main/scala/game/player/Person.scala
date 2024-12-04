package game.player

import game.Constants.defaultStartGold


class Person(val name: String, val race: String, val sex: String) {
  val stats = new Stats()
  val bag = new Bag()
  var gold: Int = defaultStartGold

  def newLevel() = "" //?

  def reputation = null
  var className = null // ?
  var religion = null // or int as Map key?
  def damage: Int = stats.strength + bag.items.values.filter(_.equipped).map(_.damage).sum//+ bag.items.sum(_.damage) + bafs.filter - debafs.filter

  def checkSuccess(statName: String, threshold: Int): Boolean = {
    import scala.util.Random
    // TODO потестить в будущем момент диапазон и что он нам дает
    Random.between(0, 10) + stats.getStatByString(statName) > threshold
  }
}

object Person {

}