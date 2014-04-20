package model;

import model.customExceptions.NoConnectingPathException;

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

    public ArrayList<Space> getShortestPath(Space start, Space end) throws Exception {
        shortestPath.add(start);
        ArrayList<Space> newSpace = new ArrayList<Space>();
        newSpace.addAll(shortestPath);
        traverse(start, end, newSpace, 0);
        if(shortestPath.size() == 1 || APUsed == 99)
        {
            throw new NoConnectingPathException();
        }
        return shortestPath;
	}

    private void traverse(Space currSpace, Space end, ArrayList<Space> list, int currAP)
    {
        if(currSpace == end)
        {
            if(currAP < APUsed)
            {
                shortestPath = list;
                APUsed = currAP;
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
            Space[] neighbors = currSpace.getNeighbors();
            int newAP = 0 + currAP;
            for(Space nextSpace : neighbors)
            {
                if(nextSpace != null) {
                    if (!nextSpace.getTopTile().getClass().equals(currSpace.getTopTile().getClass())) {
                        newAP++;
                    }
                    if (spaceHolder.contains(nextSpace)) {
                        if (spaceAP.get(spaceHolder.indexOf(nextSpace)) > newAP) {
                            spaceAP.set(spaceHolder.indexOf(nextSpace), newAP);
                            ArrayList<Space> newList = new ArrayList<Space>();
                            newList.addAll(list);
                            list.add(nextSpace);
                            traverse(nextSpace, end, newList, newAP);
                        }
                    } else {
                        spaceHolder.add(nextSpace);
                        spaceAP.add(newAP);
                        ArrayList<Space> newList = new ArrayList<Space>();
                        newList.addAll(list);
                        list.add(nextSpace);
                        traverse(nextSpace, end, newList, newAP);
                    }
                }
            }
        }
    }

    public int getAPUsed()
    {
        return APUsed;
    }

}
