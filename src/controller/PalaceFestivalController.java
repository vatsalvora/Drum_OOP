package controller;

import model.PalaceFestival;
import model.Player;
import view.PalaceFestivalView;

import java.util.ArrayList;

/**
 * Created by devan on 4/21/14.
 */
public class PalaceFestivalController {


    private PalaceFestival palaceFestival;
    private PalaceFestivalView palaceFestivalView;
    private Player[] players;


    public PalaceFestivalController(PalaceFestival palaceFestival, Player[] players) {
        this.palaceFestival = palaceFestival;
        this.palaceFestivalView = new PalaceFestivalView();
        this.players = players;
    }

    public void render() {
        setPlayersAllowedToPlayPalaceFestival();
        palaceFestivalView.render(players, palaceFestival);
    }

    private void setPlayersAllowedToPlayPalaceFestival() {
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        for (Player player : players) {
            if (player.getCards().size() != 0) {
                playerArrayList.add(player);
            }
        }
        players = (Player[]) playerArrayList.toArray();
    }


}
