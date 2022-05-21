public class dijkstras{
    public static void main(String args[]){
        int grph[][] = new int[][] { { -1, 3, -1, -1, -1, -1, -1, 7, -1 },  
    { 3, -1, 7, -1, -1, -1, -1, 10, 4 },  
    { -1, 7, -1, 6, -1, 2, -1, -1, 1 },  
    { -1, -1, 6, -1, 8, 13, -1, -1, 3 },  
    { -1, -1, -1, 8, -1, 9, -1, -1, -1 },  
    { -1, -1, 2, 13, 9, -1, 4, -1, 5 },  
    { -1, -1, -1, -1, -1, 4, -1, 2, 5 },  
    { 7, 10, -1, -1, -1, -1, 2, -1, 6 },  
    { -1, 4, 1, 3, -1, 5, 5, 6, -1 } };  

        dijkstras ob=new dijkstras();
        ob.dijkstra(grph,0);

    }

    public void dijkstra(int cost[][],int s){
        //initializing the data members
        int l=cost.length;
        int[] dist=new int[l];//to calculate minimum distance
        int prev[]=new int[l];//to keep track of the shortest path
        boolean visited[]=new boolean[l];//tracks the visited vertices
        
        //initializing the dist array and visited array
        for(int i=0;i<l;i++){
            dist[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }
        dist[s]=0;

        for(int i=0;i<l-1;i++){
            //finding min value from not visited vertices
            int min=Integer.MAX_VALUE;
            int u=-1;
            for(int j=0;j<l;j++){
                if(dist[j]<min && !visited[j]){
                    min=dist[j];
                    u=j;
                }
            }

            //making the vertex visited
            visited[u]=true;

            for(int v=0;v<l;v++){
                if(!visited[v] && cost[u][v]!=-1 && dist[u]+cost[u][v]<dist[v]){
                    dist[v]=dist[u]+cost[u][v];
                    prev[v]=u;
                }
            }
            
        }
        
        //printing the shortest path and distance from the source vertex
        System.out.println("The shortest distnace from "+s+" to all other nodes are");
        for(int j=0;j<l;j++){
            System.out.println("To " + j + " the shortest distance is: " + dist[j]);  
        }
        System.out.println("the shortest paths from "+s+" are");
        for(int j=0;j<l;j++){
            int temp=j;
            while(temp!=s){
                System.out.print(temp+"<-");
                temp=prev[temp];
            }
            System.out.println(s);
        }

    }
}

/*output
The shortest distnace from 0 to all other nodes are
To 0 the shortest distance is: 0
To 1 the shortest distance is: 3
To 2 the shortest distance is: 8
To 3 the shortest distance is: 10
To 4 the shortest distance is: 18
To 5 the shortest distance is: 10
To 6 the shortest distance is: 9
To 7 the shortest distance is: 7
To 8 the shortest distance is: 7
the shortest paths from 0 are
0
1<-0
2<-8<-1<-0
3<-8<-1<-0
4<-3<-8<-1<-0
5<-2<-8<-1<-0
6<-7<-0
7<-0
8<-1<-0
*/
