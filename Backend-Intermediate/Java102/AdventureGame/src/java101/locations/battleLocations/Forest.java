package java101.locations.battleLocations;

import java101.gameStream.player.Player;
import java101.items.awards.Firewood;
import java101.obstacle.monsters.Vampire;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), new Firewood(), 1,3);
    }
}
