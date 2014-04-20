package model;

import java.util.ArrayList;

public interface PathFinding {

    public ArrayList<Space> getShortestPath(Space start, Space end) throws Exception;

}
