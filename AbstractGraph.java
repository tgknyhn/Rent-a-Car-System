import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AbstractGraph implements Graph {

    // Data Fields //

    /**
     * Number of vertices
     */
    private int numV;

    /**
     * Shows whether the Graph is directed or not
     */
    private boolean directed;



    // Constructor //

    public AbstractGraph(int numV, boolean directed) {
        this.numV     = numV;
        this.directed = directed;
    }



    // Override Methods - Implemented //

    @Override
    public int getNumV() { return numV; }

    @Override
    public boolean isDirected() { return directed; }



    // Override Methods - Not implemented //

    @Override
    public void insert(Edge edge) { }

    @Override
    public boolean isEdge(int source, int dest) { return false; }

    @Override
    public Edge getEdge(int source, int dest) { return null; }

    @Override
    public Iterator<Edge> edgeIterator(int source) { return null; }



    // AbstractGraph Methods //

    public Graph createGraph(File provinces) throws FileNotFoundException {
        // Scanner for the File
        Scanner scan = new Scanner(provinces);

        // Getting plate numbers of the provinces and inserting them into a map
        Map<String, Integer> provinceMap = new HashMap<>();

        int plateNum;
        String province;

        for(int i=1; i<numV; i++) {
            // Getting plate number
            plateNum = Integer.parseInt(scan.nextLine());
            // Getting province
            province = scan.nextLine();

            // Adding it to the Map
            provinceMap.put(province, plateNum);
        }

        int neighborCount;
        // Inserting edges for the provinces
        for(int i=1; i<numV; i++) {
            // Empty line
            scan.nextLine();
            // Plate number of the current province
            plateNum = Integer.parseInt(scan.nextLine());
            // Number of neighbors
            neighborCount = Integer.parseInt(scan.nextLine());
            // Inserting edges
            for (int j = 0; j < neighborCount; j++)
                insert(new Edge(plateNum, provinceMap.get(scan.nextLine())));
        }

        scan.close();

        return this;
    }
}


