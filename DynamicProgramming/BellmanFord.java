import java.util.Scanner;
public class BellmanFord{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no of vertices:");
        int v=sc.nextInt();
        System.out.print("Enter no of edges:");
        int e=sc.nextInt();
        Graph graph=new Graph(v,e);
        graph.bellmanFord(graph,0);
    }
}

class Graph{
    class Edge{
        int src,dest,weight;
        Edge(int s,int d,int w){
            src=s;
            dest=d;
            weight=w;
        }
    };
    int V,E;
    Edge edge[];
    Graph(int v,int e){
        V=v;
        E=e; 
        edge=new Edge[e];
        System.out.println("Enter src,dest,weight");
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<E;i++){
            System.out.println("Edge "+i);
            System.out.print("Enter src:");
            int s=sc.nextInt();
            System.out.print("Enter dest:");
            int d=sc.nextInt();
            System.out.print("Enter weight:");
            int w=sc.nextInt();
            edge[i]=new Edge(s,d,w);

        }
    }

    void bellmanFord(Graph graph,int src){
        int V=graph.V;
        int E=graph.E;
        int dist[]=new int[V];
        int prev[]=new int[V];
        
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
            prev[i]=src;
        }
        dist[src]=0;

        //relaxing all edges foe v-1 times to get shrtest distance
        for(int i=0;i<V-1;i++){
            for(int j=0;j<E;j++){
                int u=graph.edge[j].src;
                int v=graph.edge[j].dest;
                int w=graph.edge[j].weight;
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    prev[v]=u;
                }
            }
        }

        //checking if the graph contains negative weight cycle
        for(int j=0;j<E;j++){
            int u=graph.edge[j].src;
            int v=graph.edge[j].dest;
            int w=graph.edge[j].weight;
            if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        //printing the shortest distance and the parent nodes
        System.out.println("the shortest distance from "+src+" to");
        for(int i=0;i<V;i++){
            System.out.println(i+" is "+dist[i]);
        }

    }
}

/*input1
Enter no of vertices:5
Enter no of edges:8
Enter src,dest,weight
Edge 0
Enter src:0
Enter dest:1
Enter weight:-1
Edge 1
Enter src:0
Enter dest:2
Enter weight:4
Edge 2
Enter src:1
Enter dest:2
Enter weight:3
Edge 3
Enter src:1
Enter dest:3
Enter weight:2
Edge 4
Enter src:1
Enter dest:4
Enter weight:2
Edge 5
Enter src:3
Enter dest:2
Enter weight:5
Edge 6
Enter src:3
Enter dest:1
Enter weight:1
Edge 7
Enter src:4
Enter dest:3
Enter weight:-3
the shortest distance from 0 to
0 is 0
1 is -1
2 is 2
3 is -2
4 is 1
****************/
/*input2
$ java BellmanFord
Enter no of vertices:4
Enter no of edges:4
Enter src,dest,weight
Edge 0
Enter src:0
Enter dest:1
Enter weight:1
Edge 1
Enter src:1
Enter dest:2
Enter weight:-1
Edge 2
Enter src:2
Enter dest:3
Enter weight:-1
Edge 3
Enter src:3
Enter dest:0
Enter weight:-1
Graph contains negative weight cycle
**************/
