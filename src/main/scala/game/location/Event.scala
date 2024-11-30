package game.location

import game.player.Person

/**
 * Событие - класс описывающий ситуации с которыми предстоит сталкиваться игроку
 * Инициализируется из JSON файлов
 * Содержит описание событий, требования к наступлению события и выборы, которые можно совершить
 * @param name имя события
 */
class Event(val name: String) {
  def description: String = ""  // получение текстового описания событий
  def choosen(): Unit  = {}        // Механика выбора
  def requirements(person: Person): Boolean = false // требования к персонажу, для наступления события
}