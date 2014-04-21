package model;

import java.util.ArrayList;

public class DeveloperPathFinding implements PathFinding
{

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
        shortestPath = new ArrayList<Space>();
        spaceHolder = new ArrayList<Space>();
        spaceAP = new ArrayList<Integer>();
        APUsed = 99;
        shortestPath.add(start);
        ArrayList<Space> newSpace = new ArrayList<Space>();
        newSpace.addAll(shortestPath);
        spaceHolder.add(start);
        spaceAP.add(0);
        traverse(start, end, newSpace, 0);
        System.out.println("AP used for move would be: " + APUsed);
        if(shortestPath.size() == 1 || APUsed == 99)
        {
            //throw new NoConnectingPathException();
        }
        return shortestPath;
	}

    private void traverse(Space current, Space end, ArrayList<Space> list, int currAP)
    {
        HexSpace c = (HexSpace) current;
        HexSpace e = (HexSpace) end;
        if(c.getLocation().getYLocation() == e.getLocation().getYLocation() && c.getLocation().getXLocation() == e.getLocation().getXLocation())
        {
            if(currAP < APUsed)
            {
                APUsed = currAP;
                shortestPath = new ArrayList<Space>();
                shortestPath.addAll(list);
            }
            else if(currAP == APUsed)
            {
                if(shortestPath.size() > list.size())
                {
                    shortestPath = new ArrayList<Space>();
                    shortestPath.addAll(list);
                }
            }
        }
        else
        {
            System.out.println("Let's check the neighbors.");
            for(int i = 0; i < 6; i++)
            {
                HexSpace dummy = (HexSpace) c.getNeighbor(i);
                System.out.println("The location of c's #" + i + " neighbor is "  +dummy.getLocation().toString());
            }
            for(int i = 0; i < 6; i++)
            {
                if(c.getNeighbor(i) != null) {
                    HexSpace s = (HexSpace) c.getNeighbor(i);
                    if (s != null) {
                        System.out.println("The location of this neighbor is: " + s.getLocation().toString());
                        if (s.getTopTile() != null) {
                            System.out.println("Checking a non-null space.");
                            int newAP = 0 + currAP;
                            System.out.println("Made new AP.");
                            if (!s.getTopTile().compareTo(c.getTopTile())) {
                                newAP++;
                            }
                            System.out.println("Checked to see if the tiles are different.");
                            if (spaceHolder.contains(s)) {
                                System.out.println("Space is already in list.");
                                if (spaceAP.get(spaceHolder.indexOf(s)) > newAP) {
                                    spaceAP.set(spaceHolder.indexOf(s), newAP);
                                    ArrayList<Space> newList = new ArrayList<Space>();
                                    newList.addAll(list);
                                    newList.add(s);
                                    traverse(s, e, newList, newAP);
                                }
                            } else {
                                System.out.println("Space is not in the list yet.");
                                spaceHolder.add(s);
                                spaceAP.add(newAP);
                                ArrayList<Space> newList = new ArrayList<Space>();
                                newList.addAll(list);
                                newList.add(s);
                                traverse(s, e, newList, newAP);
                            }
                        }
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
