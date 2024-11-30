package game.player


class Person(val name: String, val race: String, val sex: String) {
  val stats = new Stats()
  var className: String = ""
  //var religion: Stingt = "" // or int as Map key?
  var gold: Int = 30

  def newLevel() = ""
  def items() = ""
  def bag() = ""
  def reputation() = {}
}

object Person {

}
