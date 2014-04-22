package model;


        import model.customExceptions.SameBlockException;

        import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class VillageTile extends Tile {

    private final Tile[] neighbors = new Tile[6];
    private int numberOfNeighbors;
    private Color village;


    public VillageTile(int numberOfNeighbors, Color outline){

        village = new Color(214,166,81);
        assignColor(outline);
        initNeighbors();
        assignNumberOfNeighbors(numberOfNeighbors);
    }

    public Color[] getColor(){
        return color;
    }

    public void assignNumberOfNeighbors(int numberOfNeighbors){
        this.numberOfNeighbors = numberOfNeighbors;
    }

    public void initNeighbors(){

        for(int i = 0; i < neighbors.length; i++)
            neighbors[i] = null;
    }

    public int[] getNeighborsIndex(){
        int[] temp = new int[numberOfNeighbors];

        for(int i = 0, j = 0; i < neighbors.length; i++)
            if(hasNeighborAt(i))
                temp[j++] = i;

        return temp;
    }

    private boolean hasNeighborAt(int index){
        return (neighbors[index] != null)? true: false;
    }

    public Tile getNeighborAt(int index){
        return neighbors[index];
    }

    public Tile getReferences(int i){
        return neighbors[i];
    }

    public void createReff(Tile tile, int index){
        neighbors[index] = tile;
    }

    public void removeReff(int index){
        neighbors[index] = null;
    }

    public void assignColor(Color c){

        color = new Color[]{village, village, c};
    }



    public void compareNeighbors(Tile tile) throws SameBlockException {
        int[] indexes = tile.getNeighborsIndex();
        boolean check = false;

        for(int i : indexes)
            if(hasNeighborAt(i))
                check = true;
            else
                check = false;

        if(check)
            throw new SameBlockException("Cannot place " + (numberOfNeighbors+1) + " block on top of another " + (numberOfNeighbors+1) + " block.");
    }

    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }

    public String toString(){
        String tile= "VillageTile with: ";
        int[] neigh = getNeighborsIndex();
            for(int i = 0; i < numberOfNeighbors; i++)
                tile += neigh[i] + "\t";
        return tile;
    }

}
