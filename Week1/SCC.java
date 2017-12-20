import java.io.*;
import java.util.*;
import java.util.LinkedList;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    //private int count;
    private int[] sccNum;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
        this.sccNum = new int[V];
        //count = 0;
    }

    void addEdge(int v, int w) {
        adj[v - 1].add(w - 1);
    }

    void DFSUtil(int v, boolean visited[] , int count) {
        visited[v] = true;
        //printing statement was here
        this.sccNum[count]++;
         //System.out.println("sccNum incremented with count = " + count);
        int n;

        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited , count);
            }
        }
    }

    Graph getTranspose() {
        Graph g = new Graph(V);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                g.adj[i.next()].add(v);
            }
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack) {
        visited[v] = true;
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                fillOrder(n, visited, stack);
            }
        }
        stack.push(new Integer(v));
    }

    void countSCC(int count) {
        Stack stack = new Stack();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                fillOrder(i, visited, stack);
            }
        }
        Graph gr = getTranspose();

        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        while (stack.empty() == false) {
            int v = (int) stack.pop();

            if (visited[v] == false) {
                gr.DFSUtil(v, visited , count);
                count++;
                //System.out.println("count = " + count);
                //System.out.println();
            }
        }
        gr.output();
    }

    void output() {
        Arrays.sort(sccNum);
        for (int i = 0; i < this.sccNum.length - 1; i++) {
            if(this.sccNum[i] != 0)
            System.out.println(this.sccNum[i]);
        }
        // for (int i = 0; i <  10; i++) {
        //     System.out.println(sccNum[i]);
        // }
    }
}

class scc {
    static void dfs(graph g) {
        //for(int i = )
    }

    public static void main(String args[]) throws IOException {
        Graph g = new Graph(875714);
        //Graph g1 = new Graph(87514);
        //File file = new File("./SCC.txt");
        File file = new File("./SCC.txt");
        Scanner sc = new Scanner(file);
        // Scanner sc = new Scanner(System.in);
        //String st;
        //int count = 0;
        while (sc.hasNext()) {
            try{
                int a = sc.nextInt();
                int b = sc.nextInt();
                g.addEdge(a, b);
            }
            catch(Exception e){
                break;
            }
            
            //g1.addEdge(b, a);
            //count++;
        }
        g.countSCC(0);
        g.output();
        //g1.DFS();

    }
}
