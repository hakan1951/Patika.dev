package java101.locations.normalLocations;

import java101.gameStream.player.Player;
import java101.locations.Location;

public abstract class NormalLocation extends Location {
    public NormalLocation(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true; //true --> Not possible to die.
    }
}
