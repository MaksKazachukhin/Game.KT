package kg.geeks.game.logic

import Boss
import Hero
import Magic
import Warrior
import kg.geeks.game.players.Medic
import kotlin.random.Random

object RPGGame {
    val random = Random
    private var roundNumber = 0

    fun startGame() {
        val boss = Boss(1000, 50, "Skeleton")
        val heroes = arrayOf(
            Medic(250, 5, "Dumbledor", 15),
            Warrior(290, 15, "Ahiles"),
            Magic(270, 10, "Skymag")
        )

        showStatistics(boss, heroes)
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes)
        }
    }

    private fun playRound(boss: Boss, heroes: Array<Hero>) {
        roundNumber++
        println("\nROUND $roundNumber -----------------")
        boss.chooseDefence()
        boss.attack(heroes)

        for (hero in heroes) {
            if (hero.health > 0 && boss.health > 0 && hero.ability != boss.defence) {
                hero.attack(boss)
                hero.applySuperPower(boss, heroes)
            }
        }
        showStatistics(boss, heroes)
    }

    private fun isGameOver(boss: Boss, heroes: Array<Hero>): Boolean {
        if (boss.health <= 0) {
            println("Heroes won!!!")
            return true
        }
        if (heroes.all { it.health <= 0 }) {
            println("Boss won!!!")
            return true
        }
        return false
    }

    private fun showStatistics(boss: Boss, heroes: Array<Hero>) {
        println(boss)
        heroes.forEach { println(it) }
    }
}
