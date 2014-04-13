package model;

class PalaceCard {
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
		if (t1.equals("MASK")) {
			firstType = Type.MASK;
		} else if (t1.equals("DRUM")) {
			firstType = Type.DRUM;
		} else if (t1.equals("PUPPET")) {
			firstType = Type.PUPPET;
		} else {
			firstType = Type.NONE;
		}
	}

	public PalaceCard(String t1, String t2) {
		if (t1.equals("MASK")) {
			firstType = Type.MASK;
		} else if (t1.equals("DRUM")) {
			firstType = Type.DRUM;
		} else if (t1.equals("PUPPET")) {
			firstType = Type.PUPPET;
		} else {
			firstType = Type.NONE;
		}
		if (t2.equals("MASK")) {
			secondType = Type.MASK;
		} else if (t2.equals("DRUM")) {
			secondType = Type.DRUM;
		} else if (t2.equals("PUPPET")) {
			secondType = Type.PUPPET;
		} else {
			secondType = Type.NONE;
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

	public boolean equals(PalaceCard c) {
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
		if (getFirstType().equals(c.getFirstType()) || getFirstType().equals(c.getSecondType())) {
			similarities++;
		}
		if (getSecondType().equals(c.getFirstType()) || getSecondType().equals(c.getSecondType())) {
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