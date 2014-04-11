import java.util.*;

/*
 * PalaceFestival holds information for and does calculations
 * of palace festivals.
 */

public class PalaceFestival
{
	private PalaceCard festivalCard;
	private ArrayList<Player> players;
	private Player currentPlayer;
	private int currentInt;
	private int[] playerScores;
	private boolean[] playerFrozen;
	private boolean inProgress;
	
	public PalaceFestival()
	{
		festivalCard = null;
		players = new ArrayList<Player>();
		currentPlayer = null;
		currentInt = 0;
		playerScores = new int[4];
		playerFrozen = new boolean[4];
		inProgress = false;
	}
	
	public PalaceFestival(PalaceCard c)
	{
		festivalCard = c;
		players = new ArrayList<Player>();
		currentPlayer = null;
		currentInt = 0;
		playerScores = new int[4];
		playerFrozen = new boolean[4];
		inProgress = false;
	}
	
	//Get the festival card
	public PalaceCard getFestivalCard()
	{
		return festivalCard;
	}
	
	//Get current player
	public Player getCurrentPlayer()
	{
		return currentPlayer();
	}
	
	//Reset the festival
	private void reset()
	{
		players = new ArrayList<Player>();
		currentPlayer = null;
		currentInt = 0;
		playerScores = new int[4];
		playerFrozen = new boolean[4];
		inProgress = true;
	}
	
	//Start a new festival by taking in a list of players that can play
	public startFestival(ArrayList<Player> p)
	{
		reset();
		players = p;
		currentInt = 0;
		currentPlayer = players[currentInt];
		ArrayList<Player> remove = new ArrayList<Player>();
		for(int i = 0; i < players.size(); i++)
		{
			if(!playable(players[i]))
			{
				remove.add(players[i]);
			}
		}
		for(int i = 0; i < remove.size(); i++)
		{
			players.remove(remove[i]);
		}
	}
	
	//Change festival card
	public PalaceCard changeFestivalCard(PalaceCard c)
	{
		PalaceCard old = festivalCard;
		festivalCard = c;
		return old;
	}
	
	//Check if a player can still participate (has appropriate card)
	private boolean playable(Player p)
	{
		return p.hasPlayableCard(festivalCard);
	}
	
	//Change current player
	public void nextPlayer()
	{
		if(inProgress)
		{
			currentInt++;
			if(currentInt >= players.size())
			{
				currentInt = 0;
			}
			currentPlayer = players[currentInt];
			if(!playable(currentPlayer))
			{
				freeze();
			}
			if(playerFrozen[currentInt])
			{
				nextPlayer();
			}
		}
	}
	
	//Current player playing a card
	public void playCard(PalaceCard c)
	{
		if(inProgress)
		{
			playerScores[currentInt] += festivalCard.compare(c);
			nextPlayer();
		}
	}
	
	//Freeze the current player so they cannot perform any more actions
	public void freeze()
	{
		if(inProgress)
		{
			playerFrozen[currentInt] = true;
			boolean dummy = true;
			for(int i = 0; i < playerFrozen.length(); i++)
			{
				if(!playerFrozen[i])
				{
					dummy = false;
					break;
				}
			}
			if(dummy)
			{
				inProgress = false;
			}
		}
	}
	
	//Calculate victors
	public ArrayList<Player> getVictors()
	{
		int maxScore = 0;
		ArrayList<Player> ret = new ArrayList<Player>();
		for(int i = 0; i < playerScores.length(); i++)
		{
			if(playerScores[i] > maxScore)
			{
				maxScore = playerScores[i];
			}
		}
		for(int i = 0; i < playerScores.length(); i++)
		{
			if(playerScores[i] == maxScore)
			{
				ret.add(players[i]);
			}
		}
		return ret;
	}
	
	//Check if the festival is over
	public boolean festivalOver()
	{
		return !inProgress;
	}
}