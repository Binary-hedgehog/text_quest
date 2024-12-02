package game.player

/**
 * Класс описывающий характеристики персонажа
 * @param maxHp
 * @param maxMp
 * @param strength
 * @param dextry
 * @param intelligence
 * @param lucky
 */
case class Stats(var maxHp: Int = 10, var maxMp: Int = 1, var strength: Int = 1,
                 var dexterity: Int = 1, var intelligence: Int = 1, var lucky: Int = 1) {

  private var _curHp: Int = maxHp
  private var _curMp: Int = maxMp
  def curHp: Int = _curHp
  def curHp(r: Int): Unit = _curHp += r
  def curMp: Int = _curMp
  def curMp(r: Int): Unit = _curMp += r
  def fullHp(): Unit = _curHp = maxHp
  def fullMp(): Unit = _curMp = maxMp

  def getStatByString(name: String): Int =
    name match {
      case "strength" => this.strength
      case "dexterity" => this.dexterity
      case "intelligence" => this.intelligence
      case "lucky" => this.lucky
    }
}