import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEvent.Vertex;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.visualization.renderers.*;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel;
import edu.uci.ics.jung.algorithms.shortestpath.*;
public class SuspectsNetwork extends JFrame{
	private JPanel panel;
	private Registry reg;
	private JLabel diameter;

	public SuspectsNetwork(Registry reg) {
		UndirectedSparseGraph<String, String> g = new UndirectedSparseGraph<String, String>();
		this.reg = reg;
		
		ArrayList<Suspect> suspects = new ArrayList<>();
		suspects = reg.getSuspects();
		
		
		for(Suspect s : suspects) {
			g.addVertex(s.getCodeName());
		}
		Integer i = 0;
		
		for(Suspect s : suspects)
		{
			for(Suspect su : s.getPossiblePartners()) {
				if((g.findEdge(s.getCodeName(),su.getCodeName())==null)){
				
					g.addEdge( i.toString(), s.getCodeName(), su.getCodeName(), EdgeType.UNDIRECTED);
					i++;
				}
			}
				
		}
		
		
		
		VisualizationImageServer<String,String> vis = new VisualizationImageServer<String,String>(new CircleLayout<String,String>(g), new Dimension(420,420));

		vis.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());//VAZEI WS ETIKETA STIS KORYFES TO ONOMA TOYS, DLD TO CODE NAME KATHE YPOPTOY
		panel = new JPanel(new BorderLayout());
		
		diameter = new JLabel("Diameter = " + DistanceStatistics.diameter(g));

		panel.add(diameter,BorderLayout.PAGE_END);
		
		this.setContentPane(panel);
		this.getContentPane().add(vis,BorderLayout.CENTER);
			
		this.setVisible(true);
		this.setSize(600,600);
		this.setTitle("Suspects Network");
	}
	 
	



}
