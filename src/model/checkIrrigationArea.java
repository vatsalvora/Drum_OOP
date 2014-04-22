package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Vatsal on 4/22/2014.
 */
public class CheckIrrigationArea {
    private Tile check;
    private List<Space> area;
    private Space start;
    private int points;
    public CheckIrrigationArea(Space start){
        points = 3;
        check = new IrrigationTile(0);
        area = new ArrayList<Space>();
        this.start = start;
    }
    public List<Space> getArea(){
        return area;
    }
    public int famePoints(){
        return points;
    }
    public boolean calcArea(){
        List<Space> visited = new LinkedList<Space>();
        Queue<Space> bfs = new LinkedList<Space>();
        bfs.add(start);
        while(!bfs.isEmpty()){
            Space curr = bfs.poll();
            visited.add(curr);
            area.add(curr);
            if(!visited.contains(curr)){
                if(((HexSpace)curr).getHeight()<=0) return false;
                else {
                    Tile t = curr.getTopTile();
                    if (t.compareTo(check)) {
                        points +=3;
                        Space[] neighbors = curr.getNeighbors();
                        for (Space s : neighbors) {
                            if (!s.equals(curr) && !visited.contains(s)) bfs.add(s);
                        }
                    }
                }
            }

        }
        return true;
    }
}
