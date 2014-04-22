package model;

public class PalaceCard {
    private enum Type {
        MASK, DRUM, PUPPET, NONE
    }

    private Type firstType;
    private Type secondType;

    public PalaceCard() {
        firstType = Type.NONE;
        secondType = Type.NONE;
    }

    public PalaceCard(String t1) {
        secondType = Type.NONE;
        switch (t1) {
            case "MASK":
                firstType = Type.MASK;
                break;
            case "DRUM":
                firstType = Type.DRUM;
                break;
            case "PUPPET":
                firstType = Type.PUPPET;
                break;
            default:
                firstType = Type.NONE;
                break;
        }
    }

    public PalaceCard(String t1, String t2) {
        switch (t1) {
            case "MASK":
                firstType = Type.MASK;
                break;
            case "DRUM":
                firstType = Type.DRUM;
                break;
            case "PUPPET":
                firstType = Type.PUPPET;
                break;
            default:
                firstType = Type.NONE;
                break;
        }
        switch (t2) {
            case "MASK":
                secondType = Type.MASK;
                break;
            case "DRUM":
                secondType = Type.DRUM;
                break;
            case "PUPPET":
                secondType = Type.PUPPET;
                break;
            default:
                secondType = Type.NONE;
                break;
        }
    }

    public String getFirstType() {
        String ret = "ERROR";
        if (firstType == Type.MASK) {
            ret = "MASK";
        } else if (firstType == Type.DRUM) {
            ret = "DRUM";
        } else if (firstType == Type.PUPPET) {
            ret = "PUPPET";
        } else if (firstType == Type.NONE) {
            ret = "NONE";
        }
        return ret;
    }

    public String getSecondType() {
        String ret = "ERROR";
        if (secondType == Type.MASK) {
            ret = "MASK";
        } else if (secondType == Type.DRUM) {
            ret = "DRUM";
        } else if (secondType == Type.PUPPET) {
            ret = "PUPPET";
        } else if (secondType == Type.NONE) {
            ret = "NONE";
        }
        return ret;
    }

    public boolean sameCardAs(PalaceCard c) {
        boolean ret = false;
        if (getFirstType().equals(c.getFirstType()) && getSecondType().equals(c.getSecondType())) {
            ret = true;
        }
        if (getFirstType().equals(c.getSecondType()) && getSecondType().equals(c.getFirstType())) {
            ret = true;
        }
        return ret;
    }

    public int compare(PalaceCard c) {
        int similarities = 0;

        if (!getFirstType().equals("NONE") && (getFirstType().equals(c.getFirstType()) || getFirstType().equals(c.getSecondType()))) {
            similarities++;
        }
        if (!getSecondType().equals("NONE") && (getSecondType().equals(c.getFirstType()) || getSecondType().equals(c.getSecondType()))) {
            similarities++;
        }
        return similarities;
    }

    public String toString() {
        String ret = "";
        if (firstType != Type.NONE) {
            ret += getFirstType() + " ";
        }
        if (secondType != Type.NONE) {
            ret += getSecondType();
        }
        return ret;
    }
}