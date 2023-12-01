package LT8_22001605_HoangThietLam.bai1;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {


        // Insert vertices
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String>[] vertices = new Vertex[]{vertexA,vertexB,vertexC};

        Graph<String,String> graph = new Graph<>(3,vertices); // Create an undirected graph

        // Insert edges
        graph.insertEdge(vertexA, vertexB, "Edge from A to B");
        graph.insertEdge(vertexB, vertexC, "Edge from B to C");
        graph.insertEdge(vertexC, vertexA, "Edge from C to A");
        System.out.println("Number of vertices: " + graph.numVertices()); // Output: 3
        System.out.println("Number of edges: " + graph.numEdges()); // Output: 3

        // Print the incident edges of vertex B
        System.out.println("Incident edges of vertex B:");
        Iterator<Edge<String>> edgeIterator = graph.edges();
        while (edgeIterator.hasNext()) {
            Edge<String> edge = edgeIterator.next();
            if (edge != null) {
                if (edge.getStartPoint().equals(vertexB)  || edge.getEndPoint().equals(vertexB)) {
                    System.out.println(edge.getElement());
                }
            }
        }


        // Print the number of vertices and edges after removal
        System.out.println("Number of vertices : " + graph.numVertices()); // Output: 3
        System.out.println("Number of edges: " + graph.numEdges()); // Output: 3
    }
}
