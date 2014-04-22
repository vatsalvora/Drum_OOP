package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vatsal on 4/22/2014.
 */
public class CheckHighestRankingDeveloper {
    private List<Space> area;
    private Color playerColor;
    public CheckHighestRankingDeveloper(List<Space> area, Color playerColor){
        this.area = area;
        this.playerColor = playerColor;
    }
    public boolean higestRanking(){
        int maxHeight = 0;
        boolean tie = false;
        Developer max = null;
        for(Space s : area){
            HexSpace h = (HexSpace)s;
            if(h.hasDeveloper()){
                if(h.getHeight()>maxHeight){
                    maxHeight = h.getHeight();
                    max = h.getDeveloper();
                    tie = false;
                }
                if(h.getHeight() == maxHeight){
                    tie = true;
                }
            }
        }
        if(tie) return false;
        if(max == null) return false;
        if(!max.getViewColor().equals(playerColor)) return false;
        return true;
    }
}
