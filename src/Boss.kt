import kg.geeks.game.logic.RPGGame

class Boss(health: Int, damage: Int, name: String) : GameEntity(health, damage, name) {
    var defence: SuperAbility? = null

    fun chooseDefence() {
        val variantDefence = SuperAbility.values()
        defence = variantDefence[RPGGame.random.nextInt(variantDefence.size)]
    }

    fun attack(heroes: Array<Hero>) {
        for (hero in heroes) {
            if (hero.health > 0) {
                val damageDealt = if (hero is Magic && defence != SuperAbility.BLOCK_DAMAGE_REVERT) {
                    val block = (RPGGame.random.nextInt(2) + 1) * 5
                    maxOf(0, damage - block)
                } else {
                    damage
                }
                hero.health = maxOf(0, hero.health - damageDealt)
            }
        }
    }

    override fun toString(): String {
        return "BOSS ${super.toString()} defence: $defence"
    }
}
