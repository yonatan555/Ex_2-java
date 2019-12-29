package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JFrame;

import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

public class graph_gui extends JFrame implements ActionListener, MouseListener {
	graph grp;

	public graph_gui() {
		initGUI();
	}

	public graph_gui(graph g) {
		this.grp = g;
		initGUI();
	}

	private void initGUI() {

		this.setSize(900, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MenuBar menuBar = new MenuBar();

		Menu menu = new Menu("Menu");
		//Menu graph = new Menu("Graph");

		menuBar.add(menu);
		//menuBar.add(graph);

		this.setMenuBar(menuBar);

		MenuItem item1 = new MenuItem("Paint_Graph");
		item1.addActionListener(this);
		menu.add(item1);
		
		/*MenuItem item1 = new MenuItem("Save");
		item1.addActionListener
		(this);
		MenuItem item2 = new MenuItem("Load");
		item2.addActionListener(this);
		MenuItem item3 = new MenuItem("Is Connected");
		item1.addActionListener(this);
		MenuItem item4 = new MenuItem("Shortest Path");
		item2.addActionListener(this);
		MenuItem item5 = new MenuItem("Shortest");
		item1.addActionListener(this);
		MenuItem item6 = new MenuItem("Paint Graph");
		item2.addActionListener(this);
		*/
		/*menu.add(item2);
		graph.add(item6);
		graph.add(item3);
		graph.add(item4);
		graph.add(item5);
		 */
		//this.addMouseListener(this);
	}

	public void paint(Graphics g) {

		
		super.paint(g);
		
		
		node_data dest = null;

		if (this.grp != null) {
			for (node_data no : this.grp.getV()) {
				
				g.setColor(Color.BLUE);
				g.fillOval(no.getLocation().ix(), no.getLocation().iy(), 10, 10); 							// draw src point
				g.drawString("" + no.getKey(), no.getLocation().ix(), no.getLocation().iy() + 1); 			// draw the num of src point
				for (edge_data ed : this.grp.getE(no.getKey())) {
					
					dest = this.grp.getNode(ed.getDest());
					g.setColor(Color.RED);
					g.drawLine(no.getLocation().ix(), no.getLocation().iy(), dest.getLocation().ix(), 		// draw edge point
							dest.getLocation().iy());
					g.setColor(Color.CYAN);
					g.drawString("" + no.getKey(), (no.getLocation().ix() + dest.getLocation().ix()) / 2, 	// draw weight of edge point													
							((no.getLocation().iy() + dest.getLocation().iy()) / 2) + 1);
					g.setColor(Color.YELLOW);																//draw enterance point  
					g.fillOval(dest.getLocation().ix(), dest.getLocation().iy(), 10,
							10);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String op = e.getActionCommand();

		if (op.equals("Paint_Graph")) {
			repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
