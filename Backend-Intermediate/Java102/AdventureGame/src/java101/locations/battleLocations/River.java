package java101.locations.battleLocations;

import java101.gameStream.player.Player;
import java101.items.awards.Water;
import java101.obstacle.monsters.Bear;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "River", new Bear(), new Water(),1,3);
    }

}
