import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.Map;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;



public class Aufg18{

	public static void main(String[] args) throws Exception{
			Node root = buildNodes();
			List<Node> way = aStar(root);
			int sum = 0;			
			for(Node node: way){
				System.out.println(node.val);
				sum = sum + node.val;
			}
			System.out.println(sum);
	}


	public static List<List<Integer>> getLines() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
		String line = null;
		List<List<Integer>> lines = new ArrayList<List<Integer>>();
		while ((line = reader.readLine()) != null) {
			List<Integer> numbers = new ArrayList<Integer>();
			for(String n: line.split(" "))    		
				numbers.add(numbers.size(), new Integer(n));
			lines.add(lines.size(), numbers);
		}
		return lines;
	}

	private static class Node{
		public Integer val;
		public Node parent;
		public List<Node> childs = new ArrayList<Node>();
		public Node(int val){
			this.val = val;
		}
	
		public String toString(){
			String childString = "";
			for(Node node: childs)
				childString += node.val + ", ";
			return "Self: " + val + " Child Vals: " + childString;
		}

		public  boolean leaf(){
		if(childs.size() == 0)
			return true;
		else
			return false;
		}

		public  int height(){
			if(leaf())
				return 1;
			else{
				return childs.get(1).height() + 1;
			}
		}

		

	}

	public static Node buildNodes() throws Exception{
		List<List<Integer>> lines = getLines();
		List<List<Node>> nodeLines = new ArrayList<List<Node>>();				
		for(int i = 0; i < lines.size(); i++){
			List<Node> nodes = new ArrayList<Node>();
			for(int j = 0; j < lines.get(i).size(); j++){
				nodes.add(nodes.size(), new Node(lines.get(i).get(j)));
			}
			nodeLines.add(nodeLines.size(), nodes);
		}
		List<Node> nodes = new ArrayList<Node>();
		for(int i = 0; i < nodeLines.size(); i++){
			for(int j = 0; j < lines.get(i).size(); j++){
				Node node = nodeLines.get(i).get(j);
				nodes.add(nodes.size(), node);
				if(i+1 <= nodeLines.size() - 1){				
					node.childs.add(nodeLines.get(i+1).get(j));
					node.childs.add(nodeLines.get(i+1).get(j+1));
				}			
			}
		}


		return nodes.get(0);


	}

	public static List<Node> aStar(Node root){
		List<Node> open = new ArrayList<Node>();
		List<Node> closed = new ArrayList<Node>();
		Map<Node, Node> cameFrom = new HashMap<Node, Node>();		
		final Map<Node, Integer> wayScore = new HashMap<Node, Integer>();
		wayScore.put(root, root.val);
		

		open.add(root);
		while(open.size() > 0){
			Collections.sort(open, new Comparator<Node>(){
				public int compare(Node n1, Node n2){
					return Integer.compare(wayScore.get(n1) + heuristic(n1), wayScore.get(n2) + heuristic(n2));
				}
			});
			Node current = open.get(open.size()-1);
			//System.out.println(open);
			//System.out.println(current);

			if(current.leaf()){
				return buildPath(cameFrom, current); 
			}
			open.remove(current);
			closed.add(current);

			for(Node child: current.childs){
				if(closed.contains(child))
					continue;
				int tentativeWayScore = wayScore.get(current) + child.val;
			
				if(!open.contains(child) || tentativeWayScore > wayScore.get(child)){
					cameFrom.put(child, current);
					wayScore.put(child, tentativeWayScore);
					if(!open.contains(child))
						open.add(open.size(), child);
				}

			}

		}
		return null;
		
	}

	private static List<Node> buildPath(Map<Node, Node> cameFrom, Node current){
		System.out.print("build:");
		System.out.println(current);
		List<Node> way = new ArrayList<Node>();		
		if(cameFrom.containsKey(current)){
		    List<Node>  p = buildPath(cameFrom, cameFrom.get(current));
			way.addAll(p);
			way.add(way.size(), current);
			return way;
		}else{
			way.add(current);		    
			return way;
		}

	}

	public static int heuristic(Node node){
		return node.val + (node.height()-1) * 99;
	}	



	

}
