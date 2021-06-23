import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * A ListGraph is an extension of the AbstractGraph abstract class that uses an array of lists to represent the edges.
 */
public class BranchGraph extends AbstractGraph {

    // Data Fields //

    /**
     * An array of Lists to contain the edges
     */
    private List<Edge>[] edges;



    // Constructor //

    /**
     * Initializes BranchGraph class with given number of vertices and directed property
     * @param numV Number of vertices
     * @param directed Shows whether the graph is directed or not
     */
    public BranchGraph(int numV, boolean directed) {
        // AbstractGraph constructor
        super(numV, directed);
        // initializing Array of Lists
        edges = new List[numV];
        // Initializing List of LinkedLists
        for(int i=0; i<numV; i++)
            edges[i] = new LinkedList<>();
    }



    // Override Methods //

    @Override
    public boolean isEdge(int source, int dest) { return edges[source].contains(new Edge(source, dest)); }

    @Override
    public Edge getEdge(int source, int dest) {
        // Creating target Edge
        Edge target = new Edge(source, dest);
        // Return the Edge if any Edge in the source index contains given source and dest values
        for(Edge edge : edges[source])
            if(edge.equals(target))
                return edge;
        // If reached here, then Edge doesn't exist
        return null;
    }

    @Override
    public void insert(Edge edge) {
        int    source = edge.getSource();
        int    dest   = edge.getDest();
        double weight = edge.getWeight();

        // Adding for directed Graph
        edges[source].add(edge);

    }

    public int getSize(int source) {
        return edges[source].size();
    }

    // Iterator Method //

    /**
     * Returns an Edge Iterator for the given source vertex
     * @param source The source vertex
     * @return Edge Iterator for the given source vertex
     */
    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }
}
