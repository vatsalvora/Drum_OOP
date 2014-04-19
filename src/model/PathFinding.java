package model;

import java.util.List;

public interface PathFinding {

    public List<Space> getShortestPath(Location initial, Location fin);

}
