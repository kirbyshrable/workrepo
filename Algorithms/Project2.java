package Algorithms;

import java.io.*;
import java.util.*;

public class Project2 
{
	//This holds the strings of the nodes in topological order
	private static String [] top_order = new String[31];
	
	//Marks the place where the string gets place in the topological order string array
	static int place = 0;
	
	static String [] classes = new String [31];
	
	static Node el;
	
	static ArrayList<Node> nodes = new ArrayList<Node>();
	
	static Node node0;
	static Node node1;
	static Node node2;
	static Node node3;
	static Node node4;
	static Node node5;
	static Node node6;
	static Node node7;
	static Node node8;
	static Node node9;
	static Node node10;
	static Node node11;
	static Node node12;
	static Node node13;
	static Node node14;
	static Node node15;
	static Node node16;
	static Node node17;
	static Node node18;
	static Node node19;
	static Node node20;
	static Node node21;
	static Node node22;
	static Node node23;
	static Node node24;
	static Node node25;
	static Node node26;
	static Node node27;
	static Node node28;
	static Node node29;
	static Node node30;
	
	
	static class Node
	{
		String data;
		
		boolean visited;
		
		Node(String data)
		{
			this.data = data;
		}
		
		public String getData()
		{
			return data;
		}
	}
	
	public ArrayList<Node> findNeighbors(boolean adj_matrix[][], Node node)
	{
		int nodeIndex=-1;
		
		ArrayList<Node> neighbors = new ArrayList<Node>();
		
		//Finds the location of the node in question inside the arraylist
		for (int i = 0; i < nodes.size(); i++)
		{
			if (nodes.get(i).equals(node))
			{
				nodeIndex = i;
				break;
			}
		}
		
		//Runs as long as the node exists in the arraylist
		if (nodeIndex != -1)
		{
			//Checks what nodes the passed node is connected to using the adjacency matrix
			for (int j = 0; j < adj_matrix[nodeIndex].length; j++)
			{
				if (adj_matrix[j][nodeIndex] == true)
				{
					neighbors.add(nodes.get(j));
				}
			}
		}
		
		return neighbors;
	}
	
	public void dfs(boolean adj_matrix[][], Node node)
	{
		Stack<Node> stack = new Stack<Node>();
		stack.add(node);
		node.visited = true;
		
		
		while(!stack.isEmpty())
		{
			//Implement something to check if the prereqs of the item in the stack are satisfied (Both nodes in parentheses have been visited).
			int index = stack.indexOf(stack.lastElement());
			
			
			while(true)
			{
				el = stack.get(index);
				
				//Used to test if index was changed after a loop. If so, then it is made to go back through the while loop.
				int compare = index;
				
				String part = new String();
				
				//Finds the location of the node in question inside the arraylist
				for (int i = 0; i < nodes.size(); i++)
				{
					if (nodes.get(i).equals(el))
					{
						part = classes[i].substring(classes[i].indexOf('(')+1, classes[i].indexOf(')'));
						break;
					}
				}
				
				//If class has 2 prereqs
				if (part.length() == 23)
				{
					String part1 = part.substring(0, 9);
					
					String part2 = part.substring(14, 23);
					
					for(int j = 0; j < 31; j++)
					{
						String part_num = classes[j].substring(0,9);
						
						if(part_num.equals(part1))
						{
							if (nodes.get(j).visited)
							{
								if (index != 0)
								{
									index -= 1;
								}
								el = stack.get(index);
								break;
							}
						}
						
						
					}
					
					if (compare != index)
					{
						continue;
					}
					
					for(int j = 0; j < 31; j++)
					{
						String part_num = classes[j].substring(0,9);
						
						if(part_num.equals(part2))
						{
							if (nodes.get(j).visited)
							{
								if (index != 0)
								{
									index -= 1;
								}
								el = stack.get(index);
								break;
							}
						}
						
						
					}
					
					if (compare != index)
					{
						continue;
					}
				}
				
				//If class has 3 prereqs
				else if (part.length() > 24)
				{
					String part1 = part.substring(0,9);
					
					String part2 = part.substring(11,20);
					
					String part3 = part.substring(22,31);
					
					for(int j = 0; j < 31; j++)
					{
						String part_num = classes[j].substring(0,9);
						
						if(part_num.equals(part1))
						{
							if (nodes.get(j).visited)
							{
								if (index != 0)
								{
									index -= 1;
								}
								el = stack.get(index);
								break;
							}
						}
						
						
					}
					
					if (compare != index)
					{
						continue;
					}
					
					for(int j = 0; j < 31; j++)
					{
						String part_num = classes[j].substring(0,9);
						
						if(part_num.equals(part2))
						{
							if (nodes.get(j).visited)
							{
								if (index != 0)
								{
									index -= 1;
								}
								el = stack.get(index);
								break;
							}
						}
						
						
					}
					
					if (compare != index)
					{
						continue;
					}
					
					for(int j = 0; j < 31; j++)
					{
						String part_num = classes[j].substring(0,9);
						
						if(part_num.equals(part3))
						{
							if (nodes.get(j).visited)
							{
								if (index != 0)
								{
									index -= 1;
								}
								el = stack.get(index);
								break;
							}
						}
						
						
					}
					
					if (compare != index)
					{
						continue;
					}
				}
				
				
				break;
			}
			
			
			//Puts the string into the array in the order that they get popped out in
			top_order[place] = el.getData();
			
			place++;
			

			ArrayList<Node> neighbors = findNeighbors(adj_matrix, stack.get(index));
			
			
			stack.remove(index);
			
			
			for(int k = 0; k < neighbors.size(); k++)
			{
				
				Node n = neighbors.get(k);
				if(n!=null && !n.visited)
				{
					stack.add(n);
					n.visited=true;
				}
			}
			
		}
	}
	

	public static void main(String[] args) 
	{
		int i = 0;
		int j = 0;
		
		//Reads in file and puts elements into string array
		try
		{
			FileReader fr1 = new FileReader("csmajor.txt");
			BufferedReader br1 = new BufferedReader(fr1);
			
			String line = new String();
			
			while((line = br1.readLine()) != null)
			{
				classes[i] = line;
				
				
				
				
				switch (i)
				{
				case 0:
					node0 = new Node(line);
					nodes.add(node0);
					break;
				case 1:
					node1 = new Node(line);
					nodes.add(node1);
					break;
				case 2:
					node2 = new Node(line);
					nodes.add(node2);
					break;
				case 3:
					node3 = new Node(line);
					nodes.add(node3);
					break;
				case 4:
					node4 = new Node(line);
					nodes.add(node4);
					break;
				case 5:
					node5 = new Node(line);
					nodes.add(node5);
					break;
				case 6:
					node6 = new Node(line);
					nodes.add(node6);
					break;
				case 7:
					node7 = new Node(line);
					nodes.add(node7);
					break;
				case 8:
					node8 = new Node(line);
					nodes.add(node8);
					break;
				case 9:
					node9 = new Node(line);
					nodes.add(node9);
					break;
				case 10:
					node10 = new Node(line);
					nodes.add(node10);
					break;
				case 11:
					node11 = new Node(line);
					nodes.add(node11);
					break;
				case 12:
					node12 = new Node(line);
					nodes.add(node12);
					break;
				case 13:
					node13 = new Node(line);
					nodes.add(node13);
					break;
				case 14:
					node14 = new Node(line);
					nodes.add(node14);
					break;
				case 15:
					node15 = new Node(line);
					nodes.add(node15);
					break;
				case 16:
					node16 = new Node(line);
					nodes.add(node16);
					break;
				case 17:
					node17 = new Node(line);
					nodes.add(node17);
					break;
				case 18:
					node18 = new Node(line);
					nodes.add(node18);
					break;
				case 19:
					node19 = new Node(line);
					nodes.add(node19);
					break;
				case 20:
					node20 = new Node(line);
					nodes.add(node20);
					break;
				case 21:
					node21 = new Node(line);
					nodes.add(node21);
					break;
				case 22:
					node22 = new Node(line);
					nodes.add(node22);
					break;
				case 23:
					node23 = new Node(line);
					nodes.add(node23);
					break;
				case 24:
					node24 = new Node(line);
					nodes.add(node24);
					break;
				case 25:
					node25 = new Node(line);
					nodes.add(node25);
					break;
				case 26:
					node26 = new Node(line);
					nodes.add(node26);
					break;
				case 27:
					node27 = new Node(line);
					nodes.add(node27);
					break;
				case 28:
					node28 = new Node(line);
					nodes.add(node28);
					break;
				case 29:
					node29 = new Node(line);
					nodes.add(node29);
					break;
				case 30:
					node30 = new Node(line);
					nodes.add(node30);
					break;
				}
				
				i++;
			}
			
			i = 0;
		}
		
		catch (IOException e)
		{
			
		}
		
		
		//Shows if two elements in the string array are connected
		boolean [][] adj_matrix = new boolean [31][31];
		
		
		//Sets the relationship to true if the second elements is a prerequisite to the first element
		for (i = 1; i < 31; i++)
		{
			String part = classes[i].substring(classes[i].indexOf('(')+1, classes[i].indexOf(')'));
			
			
			
			//Case for if the class has 2 prerequisites
			if (part.length() == 23)
			{
				String part1 = part.substring(0, 9);
				
				String part2 = part.substring(14, 23);
				
				
				j = 0;
				
				for(j = 0; j < 31; j++)
				{
					String part_num = classes[j].substring(0,9);
					
					if(part_num.equals(part1))
					{
						adj_matrix[i][j] = true;
					}
					
					
				}
				
				j = 0;
				
				for(j = 0; j < 31; j++)
				{
					String part_num = classes[j].substring(0,9);
					
					if(part_num.equals(part2))
					{
						adj_matrix[i][j] = true;
					}
					
					
				}
				
			}
			
			//Case for if the class has 3 prerequisites
			else if (part.length() > 24)
			{
				String part1 = part.substring(0,9);
				
				String part2 = part.substring(11,20);
				
				String part3 = part.substring(22,31);
				
				for(j = 0; j < 31; j++)
				{
					String part_num = classes[j].substring(0,9);
					
					if(part_num.equals(part1))
					{
						adj_matrix[i][j] = true;
					}
					
					
				}
				
				for(j = 0; j < 31; j++)
				{
					String part_num = classes[j].substring(0,9);
					
					if(part_num.equals(part2))
					{
						adj_matrix[i][j] = true;
					}
					
					
				}
				
				for(j = 0; j < 31; j++)
				{
					String part_num = classes[j].substring(0,9);
					
					if(part_num.equals(part3))
					{
						adj_matrix[i][j] = true;
					}
					
					
				}
			}
			
			//Case for if the class has only one prerequisite
			else
			{	
				for(j = 0; j < 31; j++)
				{
					String part_num = classes[j].substring(0,9);
					
					if(part_num.equals(part))
					{
						adj_matrix[i][j] = true;
					}
					
					
				}
			}
		}
		
		Project2 proj = new Project2();
		
		proj.dfs(adj_matrix, node0);
		//proj.dfs(adj_matrix, node2);
		
		
		for (i = 0; i < 31; i++)
		{
			System.out.print(top_order[i] + "\n");
		}
	}
	
	

}
