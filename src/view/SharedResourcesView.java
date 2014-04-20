package view;

import controller.SharedResourcesController;
import model.Board;
import model.GameFacade;
import model.HexSpace;
import model.Location;
import model.SharedResources;
import model.state.State;
import model.state.Turn;
import view.keypressed.KeyPressed;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

@SuppressWarnings("serial")
public class SharedResourcesView extends JFrame
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
	
		private JFrame frame;


		public SharedResourcesView()
		{					
				createView();
		}


		private void createView()
		{
				// Create the frame 
				frame = new JFrame("Shared Resources ");
				frame.setSize(450, 850);
			    frame.setResizable(true);
			    frame.setLocation(0,0);;
			    frame.setVisible(true);
				
			    // Set the content
			    Container content = frame.getContentPane();
			    content.setBackground(Color.WHITE);
			    
			    // Create our panels
				JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				
				// Empty border template
				Border emptyBorder = BorderFactory.createEmptyBorder();
	
	
				
				// Shared resources information
				// Palace Cards
				palaceCards = new JButton("Palace Cards");
				/* TODO */
				palaceCards.setHorizontalTextPosition(SwingConstants.CENTER);
				palaceCards.setVerticalTextPosition(SwingConstants.BOTTOM);
				palaceCards.setVerticalAlignment(SwingConstants.BOTTOM);
				palaceCards.setBorder(emptyBorder);
				palaceCards.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				palaceCards.setPreferredSize(new Dimension(350,50));
				palaceCards.setMinimumSize(palaceCards.getPreferredSize());
				infoPanel.add(palaceCards);

				festivalCards = new JButton("Festival Cards");
	
				festivalCards.setBorder(emptyBorder);
			
				festivalCards.setPreferredSize(new Dimension(350,50));
				festivalCards.setMinimumSize(festivalCards.getPreferredSize());
				festivalCards.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(festivalCards);

				numThreeBlocks = newJLabel("Three Blocks:    ");
				numThreeBlocks.setText("");
				numThreeBlocks.setPreferredSize(new Dimension(350,50));
				numThreeBlocks.setHorizontalTextPosition(SwingConstants.CENTER);
				numThreeBlocks.setVerticalTextPosition(SwingConstants.BOTTOM);
				numThreeBlocks.setVerticalAlignment(SwingConstants.BOTTOM);
				numThreeBlocks.setMinimumSize(numThreeBlocks.getPreferredSize());
				numThreeBlocks.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(numThreeBlocks);
				
				numIrrigationTiles = newJLabel("Irrigation Tiles");
				numIrrigationTiles.setPreferredSize(new Dimension(350,50));
				numIrrigationTiles.setMinimumSize(numIrrigationTiles.getPreferredSize());
				numIrrigationTiles.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(numIrrigationTiles);
				
				numTwoPalaceTiles = newJLabel("Two Palace Tiles: ");
				numTwoPalaceTiles.setPreferredSize(new Dimension(350,50));
				numTwoPalaceTiles.setMinimumSize(numTwoPalaceTiles.getPreferredSize());
				numTwoPalaceTiles.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(numTwoPalaceTiles);
				
				numFourPalaceTiles = newJLabel("Four Palace Tiles: ");
				numFourPalaceTiles.setPreferredSize(new Dimension(350,50));
				numFourPalaceTiles.setMinimumSize(numFourPalaceTiles.getPreferredSize());
				numFourPalaceTiles.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(numFourPalaceTiles);
				
				numSixPalaceTiles = newJLabel("Six Palace Tiles: ");
				numSixPalaceTiles.setPreferredSize(new Dimension(350,50));
				numSixPalaceTiles.setMinimumSize(numSixPalaceTiles.getPreferredSize());
				numSixPalaceTiles.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(numSixPalaceTiles);
				
				numEightPalaceTiles = newJLabel("Eight Palace Tiles: ");
				numEightPalaceTiles.setPreferredSize(new Dimension(350,50));
				numEightPalaceTiles.setMinimumSize(numEightPalaceTiles.getPreferredSize());
				numEightPalaceTiles.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(numEightPalaceTiles);

				numTenPalaceTiles = newJLabel("Ten Palace Tiles: ");
				numTenPalaceTiles.setPreferredSize(new Dimension(350,50));
				numTenPalaceTiles.setMinimumSize(numTenPalaceTiles.getPreferredSize());
				numTenPalaceTiles.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(numTenPalaceTiles);

				// Add panels			
				content.add(infoPanel);
		}
		
		public void updateFields(SharedResources sr)
		{
			System.out.println("Updating!!!");
			updateNumThreeBlocks(sr.getNumThreeBlockTiles());
			updateNumTwoPalaceTiles(sr.getNumTwoPalaces());
			updateNumIrrigationTiles(sr.getNumIrrigationTiles());
			updateNumFourPalaceTiles(sr.getNumFourPalaces());
			updateNumSixPalaceTiles(sr.getNumSixPalaces());
			updateNumEightPalaceTiles(sr.getNumEightPalaces());
			updateNumTenPalaceTiles(sr.getNumTenPalaces());
			System.out.println(sr.getNumTenPalaces() + "ten palaces");
			this.toBack();
			
		}
				
				public void updateNumThreeBlocks(int num)
				{
						this.numThreeBlocks.setText("Three blocks: "+num);
				}

				public void updateNumIrrigationTiles(int num)
				{
						this.numIrrigationTiles.setText("Irrigation Tiles: "+num);
				}

				public void updateNumTwoPalaceTiles(int num)
				{
						this.numTwoPalaceTiles.setText("Two Palace Tiles: "+num);
				}

				public void updateNumFourPalaceTiles(int num)
				{
						this.numFourPalaceTiles.setText("Four palace tiles: "+num);
				}

				public void updateNumSixPalaceTiles(int num)
				{
						this.numSixPalaceTiles.setText("Six Palace Tiles: "+num);
				}

				public void updateNumEightPalaceTiles(int num)
				{
						this.numEightPalaceTiles.setText("Eight Palace Tiles: "+num);
				}

				public void updateNumTenPalaceTiles(int num)
				{
						this.numTenPalaceTiles.setText("Ten Palace Tiles: "+num);
				}

				public void updateNumPalaceCards(int num)
				{
						this.palaceCards.setText("Palace Cards: "+num);
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
						label.setPreferredSize(new Dimension(40, 90));
						label.setHorizontalTextPosition(SwingConstants.CENTER);
						label.setVerticalTextPosition(SwingConstants.BOTTOM);
						label.setVerticalAlignment(SwingConstants.BOTTOM);
						label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
						return label;
				}
				
} // End class
