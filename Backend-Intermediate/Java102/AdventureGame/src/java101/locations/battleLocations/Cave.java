package java101.locations.battleLocations;

import java101.gameStream.player.Player;
import java101.obstacle.monsters.Zombie;

public class Cave extends BattleLocation{
    public Cave(Player player) { // Only 1 variable == Player.
        super(player, "Cave", new Zombie(), "Food", 3);
    }
}
