package model;

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

    public CheckIrrigationArea(Space start) {
        points = 3;
        check = new IrrigationTile(0);
        area = new ArrayList<>();
        this.start = start;
    }

    public List<Space> getArea() {
        return area;
    }

    public int famePoints() {
        return points;
    }

    public boolean calcArea() {
        if (!start.getTopTile().compareTo(check)) return false;
        if (((IrrigationTile) start.getTopTile()).getScored()) return false;
        List<Tile> irrigationPool = new LinkedList<>();
        irrigationPool.add(start.getTopTile());
        List<Space> visited = new LinkedList<>();
        Queue<Space> bfs = new LinkedList<>();
        Space[] neighbors = start.getNeighbors();

        for (Space s : neighbors) {
            if (((HexSpace) s).getHeight() > 0) System.out.println(s.getTopTile() instanceof VillageTile);
            bfs.offer(s);
        }

        while (!bfs.isEmpty()) {
            Space curr = bfs.poll();

            if (!visited.contains(curr)) {
                visited.add(curr);
                area.add(curr);
                System.out.println("Height: " + ((HexSpace) curr).getHeight());
                if (((HexSpace) curr).getHeight() <= 0) return false;
                else {
                    Tile t = curr.getTopTile();
                    if (t.compareTo(check)) {
                        irrigationPool.add(t);
                        points += 3;
                        Space[] adjacent = curr.getNeighbors();
                        for (Space s : adjacent) {
                            if (!s.equals(curr) && !visited.contains(s)) bfs.add(s);
                        }
                    }
                }
            }

        }
        for (Tile t : irrigationPool) {
            IrrigationTile i = (IrrigationTile) t;
            i.setScored(true);
        }
        return true;
    }
}
