package model;

/**
 * Created by devan on 4/17/14.
 */
enum PalaceLevel {
    Two(2), Four(4), Six(6), Eight(8), Ten(10);

    private int value;

    private PalaceLevel(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public static PalaceLevel getEnum(int value) {
        switch (value) {
            case 2:
                return Two;
            case 4:
                return Four;
            case 6:
                return Six;
            case 8:
                return Eight;
            case 10:
                return Ten;
            default:
                return null;
        }

    }
}
