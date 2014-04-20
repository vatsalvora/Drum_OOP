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

    public ArrayList<Space> getShortestPath(Space start, Space end) throws Exception {
        shortestPath.add(start);
        ArrayList<Space> newSpace = new ArrayList<Space>();
        newSpace.addAll(shortestPath);
        traverse(start, end, newSpace, 0);
        System.out.println("AP used for move would be: " + APUsed);
        if(shortestPath.size() == 1 || APUsed == 99)
        {
            //throw new NoConnectingPathException();
        }
        return shortestPath;
	}

    private void traverse(Space c, Space e, ArrayList<Space> list, int currAP)
    {
        HexSpace currSpace = (HexSpace) c;
        HexSpace end = (HexSpace) e;
        System.out.println("Traversal is working.");
        if(currSpace == end)
        {
            System.out.println("reached the end");
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
            System.out.println("Haven't reached end.");
            Space[] neighbors = currSpace.getNeighbors();
            int newAP = 0 + currAP;
            for(Space n : neighbors)
            {
                System.out.println("Checking a neighbor.");
                HexSpace nextSpace = (HexSpace) n;
                if(nextSpace != null) {
                    System.out.println("Checking a non-null neighbor.");
                    if (!nextSpace.getTopTile().compareTo(currSpace.getTopTile())) {
                        newAP++;
                    }
                    System.out.println("Still working.");
                    if (spaceHolder.contains(nextSpace)) {
                        System.out.println("Space has been visited");
                        if (spaceAP.get(spaceHolder.indexOf(nextSpace)) > newAP) {
                            spaceAP.set(spaceHolder.indexOf(nextSpace), newAP);
                            ArrayList<Space> newList = new ArrayList<Space>();
                            newList.addAll(list);
                            newList.add(nextSpace);
                            traverse(nextSpace, end, newList, newAP);
                        }
                    } else {
                        System.out.println("Space has not been visited.");
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
