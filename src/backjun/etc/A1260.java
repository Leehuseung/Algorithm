package backjun.etc;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Graph {
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		Node(int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	Node[] nodes;
	
	Graph(int size){
		nodes = new Node[size];
		for(int i = 0; i < size; i++) {
			nodes[i] = new Node(i+1);
		}
	}
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1-1];
		Node n2 = nodes[i2-1];
		
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}

	void visit(Node n) {
		System.out.print(n.data + " ");
	}
	
	
	void dsfR(Node r) {
		if(r == null) return;
		r.marked = true;
		visit(r);
		r.adjacent.sort(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o1.data > o2.data) {
					return 1; 
				}else if(o1.data < o2.data) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for(Node n : r.adjacent) {
			if(n.marked == false) {
				dsfR(n);
			}
		}
	}
	
	void dfsR(int n) {
		dsfR(nodes[n]);
	}
	
	void bfs(int n) {
		Node root = nodes[n];
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		root.marked = true;
		while(!queue.isEmpty()) {
			Node r = queue.poll();
			r.adjacent.sort(new Comparator<Node>() {
				public int compare(Node o1, Node o2) {
					if(o1.data > o2.data) {
						return 1; 
					}else if(o1.data < o2.data) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for(Node a : r.adjacent) {
				if(a.marked == false) {
					a.marked = true;
					queue.add(a);
				}
			}
			visit(r);
		}
		
	}
	
	public void refreshTarget() {
		for(int i = 0 ; i < nodes.length; i++) {
			LinkedList list = nodes[i].adjacent;
			
			for(int j = 0 ; j < list.size(); j++) {
				Node node = (Node)list.get(j);
				node.marked = false;
			}
		}
		
	}
	
}

public class A1260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정점의 개수
		int N = sc.nextInt();
		
		Graph graph =  new Graph(N);
		
		//간선의 개수
		int M = sc.nextInt();
		//탐색을 시작할 번호
		int V = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			graph.addEdge(sc.nextInt(), sc.nextInt());
		}
		
		graph.dfsR(V-1);
		System.out.println();
		graph.refreshTarget();
		
		graph.bfs(V-1);
		
	}
}
