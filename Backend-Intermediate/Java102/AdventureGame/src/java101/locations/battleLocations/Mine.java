package java101.locations.battleLocations;

import java101.gameStream.player.Player;
import java101.items.awards.RandomAward;
import java101.obstacle.monsters.Snake;

public class Mine extends BattleLocation{
    public Mine(Player player) {
        super(player, "Mine", new Snake(), new RandomAward(),1,5);
    }

}
