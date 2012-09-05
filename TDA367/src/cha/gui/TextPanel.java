package cha.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import cha.domain.Categories.Category;
import cha.domain.Board;
import cha.domain.Challenge;
import cha.domain.Mission;
import cha.event.EventBus;
import cha.event.Event;
import cha.event.IEventHandler;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class TextPanel extends JPanel implements IEventHandler {

	private JTextArea textArea;
	private JLabel lblTime;
	private JPanel p2 = new JPanel();
	private JPanel cardPanel = new JPanel();
	private JLabel header = new JLabel();
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();

	public TextPanel() {
		EventBus.getInstance().register(this);
		initialize();
	}

	public void initialize() {
		setLayout(new BorderLayout(0, 0));
		this.setSize(600, 400);

		textArea = new JTextArea();
		textArea.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		textArea.setSize(500, 300);
		textArea.setEditable(false);

		this.setBackground(Color.WHITE);

		textArea.setForeground(Color.BLACK);
		textArea.setOpaque(false);
		textArea.setText("");
		add(textArea, BorderLayout.CENTER);
		textArea.setColumns(2);

		lblTime = new JLabel("Time");
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setForeground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		p1.add(lblTime, BorderLayout.EAST);
		add(p1, BorderLayout.SOUTH);

		p2.setBackground(Color.WHITE);
		p2.setPreferredSize(new Dimension(100, 75));
		p2.setMinimumSize(new Dimension(100, 75));
		p2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		add(p2, BorderLayout.NORTH);

		cardPanel.add(northPanel, BorderLayout.PAGE_START);
		cardPanel.add(southPanel, BorderLayout.CENTER);
	}

	@Override
	public void action(Event e, Object o, Object p) {
		if (e == Event.StartMission) {
			Mission mission = (Mission) o;
			cardPanel.setMaximumSize(new Dimension(50, 50));
			cardPanel.setMinimumSize(new Dimension(50, 50));
			cardPanel.setPreferredSize(new Dimension(50, 50));
			Category c = mission.getCategory();
			Color colorBG = setCardBGColor(c);
			Color colorFG = setCardFGColor(c);

			cardPanel.setBackground(colorBG);
			cardPanel.setForeground(colorBG);
			cardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			this.remove(textArea);
			repaint();
			add(cardPanel);

			northPanel.remove(header);
			northPanel.setBackground(colorFG);
			northPanel.setForeground(colorFG);
			northPanel.setPreferredSize(new Dimension(550, 50));
			northPanel.setBorder(BorderFactory.createLineBorder(Color.black));

			southPanel.remove(textArea);
			southPanel.setBackground(colorFG);
			southPanel.setForeground(colorFG);
			southPanel.setPreferredSize(new Dimension(550, 250));
			southPanel.setBorder(BorderFactory.createLineBorder(Color.black));

			southPanel.add(textArea, BorderLayout.SOUTH);
			paintCard(mission);
			String title = mission.getTitle();
			header.setText("" + title);
			header.setFont(new Font("DejaVu Sans", Font.BOLD, 30));
			northPanel.add(header, BorderLayout.NORTH);

		} else if (e == Event.NextCard) {
			Mission mission = (Mission) o;
			paintCard(mission);
		}

		else if (e == Event.MakeBet) {
			if (!(Board.getInstance().getTile(
					Board.getInstance().getActivePiece().getPosition())
					.isChallenge())) {
				int bet = (Integer) o;
				textArea.setText("Bet: " + bet);
			}

		} else if (e == Event.ShowBet) {
			textArea.setText("Make bet!");
		} else if (e == Event.TimeOver) {
			this.remove(cardPanel);
			this.add(textArea);
			this.repaint();
			if (Challenge.isChallengeActive() == true) {
				textArea.setText("Challenging team has done their best! \nOpponents turn!");
			} else {
				textArea.setText("Was the mission completed successfully?");
			}
		} else if (e == Event.MissionSuccess || e == Event.MissionFail) {

			p2.remove(header);
		}
	}

	private void paintCard(Mission mission) {
		String[] cardtext = mission.nextCurrentCard().getString();
		int words = cardtext.length;
		String text = "";
		if (words > 1) {
			for (int i = 0; i < words; i = i + 2) {
				text = text + cardtext[i] + "		" + cardtext[i + 1] + "\n";
			}
		} else {
			text = cardtext[0];
		}

		textArea.setText(text);
		validate();
		textArea.repaint();
	}

	/** Determines the color of the foreground of the card **/
	private Color setCardFGColor(Category category) {
		Color color;
		if (category == Category.BACKWARDS) {
			color = new Color(255, 190, 190);
		} else if (category == Category.BODYTOBODY) {
			color = new Color(255, 255, 190);
		} else if (category == Category.SAMECLASS) {
			color = new Color(190, 190, 255);
		} else {
			color = new Color(190, 255, 190);
		}
		return color;
	}

	/** Determines the color of the background of the card **/
	private Color setCardBGColor(Category category) {
		Color color;
		if (category == Category.BACKWARDS) {
			color = Color.red;
		} else if (category == Category.BODYTOBODY) {
			color = Color.yellow;
		} else if (category == Category.SAMECLASS) {
			color = Color.blue;
		} else {
			color = Color.green;
		}
		return color;
	}
}
