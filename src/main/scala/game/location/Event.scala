package game.location

import game.player.Person

/**
 * Событие - класс описывающий ситуации с которыми предстоит сталкиваться игроку
 * Инициализируется из JSON файлов
 * Содержит описание событий, требования к наступлению события и выборы, которые можно совершить
 * @param name имя события
 */
class Event(name: String, description: String, requirements: List[Requirement], choices: List[Choice]) {
  def makeChoice(person: Person): Unit = {
    // push to connector to make a choice from choises
    // run exam
    // realise result
    // return result to connector

  }        // Механика выбора
  def requirements(person: Person): Boolean = false // требования к персонажу, для наступления события
  // requirements


}
