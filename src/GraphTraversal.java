import java.util.*;
public class GraphTraversal {
    static void addEdge(ArrayList<ArrayList<Integer>>graph,int u,int v) {
       graph.get(u).add(v);
       graph.get(v).add(u);
    }
    static void bfs ( ArrayList<ArrayList<Integer>>graph,int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(start);
        visited[start]=true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current+" ");
            for(int neighbor : graph.get(current)) {
                if(!visited[neighbor]) {
                    visited[neighbor]=true;
                    queue.offer(neighbor);
                }
            }
        }
    }
    static void dfs ( ArrayList<ArrayList<Integer>>graph,int current,boolean[] visited) {
        visited[current]=true;
        System.out.print(current+" ");
        for(int neighbor : graph.get(current)) {
            if(!visited[neighbor]) {
                dfs(graph,neighbor,visited);
            }
        }
    }
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
        for(int i = 0;i < vertices ; i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,3);
        addEdge(graph,1,4);
        addEdge(graph,2,5);
        System.out.print("BFS:");
        bfs(graph,0);
        System.out.println();
        System.out.print("DFS:");
        boolean[] visited = new boolean[vertices];
        dfs(graph,0,visited);
    }
}