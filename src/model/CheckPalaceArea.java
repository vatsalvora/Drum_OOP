package model;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Vatsal on 4/22/2014.
 */
public class CheckPalaceArea {
    private Tile check;
    private List<Space> area;
    private Space start;
    private HashSet<String> develsInCity;
    public CheckPalaceArea(Space start){
        check = new VillageTile(0, Color.BLACK);
        area = new ArrayList<Space>();
        this.start = start;
        develsInCity = new HashSet<String>();
    }

    public List<Space> getArea(){
        return area;
    }
    public boolean calcArea(){
        List<Space> visited = new LinkedList<Space>();
        Queue<Space> bfs = new LinkedList<Space>();
        if(((HexSpace)start).getHeight()>0)
        {
            Tile t = start.getTopTile();
            Space[] neighbors = start.getNeighbors();
            for (Space s : neighbors) {
                if (!s.equals(start) && !visited.contains(s) && ((HexSpace)s).getHeight()>0){
                    if(s.getTopTile().compareTo(check))bfs.add(s);
                }
            }
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
                        System.out.println("Came Here!");
                        area = new ArrayList<Space>();
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
    public ArrayList<String> getColors()
    {
        develsInCity = new HashSet<String>();
        for(Space space : area)
        {
            HexSpace s = (HexSpace) space;
            if(s.hasDeveloper())
            {
                String color = s.getDeveloper().getColor();
                develsInCity.add(color);
            }
        }
        Object [] colors = (Object[]) develsInCity.toArray();
        ArrayList<String> color = new ArrayList<String>();
        for(Object s: colors) color.add(s+"");
        System.out.println(area.size());
        return color;
    }
}
