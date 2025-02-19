package kg.geeks.game.players

import Boss
import Hero

class Medic(health: Int, damage: Int, name: String,
            private var healPoints: Int) : Hero(health, damage, name, SuperAbility.HEAL) {

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        for (hero in heroes) {
            if (hero.health > 0 && hero != this) {
                hero.health += healPoints
                println("$name healed ${hero.name} by $healPoints points")
            }
        }
    }
}
