package model;

import java.util.ArrayList;

public interface PathFinding {

    public ArrayList<Space> getShortestPath(Location start, Location end);

}
