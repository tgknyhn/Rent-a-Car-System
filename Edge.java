public class Edge {

    // Data Fields //

    /**
     * The source vertex
     */
    private final int source;

    /**
     * The destination vertex
     */
    private final int dest;

    /**
     * Weight of the Edge
     */
    private final double weight;



    // Constructors //

    /**
     * Initializes Edge class with given source vertex and destination vertex (weight : 1.0)
     * @param source The source vertex
     * @param dest The destination vertex
     */
    public Edge(int source, int dest) {
        this.source = source;
        this.dest   = dest;
        this.weight = 1.0;
    }

    /**
     * Initializes Edge class with given weight, source vertex and destination vertex.
     * @param source The source vertex
     * @param dest The destination vertex
     * @param weight The weight of the Edge
     */
    public Edge(int source, int dest, double weight) {
        this.source = source;
        this.dest   = dest;
        this.weight = weight;
    }



    // Getters

    /**
     * Returns the source vertex
     * @return The source vertex
     */
    public int getSource() { return this.source; }

    /**
     * Returns the destination vertex
     * @return The destination vertex
     */
    public int getDest() { return this.dest; }

    /**
     * Returns the weight of the Edge
     * @return The weight of the Edge
     */
    public double getWeight() { return this.weight; }



    // Override Methods

    /**
     * Determines whether given Edge's source and dest vertices are the same with this Edge
     * @param o The Edge that will be compared
     * @return True if given Edge's source and dest vertices are the same with this Edge
     */
    public boolean equals(Object o) {
        if(!(o instanceof Edge))
            return false;
        // Down casting
        Edge secEdge = (Edge)o;
        // Returning the result
        return (getSource() == secEdge.getSource()) && (getDest() == secEdge.getDest());
    }

    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public String toString() { return "Source vertex: " + getSource() + "\tDestination Vertex: " + getDest() + "\tWeight: " + getWeight(); }

}