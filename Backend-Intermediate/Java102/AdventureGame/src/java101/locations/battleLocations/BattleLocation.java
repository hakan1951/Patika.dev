package java101.locations.battleLocations;

import java101.gameStream.player.Player;
import java101.locations.Location;
import java101.obstacle.Obstacle;

public class BattleLocation extends Location {
    private Obstacle obstacle;
    public BattleLocation(Player player, String name) {
        super(player, name);
    }

    //TODO-Obstacles.
    @Override
    public boolean onLocation() {
        return false;
    }

    public void fight() {

    }

}
