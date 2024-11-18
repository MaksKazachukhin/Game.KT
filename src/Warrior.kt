import Boss
import kg.geeks.game.logic.RPGGame

class Warrior(health: Int, damage: Int, name: String) : Hero(health, damage, name, SuperAbility.CRITICAL_DAMAGE) {
    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        val coefficient = RPGGame.random.nextInt(4) + 2
        val criticalDamage = coefficient * this.damage
        boss.health = maxOf(0, boss.health - criticalDamage)
        println("Warrior $name CRIT_DAMAGE $criticalDamage")
    }
}
