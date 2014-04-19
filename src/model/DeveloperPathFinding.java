package model;

import java.util.ArrayList;

public class DeveloperPathFinding implements PathFinding {

    ArrayList<Space> shortestPath;
    int APUsed;
    ArrayList<Space> spaceHolder;
    ArrayList<Integer> spaceAP;

    public DeveloperPathFinding() {
        shortestPath = new ArrayList<Space>();
        APUsed = 99;
        spaceHolder = new ArrayList<Space>();
        spaceAP = new ArrayList<Integer>();
    }

    public ArrayList<Space> getShortestPath(Space start, Space end) {
        shortestPath.add(start);
        ArrayList<Space> newSpace = new ArrayList<Space>();
        newSpace.addAll(shortestPath);
        traverse(start, end, newSpace, 0);
        return shortestPath;
	}

    private void traverse(Space currSpace, Space end, ArrayList<Space> list, int currAP)
    {
        if(currSpace == end)
        {
            if(currAP < APUsed)
            {
                shortestPath = list;
            }
            else if(currAP == APUsed)
            {
                if(list.size() < shortestPath.size())
                {
                    shortestPath = list;
                }
            }
        }
        else
        {

        }
    }

    public int getAPUsed()
    {
        return APUsed;
    }

}
