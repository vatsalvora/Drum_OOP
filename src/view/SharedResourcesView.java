package view;

import controller.TurnController;
import model.SharedResources;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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
        private JLabel APLeft;
        private JTextArea errorInfo;
		
		private JTextArea player1;
		private JTextArea player2;
		private JTextArea player3;
		private JTextArea player4;

		// Interactive fields
		private JLabel palaceCards;
		private JLabel festivalCards;
	
		private JFrame frame;

        String errorMessage;

    private TurnController tc;
    private SharedResources sr;

		public SharedResourcesView(TurnController t, SharedResources s)
		{
            tc = t;
            sr = s;
				createView();
            errorMessage = " ";
		}


		private void createView()
		{
				// Create the frame 
				frame = new JFrame("Shared Resources ");
				frame.setSize(400, 750);
			    frame.setResizable(true);
			    frame.setLocation(0,0);;
			    frame.setVisible(true);
				
			    // Set the content
			    Container content = frame.getContentPane();
			    content.setBackground(Color.WHITE);
			    
			    // Create our panels
			    JPanel mainPanel = new JPanel();
			    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
			    
				JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				infoPanel.setMinimumSize(new Dimension(400,400));
                JPanel playerPanel = new JPanel();
                playerPanel.setLayout(new BoxLayout(playerPanel,BoxLayout.LINE_AXIS));
                playerPanel.setMinimumSize(new Dimension(400,400));
                // Empty border template
				Border emptyBorder = BorderFactory.createEmptyBorder();
	
	
				
				// Shared resources information
				// Palace Cards
				palaceCards = customJLabel("Player Palace Cards");
				/* TODO */
				palaceCards.setHorizontalTextPosition(SwingConstants.CENTER);
				palaceCards.setVerticalTextPosition(SwingConstants.BOTTOM);
				palaceCards.setVerticalAlignment(SwingConstants.BOTTOM);
				palaceCards.setBorder(emptyBorder);
				palaceCards.setPreferredSize(new Dimension(380,25));
				palaceCards.setMinimumSize(palaceCards.getPreferredSize());
				setFont(new Font("Charlemagne Std", Font.BOLD, 10));
				infoPanel.add(palaceCards);

				festivalCards = customJLabel ("Festival Cards");
	
				festivalCards.setBorder(emptyBorder);
			
				festivalCards.setPreferredSize(new Dimension(380,25));
				festivalCards.setMinimumSize(festivalCards.getPreferredSize());
				infoPanel.add(festivalCards);

				numThreeBlocks = customJLabel("Three Blocks:    ");
				numThreeBlocks.setText("");
				numThreeBlocks.setPreferredSize(new Dimension(200,25));
				numThreeBlocks.setHorizontalTextPosition(SwingConstants.CENTER);
				numThreeBlocks.setVerticalTextPosition(SwingConstants.BOTTOM);
				numThreeBlocks.setVerticalAlignment(SwingConstants.BOTTOM);
				numThreeBlocks.setMinimumSize(numThreeBlocks.getPreferredSize());
				infoPanel.add(numThreeBlocks);
				
				numIrrigationTiles = customJLabel("Irrigation Tiles");
				numIrrigationTiles.setPreferredSize(new Dimension(200,25));
				numIrrigationTiles.setMinimumSize(numIrrigationTiles.getPreferredSize());
				infoPanel.add(numIrrigationTiles);
				
				numTwoPalaceTiles = customJLabel("Two Palace Tiles: ");
				numTwoPalaceTiles.setPreferredSize(new Dimension(200,25));
				numTwoPalaceTiles.setMinimumSize(numTwoPalaceTiles.getPreferredSize());
				infoPanel.add(numTwoPalaceTiles);
				
				numFourPalaceTiles = customJLabel("Four Palace Tiles: ");
				numFourPalaceTiles.setPreferredSize(new Dimension(200,25));
				numFourPalaceTiles.setMinimumSize(numFourPalaceTiles.getPreferredSize());
				infoPanel.add(numFourPalaceTiles);
				
				numSixPalaceTiles = customJLabel("Six Palace Tiles: ");
				numSixPalaceTiles.setPreferredSize(new Dimension(200,25));
				numSixPalaceTiles.setMinimumSize(numSixPalaceTiles.getPreferredSize());
				infoPanel.add(numSixPalaceTiles);
				
				numEightPalaceTiles = customJLabel("Eight Palace Tiles: ");
				numEightPalaceTiles.setPreferredSize(new Dimension(200,25));
				numEightPalaceTiles.setMinimumSize(numEightPalaceTiles.getPreferredSize());
				infoPanel.add(numEightPalaceTiles);

				numTenPalaceTiles = customJLabel("Ten Palace Tiles: \n hereee ");
				numTenPalaceTiles.setPreferredSize(new Dimension(200,25));
				numTenPalaceTiles.setMinimumSize(numTenPalaceTiles.getPreferredSize());
				infoPanel.add(numTenPalaceTiles);

                APLeft = customJLabel("AP left: ");
                APLeft.setPreferredSize(new Dimension(300, 100));
                APLeft.setMinimumSize(APLeft.getPreferredSize());
                APLeft.setFont(new Font("Serif", Font.BOLD, 22));
                infoPanel.add(APLeft);

                //need to move to the right to make it fully visible
                errorInfo = new JTextArea(50, 50);
                errorInfo.setPreferredSize(new Dimension(50, 50));
                errorInfo.setMinimumSize(APLeft.getPreferredSize());
                errorInfo.setMaximumSize(new Dimension(50, 50));
                errorInfo.setOpaque(false);
                errorInfo.setForeground(Color.RED);
                infoPanel.add(errorInfo);
				
				player1 = new JTextArea(50,50);
				player1.setMinimumSize(new Dimension(100,100));
                player1.setPreferredSize(new Dimension(100,100));
                player1.setMaximumSize(new Dimension(100,100));
				playerPanel.add(player1);
				
				player2 = new JTextArea(50,50);
				player2.setMinimumSize(new Dimension(100,100));
                player2.setPreferredSize(new Dimension(100,100));
                player2.setMaximumSize(new Dimension(100,100));
				playerPanel.add(player2);
				
				player3 = new JTextArea(50,50);
				player3.setMinimumSize(new Dimension(100,100));
                player3.setPreferredSize(new Dimension(100,100));
                player3.setMaximumSize(new Dimension(100,100));
				playerPanel.add(player3);
				
				player4 = new JTextArea(50,50);
				player4.setMinimumSize(new Dimension(100,100));
                player4.setPreferredSize(new Dimension(100, 100));
                player4.setMaximumSize(new Dimension(100,100));
				playerPanel.add(player4);

				// Add panels			
				mainPanel.add(infoPanel);
				mainPanel.add(playerPanel);
				content.add(mainPanel);
		}
		
		public void updateFields()
		{
			System.out.println("Updating fields");
			updateNumThreeBlocks(sr.getNumThreeBlockTiles());
			updateNumTwoPalaceTiles(sr.getNumTwoPalaces());
			updateNumIrrigationTiles(sr.getNumIrrigationTiles());
			updateNumFourPalaceTiles(sr.getNumFourPalaces());
			updateNumSixPalaceTiles(sr.getNumSixPalaces());
			updateNumEightPalaceTiles(sr.getNumEightPalaces());
			updateNumTenPalaceTiles(sr.getNumTenPalaces());
            updateAPLeft(tc.APLeft());
            updateErrorMessage();
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

                public void updateAPLeft(int num)
                {
                    this.APLeft.setText("AP left: " + num);
                }

                public void updateErrorMessage()
                {
                    errorInfo.setText(errorMessage);
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
				
				public void updatePlayers()
				{
					System.out.println("Updating players...");
					String festivalCard = tc.getCurrentFestivalCard();
					int cp = tc.getCurrentPlayerIndex()+1;
					String p1 = tc.getPlayerInfo(1);
					String p2 = tc.getPlayerInfo(2);
					String p3 = tc.getPlayerInfo(3);
					String p4 = tc.getPlayerInfo(4);
					
					this.palaceCards.setText(tc.getPlayerName() + "'s cards: " + tc.getPlayerCardInfo());
					this.festivalCards.setText("Festival Card: "+festivalCard);

                    if(tc.getCurrentPlayerIndex() == 0)
                    {
                        player1.setBorder(BorderFactory.createLineBorder(tc.getPlayerViewColor()));
                    }
                    else
                    {
                        player1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    }
                    if(tc.getCurrentPlayerIndex() == 1)
                    {
                        player2.setBorder(BorderFactory.createLineBorder(tc.getPlayerViewColor()));
                    }
                    else
                    {
                        player2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    }
                    if(tc.getCurrentPlayerIndex() == 2)
                    {
                        player3.setBorder(BorderFactory.createLineBorder(tc.getPlayerViewColor()));
                    }
                    else
                    {
                        player3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    }
                    if(tc.getCurrentPlayerIndex() == 3)
                    {
                        player4.setBorder(BorderFactory.createLineBorder(tc.getPlayerViewColor()));
                    }
                    else
                    {
                        player4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    }

					this.player1.setText(p1);
					this.player2.setText(p2);
					this.player3.setText(p3);
					this.player4.setText(p4);
				}
				private JLabel customJLabel(String value)
				{
						JLabel label= new JLabel(value);
						label.setFont(new Font("Charlemagne Std", Font.BOLD, 12));
						label.setPreferredSize(new Dimension(40, 90));
						label.setHorizontalTextPosition(SwingConstants.CENTER);
						label.setVerticalTextPosition(SwingConstants.BOTTOM);
						label.setVerticalAlignment(SwingConstants.BOTTOM);
						label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
						return label;
				}

    public void setErrorMessage(String s) {
        errorMessage = s;
    }

    public void removeErrorMessage()
    {
        errorMessage = " ";
    }
} // End class
