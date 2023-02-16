package java101.locations.battleLocations;

import java101.gameStream.player.Player;
import java101.obstacle.monsters.Bear;
import java101.obstacle.monsters.Zombie;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "River", new Bear(), "Water",3);
    }

}
