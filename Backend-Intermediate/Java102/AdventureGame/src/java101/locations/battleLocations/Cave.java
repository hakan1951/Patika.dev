package java101.locations.battleLocations;

import java101.gameStream.player.Player;
import java101.items.awards.Food;
import java101.obstacle.monsters.Zombie;

public class Cave extends BattleLocation{
    public Cave(Player player) { // Only 1 variable == Player.
        super(player, "Cave", new Zombie(), new Food(), 1,3);
    }
}
