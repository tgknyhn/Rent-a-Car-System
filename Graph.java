import java.util.Iterator;

public interface Graph {
    /**
     * Returns the number of vertices
     * @return Number of vertices
     */
    int getNumV();

    /**
     * Determine whether this is a directed graph
     * @return True if this is a directed graph
     */
    boolean isDirected();

    /**
     * Inserts a new edge to the graph
     * @param edge New edge that will be added
     */
    void insert(Edge edge);

    /**
     * Determine whether an edge exist with given source and destination vertices
     * @param source The source vertex
     * @param dest The destination vertex
     * @return True if there is an edge with given source and destination vertices
     */
    boolean isEdge(int source, int dest);

    /**
     * Returns the edge with given vertices
     * @param source The source vertex
     * @param dest The destination vertex
     * @return Edge with given vertices
     */
    Edge getEdge(int source, int dest);

    /**
     * Returns an iterator to the edges connected to a given vertex
     * @param source The source vertex
     * @return An iterator to the vertices connected to the source
     */
    Iterator<Edge> edgeIterator(int source);
}
