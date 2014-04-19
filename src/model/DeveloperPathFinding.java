package model;

import java.util.ArrayList;

public class DeveloperPathFinding implements PathFinding {

    ArrayList<Space> shortestPath;
    int APUsed;

    public DeveloperPathFinding() {
        shortestPath = new ArrayList<Space>();
        APUsed = 99;
    }

    public ArrayList<Space> getShortestPath(Space start, Space end) {

        return null;
	}

    public int getAPUsed()
    {
        return APUsed;
    }

}
