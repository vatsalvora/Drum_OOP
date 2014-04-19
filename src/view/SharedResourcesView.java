package view;

import controller.SharedResourcesController;
import model.Board;
import model.GameFacade;
import model.HexSpace;
import model.Location;
import model.state.State;
import model.state.Turn;
import view.keypressed.KeyPressed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

@SuppressWarnings("serial")
public class SharedResourcesView extends JPanel
{
		// Static fields
		private JLabel numThreeBlocks;
		private JLabel numIrrigationTiles;
		private JLabel numTwoPalaceTiles;
		private JLabel numFourPalaceTiles;
		private JLabel numSixPalaceTiles;
		private JLabel numEightPalaceTiles;
		private JLabel numTenPalaceTiles;

		// Interactive fields
		private JButton palaceCards;
		private JButton festivalCards;
		private JButton planningMode;
		private JButton replayMode;


		public SharedResourcesView()
		{
		
				SharedResourcesController src;
/*				this.numThreeBlocks = src.getThreeBlocksLeft();
				this.numIrrigationTiles = src.getIrrigationTilesLeft();
				this.numTwoPalaceTiles = src.getNumTwoPalaceTiles();
				this.numFourPalaceTiles = src.getNumFourPalaceTiles();
				this.numSixPalaceTiles = src.getNumSixPalaceTiles();
				this.numEightPalaceTiles = src.getNumEightPalaceTiles();
				this.numTenPalaceTiles = src.getNumTenPalaceTiles();
*/			
				setPreferredSize(new Dimension(300, 300));
				go();
		}


		private void go()
		{
				JPanel buttonPanel = new JPanel();
				buttonPanel.setPreferredSize(new Dimension(140, 90));
				buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
				add(buttonPanel); 
				planningMode = new JButton("Planning Mode");
				/* TODO */
				add(planningMode);
		
				replayMode= new JButton("Replay Mode");
				/* TODO */
				add(replayMode);

				palaceCards = new JButton("Palace Cards");
				/* TODO */
				add(palaceCards);

				festivalCards = new JButton("Festival Cards");
				numThreeBlocks = newJLabel("NumThreeBlocks");
				add(numThreeBlocks);
				
				numIrrigationTiles = newJLabel("NumIrrigationTiles");
				add(numIrrigationTiles);
				
				numTwoPalaceTiles = newJLabel("NumTwoPalaceTiles");
				add(numTwoPalaceTiles);
				
				numFourPalaceTiles = newJLabel("NumFourPalaceTiles");
				add(numFourPalaceTiles);
				
				numSixPalaceTiles = newJLabel("NumSixPalaceTiles");
				add(numSixPalaceTiles);
				
				numEightPalaceTiles = newJLabel("NumEightPalaceTiles");
				add(numEightPalaceTiles);

				numTenPalaceTiles = newJLabel("NumTenPalaceTiles");
				add(numTenPalaceTiles);
		}		
				
				public void updateNumThreeBlocks(int num)
				{
						this.numThreeBlocks.setText(""+num);
				}

				public void updateNumIrrigationTiles(int num)
				{
						this.numIrrigationTiles.setText(""+num);
				}

				public void updateNumTwoPalaceTiles(int num)
				{
						this.numTwoPalaceTiles.setText(""+num);
				}

				public void updateNumFourPalaceTiles(int num)
				{
						this.numFourPalaceTiles.setText(""+num);
				}

				public void updateNumSixPalaceTiles(int num)
				{
						this.numSixPalaceTiles.setText(""+num);
				}

				public void updateNumEightPalaceTiles(int num)
				{
						this.numEightPalaceTiles.setText(""+num);
				}

				public void updateNumTenPalaceTiles(int num)
				{
						this.numTenPalaceTiles.setText(""+num);
				}

				public void updateNumPalaceCards(int num)
				{
						this.palaceCards.setText(""+num);
				}

				public void updatePalaceTiles(int num, int value)
				{
						if(value == 2){
								updateNumTwoPalaceTiles(num);
						}
						else if(value == 4){
								updateNumFourPalaceTiles(num);
						}
						else if(value == 6){
								updateNumSixPalaceTiles(num);
						}
						else if(value == 8){
								updateNumEightPalaceTiles(num);
						}
						else if(value == 10){
								updateNumTenPalaceTiles(num);
						}
						
				}

				public void drawPalaceCard(int numPalaceCards)
				{
						this.palaceCards.setText(""+numPalaceCards);
						/* TODO */
				}

				public void drawFestivalCard(int numPalaceCards, String newFestivalCardHashKey)
				{
						// drawFromPalaceDeck(numPalaceCards);
						/* TODO */
				}
				
				public void updateFestivalCard()
				{
						/* TODO */
				}

				/* TODO:
						- Mode buttons
						- Drawing
						- Images
				*/
				private JLabel newJLabel(String value)
				{
						JLabel label= new JLabel(value);
					//	label.setIcon(new ImageIcon(src));
						label.setFont(new Font("Lucida Grande", 0, 14));
						label.setPreferredSize(new Dimension(40, 90));
						label.setHorizontalTextPosition(SwingConstants.CENTER);
						label.setVerticalTextPosition(SwingConstants.BOTTOM);
						label.setVerticalAlignment(SwingConstants.BOTTOM);
						label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
						return label;
				}
				
} // End class
