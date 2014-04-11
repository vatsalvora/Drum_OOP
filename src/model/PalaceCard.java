package model;

class PalaceCard {

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

	// TODO need to fix this to compile! What is compare? you mean compareTo?
	// public boolean equals(PalaceCard c) {
	// boolean ret = false;
	// if (getFirstType().compare(c.getFirstType()) &&
	// getSecondType().compare(c.getSecondType())) {
	// ret = true;
	// }
	// if (getFirstType().compare(c.getSecondType()) &&
	// getSecondType().compare(c.getFirstType())) {
	// ret = true;
	// }
	// return ret;
	// }
	//
	// public int compare(PalaceCard c) {
	// int similarities = 0;
	// if (getFirstType().compare(c.getFirstType()) ||
	// getFirstType().compare(c.getSecondType())) {
	// similarities++;
	// }
	// if (getSecondType().compare(c.getFirstType()) ||
	// getSecondType().compare(c.getSecondType())) {
	// similarities++;
	// }
	// return similarities;
	// }

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

	private enum Type {
		MASK, DRUM, PUPPET, NONE
	}

	public int compare(PalaceCard festivalCard) {
		// TODO Auto-generated method stub
		return 0;
	}
}