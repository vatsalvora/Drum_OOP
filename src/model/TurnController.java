import java.util.*

/*
 * TurnController manages anything a player can do with their 
 * inventory during a turn, including inventory checking, 
 * palace festivals, and inventory management.
 */


class TurnController
{
	Player[] players;
	Player currentPlayer;
	int currentInt;
	int numPlayers;
	int actionPoints;
	boolean actionTokenUsed;
	int blockPlayed;
	PalaceFestival festival;
	
	public PlayerTurn(String[] n, String[] c)
	{
		numPlayers = n.length();
		if(numPlayers > 4)
		{
			numPlayers = 4;
		}
		
		players = new Player[numPlayers];
		
		for(int i = 0; i < numPlayers; i++)
		{
			players[i] = new Player(n[i], c[i]);
		}
		
		actionTokenUsed = false;
		blockPlayed = 0;
		festival = new PalaceFestival();
		currentInt = 0;
		currentPlayer = players[currentInt];
		actionPoints = 6;
	}
	//General getters
	public int APLeft()
	{
		return actionPoints;
	}
	
	public boolean playedBlock()
	{
		boolean ret = false;
		if(blockPlayed > 0)
		{
			ret = true;
		}
		return ret;
	}
	
	public boolean tokenUsed()
	{
		return actionTokenUsed;
	}
	
	//Turn control methods
	public void nextTurn()
	{
		currentInt++;
		if(currentInt >= numPlayers)
		{
			currentInt = 0;
		}
		currentPlayer = players[currentInt];
		actionTokenUsed = false;
		blockPlayed = 0;
		actionPoints = 6;
	}
	
	public void previousTurn()
	{
		currentInt--;
		if(currentInt < 0)
		{
			currentInt = numPlayers - 1;
		}
		currentPlayer = players[currentInt];
	}
	
	//Player accessor methods
	public Player[] getPlayers()
	{
		return players;
	}
	
	//Current player accessor methods
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public String getPlayerName()
	{
		return currentPlayer.getName();
	}
	
	public String getPlayerColor()
	{
		return currentPlayer.getColor();
	}
	
	public List<PalaceCard> getCurrentCards()
	{
		return currentPlayer.getCards();
	}
	
	//Altering current player methods
	public void incrementFamePoints(int i)
	{
		currentPlayer.incrementFamePoints(i);
	}
	
	public void decrementFamePoints(int i)
	{
		currentPlayer.decrementFamePoints(i);
	}
	
	public void placeDeveloper()
	{
		currentPlayer.placeDeveloper();
	}
	
	public void removeDeveloper()
	{
		currentPlayer.removeDeveloper();
	}
	
	public void useActionToken()
	{
		if(actionTokenUsed)
		{
			//put-in: action token already used error
		}
		else
		{
			currentPlayer.useActionToken();
			actionPoints--;
		}
	}
	
	public void returnActionToken()
	{
		currentPlayer.returnActionToken();
		actionTokenUsed = false;
		actionPoints++;
	}
	
	public void placeRiceBlock()
	{
		if(actionPoints > 0)
		{
			currentPlayer.placeRiceBlock();
			actionPoints--;
			blockPlaced++;
		}
		else
		{
			//put-in: no AP left error
		}
	}
	
	public void returnRiceBlock()
	{
		currentPlayer.returnRiceBlock();
		actionPoints++;
		blockPlaced--;
	}
	
	public void placeVillageBlock()
	{
		if(actionPoints > 0)
		{
			currentPlayer.placeVillageBlock();
			actionPoints--;
			blockPlaced++;
		}
		else
		{
			//put-in: no AP left error
		}
	}
	
	public void returnVillageBlock()
	{
		currentPlayer.returnVillageBlock();
		actionPoints++;
		blockPlaced--;
	}
	
	public void placeTwoBlock()
	{
		if(actionPoints > 0)
		{
			currentPlayer.placeTwoBlock();
			actionPoints--;
			blockPlaced++;
		}
		else
		{
			//put-in: no AP left error
		}
	}
	
	public void returnTwoBlock()
	{
		currentPlayer.returnTwoBlock();
		actionPoints++;
		blockPlaced--;
	}
	
	public void addCard(PalaceCard c)
	{
		currentPlayer.addCard(c);
	}
	
	public void drawCard(PalaceCard c)
	{
		if(actionPoints > 0)
		{
			if(actionPoints == 1 && blockPlaced == 0)
			{
				//put-in: using all AP and block not placed error
			}
			else
			{
				actionPoints--;
				currentPlayer.addCard(c);
			}
		}
		else
		{
			//put-in: not enough AP error
		}
	}
	
	public void drawFestivalCard(PalaceCard c)
	{
		if(actionPoints > 0)
		{
			if(actionPoints == 1 && blockPlaced == 0)
			{
				//put-in: using all AP and block not placed error
			}
			else
			{
				actionPoints--;
				currentPlayer.addCard(festival.changeFestivalCard(c));
			}
		}
		else
		{
			//put-in: not enough AP error
		}
	}
	
	//Actions that do not require the current player.
	public void placeOtherBlock()
	{
		if(actionPoints > 0)
		{
			actionPoints--;
			blockPlaced++;
		}
		else
		{
			//put-in: not enough AP error
		}
	}
	
	public void returnOtherBlock()
	{
		actionPoints++;
		blockPlaced--;
	}
	
	public void performAction(int i)
	{
		if(actionPoints == 0)
		{
			//put-in: no AP error
		}
		else if(actionPoints < i)
		{
			//put-in: not enough AP error
		}
		else if(actionPoints = i)
		{
			if(blockPlaced > 0)
			{
				actionPoints -= i;
			}
			else
			{
				//put-in: using all AP but block has not been placed error
			}
		}
		else
		{
			actionPoints -= i;
		}
	}
	
	public void undoAction(int i)
	{
		actionPoints += i;
	}
	
	//Festival accessor methods
	public PalaceFestival getFestival()
	{
		return festival;
	}
	
	public void startFestival(String[] colors)
	{
		ArrayList<Player> inFestival = new ArrayList<Player>();
		for(int i = 0; i < colors.length(); i++)
		{
			for(int j = 0; j < numPlayers; j++)
			{
				if(colors[i].compare(players[j].getColor()))
				{
					inFestival.add(players[j]);
				}
			}
		}
		festival.startFestival(inFestival);
	}
	
	public void changeFestivalPlayer()
	{
		festival.nextPlayer();
	}
	
	public void playCard(String t1, String t2)
	{
		PalaceCard play = new PalaceCard(t1, t2);
		if(currentPlayer.hasPlayableCard(play) && play.compare(festival.getFestivalCard()) > 0)
		{
			festival.playCard(play);
		}
		else
		{
			//put-in: card cannot be played since it doesn't match festival card in any way
		}
	}
	
	public void freeseFestivalPlayer()
	{
		festival.freeze();
	}
	
	public ArrayList<Player> getVictors()
	{
		return festival.getVictors();
	}
	
	public Player getCurrentFestivalPlayer()
	{
		return festival.getCurrentPlayer();
	}
}