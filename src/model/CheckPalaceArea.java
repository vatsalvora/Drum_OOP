package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Vatsal on 4/22/2014.
 */
public class CheckPalaceArea {
    private Tile check;
    private List<Space> area;
    private Space start;
    public CheckPalaceArea(Space start){
        check = new VillageTile(0, Color.BLACK);
        area = new ArrayList<Space>();
        this.start = start;
    }
    public List<Space> getArea(){
        return area;
    }
    public boolean calcArea(){
        List<Space> visited = new LinkedList<Space>();
        Queue<Space> bfs = new LinkedList<Space>();

        visited.add(start);
        Space [] n = start.getNeighbors();
        for (Space s : n) {
            HexSpace h = (HexSpace)s;
            bfs.offer(s);
        }
        System.out.println("BFS Size:" + bfs.size());
        while(!bfs.isEmpty()){
            Space curr = bfs.poll();
            if(!visited.contains(curr)){
                visited.add(curr);
                area.add(curr);
                if(((HexSpace)curr).getHeight()>0)
                {
                    Tile t = curr.getTopTile();
                    if(t.compareTo(new PalaceTile(0))){
                        area.clear();
                        return false;
                    }
                    if (t.compareTo(check)) {
                        Space[] neighbors = curr.getNeighbors();
                        for (Space s : neighbors) {
                            if (!s.equals(curr) && !visited.contains(s) && ((HexSpace)s).getHeight()>0){
                                if(s.getTopTile().compareTo(check))bfs.add(s);
                            }
                        }
                    }
                }
            }

        }
        return true;
    }
}
