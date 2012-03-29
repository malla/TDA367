package cha.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class TileContainerPanel extends JPanel {
		
		private TilePanel[] tilePanels = new TilePanel[44];
	
	    public TileContainerPanel(){
	    	setLayout(new BorderLayout(0, 0));
	        init();    
	    }

	    private void init() {
	    	JPanel p1 = new JPanel();
	    	JPanel p2 = new JPanel();
	    	p2.setPreferredSize(new Dimension(50,0));
	    	FlowLayout flowLayout_1 = (FlowLayout) p2.getLayout();
	    	flowLayout_1.setAlignment(FlowLayout.LEFT);
	    	flowLayout_1.setVgap(0);
	    	flowLayout_1.setHgap(0);
	    	JPanel p3 = new JPanel();
	    	FlowLayout flowLayout_2 = (FlowLayout) p3.getLayout();
	    	flowLayout_2.setAlignment(FlowLayout.RIGHT);
	    	flowLayout_2.setVgap(0);
	    	flowLayout_2.setHgap(0);
	    	JPanel p4 = new JPanel();
	    	p4.setPreferredSize(new Dimension(50,0));
	    	FlowLayout flowLayout_3 = (FlowLayout) p4.getLayout();
	    	flowLayout_3.setAlignment(FlowLayout.RIGHT);
	    	flowLayout_3.setVgap(0);
	    	flowLayout_3.setHgap(0);
	    	FlowLayout flowLayout = (FlowLayout) p1.getLayout();
	    	flowLayout.setAlignment(FlowLayout.LEFT);
	    	flowLayout.setVgap(0);
	    	flowLayout.setHgap(0);
	    	for(int i = 0; i<14; i++){
	    		TilePanel p = new TilePanel();
	    		tilePanels[i] = p;
	    		p1.add(p);
	    	}
	    	for(int i = 14; i<22; i++){
	    		TilePanel p = new TilePanel();
	    		tilePanels[i] = p;
	    		p2.add(p);
	    	}
	    	for(int i = 22; i<36; i++){
	    		TilePanel p = new TilePanel();
	    		tilePanels[i] = p;
	    		p3.add(p);
	    	}
	    	for(int i = 36; i<44; i++){
	    		TilePanel p = new TilePanel();
	    		tilePanels[i] = p;
	    		p4.add(p);
	    	}
	    	
	    	this.add(p1, BorderLayout.NORTH);
	    	this.add(p2, BorderLayout.EAST);
	    	this.add(p3, BorderLayout.SOUTH);
	    	this.add(p4, BorderLayout.WEST);
	    }
}
