package java101.locations.normalLocations;

import java101.gameStream.player.Player;
import java101.items.awards.Award;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(player, "Safehouse");
    }

    @Override
    public boolean onLocation() {
        if (isFinish()){
            System.out.print("------------------------------");
            System.out.format("Congratulations, %s. You completed all the challenges. You win!", this.getPlayer().getPlayerName());
            System.out.print("------------------------------");
            return false;
        }
        System.out.println("You are in safehouse, your health recovered.");
        this.getPlayer().setHp(this.getPlayer().getDefaultHp());
        return true;
    }
    public boolean isFinish(){
        for (Award a: Award.awards()){
            if (this.getPlayer().getInventory().isContainsAward(a)){
                return false;
            }
        }
        return true;
    }

}
