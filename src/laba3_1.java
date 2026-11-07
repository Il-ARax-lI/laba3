import Graph.*;

class laba3_1
{
    static public final Graph<Integer> graph = new Graph<Integer>()
            .addVertex(new Vertex<Integer>(1))
            .addVertex(new Vertex<Integer>(2))
            .addVertex(new Vertex<Integer>(3))
            .addVertex(new Vertex<Integer>(4))
            .addVertex(new Vertex<Integer>(5))
            .addVertex(new Vertex<Integer>(6))
            .addVertex(new Vertex<Integer>(7))
            .addVertex(new Vertex<Integer>(8))
            .connectVertex(1,2)
            .connectVertex(1,4)
            .connectVertex(1,5)
            .connectVertex(1,8)
            .connectVertex(2,3)
            .connectVertex(2,4)
            .connectVertex(2,7)
            .connectVertex(3,8)
            .connectVertex(4,5)
            .connectVertex(4,6)
            .connectVertex(5,6)
            .connectVertex(5,8)
            .connectVertex(6,7)
            .connectVertex(6,8);
    void main()
    {
        graph.printGraph();
        IO.println();
        graph.printHamiltonianCycle();
        graph.printEulerianCycle();
        //IO.println(graph.getVertex(1).getValue());
    }
}