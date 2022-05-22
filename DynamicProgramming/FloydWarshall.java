public class FloydWarshall {
    final static int I=999999;
    public static void main(String args[]){
        
        int graph[][]= {
            { 0, I, -2, I },
            { 4, 0, 3, I },
            { I, I, 0, 2 },
            { I, -1, I, 0 }
        };;

        FloydWarshall a=new FloydWarshall();
        a.floydWarshall(graph);
    }
    public void floydWarshall(int dist[][]){
        int v=dist.length;
        //all pairs distance via each vertex
        for(int k=0;k<v;k++){
            //Pick all vertices as source one by one
            for(int i=0;i<v;i++){
                // Pick all vertices as destination for the
                // above picked source
                for(int j=0;j<v;j++){
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        //printing shortest distance between all pairs of vertices
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(i!=j){
                    System.out.println(i+" to "+j+" is "+dist[i][j]);
                }
            }
        }
    }
}
