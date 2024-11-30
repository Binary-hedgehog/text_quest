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

  def curHp = _curHp
  def curHp(r: Int) = {
    _curHp += r
  }

  def curMp() = _curMp
  def curMp(r: Int) = {
    _curMp += r
  }

  def fullHp() = {
    _curHp = maxHp
  }

  def fullMp() = {
    _curMp = maxMp
  }

}