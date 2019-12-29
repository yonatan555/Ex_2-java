package gui;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;

import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.main;
import dataStructure.node_data;
import algorithms.Graph_Algo;
import algorithms.graph_algorithms;

public class graph_gui extends JFrame  implements ActionListener {

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
		menuBar.add(menu);
		this.setMenuBar(menuBar);

		MenuItem item1 = new MenuItem("Paint_Graph");
		item1.addActionListener(this);
		menu.add(item1);

		MenuItem item2 = new MenuItem("Save");
		item2.addActionListener(this);
		menu.add(item2);

		MenuItem item3 = new MenuItem("Load");
		item3.addActionListener(this);
		menu.add(item3);

		MenuItem item4 = new MenuItem("Is Connected");
		item4.addActionListener(this);
		menu.add(item4);

		MenuItem item5 = new MenuItem("Shortest_Path_Dist");
		item5.addActionListener(this);
		menu.add(item5);

		MenuItem item6 = new MenuItem("Shortest_Path");
		item6.addActionListener(this);
		menu.add(item6);

		MenuItem item7 = new MenuItem("TSP");
		item7.addActionListener(this);
		menu.add(item7);

	}

	public void paint(Graphics g) {

		super.paint(g);

		node_data dest = null;
		if (this.grp != null) {
			for (node_data no : this.grp.getV()) {
				g.setColor(Color.BLUE);
				g.fillOval(no.getLocation().ix(), no.getLocation().iy(), 20, 20); // draw src point
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.drawString("" + no.getKey(), no.getLocation().ix(), no.getLocation().iy() + 1); // draw the num of src point
				
				for (edge_data ed : this.grp.getE(no.getKey())) {
					dest = this.grp.getNode(ed.getDest());
					g.setColor(Color.RED);
					g.drawLine(no.getLocation().ix(), no.getLocation().iy(), dest.getLocation().ix(), // draw edge point
							dest.getLocation().iy());
					g.setColor(Color.black);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
					g.drawString("" + ed.getWeight(), (no.getLocation().ix() + dest.getLocation().ix()) / 2, // draw weight of edge point
							((no.getLocation().iy() + dest.getLocation().iy()) / 2) + 1);
					g.setColor(Color.YELLOW);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
					g.fillOval(dest.getLocation().ix() - 5, dest.getLocation().iy() - 3, 10, 10); // draw enterance point 
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String op = e.getActionCommand();
		if (op.equals("Paint_Graph")) {
			System.out.println("sss");
			repaint();
		}
		else if (op.equals("Save")) {
			repaint();
		}
		else if (op.equals("Load")) {
			repaint();
		}
		else if (op.equals("Is Connected")) {
			
			isConnected();
			repaint();
		}
		else if (op.equals("Shortest_Path_Dist")) {
			repaint();
		}
		else if (op.equals("Shortest_Path")) {
			repaint();
		}
		else if (op.equals("TSP")) {
			repaint();
		}
	}

	private void isConnected() {
		Graph_Algo m = new Graph_Algo();
		m.init(this.grp);
		System.out.println(m.isConnected());
		
		System.out.println("sss");
	}

	private void Save(String file_name) {
		try {
			FileOutputStream file = new FileOutputStream(file_name);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this);
			out.close();
			file.close();
			System.out.println("Object has been serialized");
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

	public void Load(String file_name) { // init from fiile

		Graph_Algo gr = null;
		try {
			FileInputStream file = new FileInputStream(file_name);
			ObjectInputStream in = new ObjectInputStream(file);

			gr = (Graph_Algo) in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized");
			System.out.println(gr.m);
		} 
		catch (IOException ex) {
			System.out.println("IOException is caught");
		}
		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
	}

	private void Shortest_Path_Dist() {
		Graph_Algo m = new Graph_Algo();
		m.init(this.grp);
		m.shortestPathDist(1, 2);
	}

	private void Shortest_Path() {
		Graph_Algo m = new Graph_Algo();
		m.init(this.grp);
		m.shortestPath(1, 3);
	}
	private void TSP(){
		Graph_Algo m = new Graph_Algo();
		m.init(this.grp);
		m.TSP(1, 3);
	}
}
