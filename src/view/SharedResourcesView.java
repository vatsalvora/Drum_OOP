package view;

import controller.SharedResourcesController;
import model.Board;
import model.GameFacade;
import model.HexSpace;
import model.Location;
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
		private JButton planningMode;
		private JButton replayMode;


		public SharedResourcesView(SharedResourcesController src)
		{	
/*				this.numThreeBlocks = src.getThreeBlocksLeft();
				this.numIrrigationTiles = src.getIrrigationTilesLeft();
				this.numTwoPalaceTiles = src.getNumTwoPalaceTiles();
				this.numFourPalaceTiles = src.getNumFourPalaceTiles();
				this.numSixPalaceTiles = src.getNumSixPalaceTiles();
				this.numEightPalaceTiles = src.getNumEightPalaceTiles();
				this.numTenPalaceTiles = src.getNumTenPalaceTiles();
*/				//super(new FlowLayout());	
				
				go(src);
		}


		private void go(SharedResourcesController src)
		{
				// Create the frame 
				JFrame frame = new JFrame("Shared Resources ");
				frame.setSize(400, 800);
			    frame.setResizable(false);
			    frame.setLocation(0,0);;
			    frame.setVisible(true);
				
			    // Set the content
			    Container content = frame.getContentPane();
			    content.setBackground(Color.WHITE);
			    
			    // Create our panels
			    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				
				// Empty border template
				Border emptyBorder = BorderFactory.createEmptyBorder();
				buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

				// Planning mode button
				planningMode = new JButton("Planning Mode");
				/* TODO */
				planningMode.setPreferredSize(new Dimension(350,50));
				planningMode.setMinimumSize(planningMode.getPreferredSize());
				planningMode.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(planningMode);
	
				// Replay mode button
				replayMode= new JButton("Replay Mode");
				/* TODO */
				replayMode.setHorizontalTextPosition(SwingConstants.CENTER);
				replayMode.setPreferredSize(new Dimension(350,50));
				replayMode.setMinimumSize(replayMode.getPreferredSize());
				try 
				{
				    Image img = ImageIO.read(getClass().getResource("resources/replay.png"));
				    Image newimg = img.getScaledInstance( 75, 100,  java.awt.Image.SCALE_SMOOTH ) ;
				   // replayMode.setIcon(new ImageIcon(newimg));
				   // replayMode.setBorder(emptyBorder);
				    
				} 
				catch(IOException x) {}
				replayMode.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(replayMode);
				
				// Shared resources information
				// Palace Cards
				palaceCards = new JButton("Palace Cards");
				/* TODO */
				palaceCards.setHorizontalTextPosition(SwingConstants.CENTER);
				palaceCards.setVerticalTextPosition(SwingConstants.BOTTOM);
				palaceCards.setVerticalAlignment(SwingConstants.BOTTOM);
				try 
				{
				    Image img = ImageIO.read(getClass().getResource("resources/cards.jpg"));
				    Image newimg = img.getScaledInstance( 75, 100,  java.awt.Image.SCALE_SMOOTH ) ;
				   // palaceCards.setIcon(new ImageIcon(newimg));
				    palaceCards.setBorder(emptyBorder);
				} 
				catch (IOException ex) {}
				palaceCards.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				palaceCards.setPreferredSize(new Dimension(350,50));
				palaceCards.setMinimumSize(palaceCards.getPreferredSize());
				infoPanel.add(palaceCards);

				festivalCards = new JButton("Festival Cards");
		/*		festivalCards.setHorizontalTextPosition(SwingConstants.CENTER);
				festivalCards.setVerticalTextPosition(SwingConstants.BOTTOM);
				festivalCards.setVerticalAlignment(SwingConstants.BOTTOM);
			*/	try 
				{
				    Image img = ImageIO.read(getClass().getResource("resources/festivalcards.jpg"));
				    Image newimg = img.getScaledInstance(75, 100,  java.awt.Image.SCALE_SMOOTH ) ;
				    //festivalCards.setIcon(new ImageIcon(newimg));
				    festivalCards.setBorder(emptyBorder);
				} 
				catch (IOException ex) {}
				festivalCards.setPreferredSize(new Dimension(350,50));
				festivalCards.setMinimumSize(festivalCards.getPreferredSize());
				festivalCards.setFont(new Font("Charlemagne Std", Font.BOLD, 14));
				infoPanel.add(festivalCards);

				numThreeBlocks = newJLabel("Three Blocks: ");
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
				content.add(buttonPanel);
				content.add(infoPanel);
				System.out.println("Gone!");
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
