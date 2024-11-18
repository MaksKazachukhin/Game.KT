abstract class GameEntity(
    var health: Int,
    var damage: Int,
    var name: String
) {
    override fun toString(): String {
        return "$name health: $health damage: $damage"
    }
}
