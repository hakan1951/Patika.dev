package java101.locations.normalLocations;

import java101.gameStream.player.Player;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(player, "Safehouse");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safehouse, your health recovered.");
        System.out.println();
        return true;
    }

}
