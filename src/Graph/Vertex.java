package Graph;

import java.util.*;

public class Vertex<T> {
    private final int _id;
    private final Map<Integer, Vertex<T>> _connectVertex = new HashMap<>();
    private final Map<Integer, Integer> _costWays = new HashMap<>();
    private T value;

    public Vertex(int id)
    {
        _id = id;
    }
    public Vertex(int id, T data)
    {
        _id = id;
        value = data;
    }

    public int getId() { return _id; }

    public Vertex<T> setValue(T v){ value = v; return this; }
    public T getValue(){ return value; }

    public void addVertex(Vertex<T> v)
    {
        _connectVertex.put(v.getId(), v);
        _costWays.put(v.getId(), 0);
    }
    public void addVertex(Vertex<T> v, int cost)
    {
        _connectVertex.put(v.getId(), v);
        _costWays.put(v.getId(), cost);
    }
    public Map<Integer, Vertex<T>> getConnections() { return _connectVertex; }
    public Integer getCost(int id)
    {
        return _costWays.get(id);
    }
    public boolean hamiltonianCycle(Stack<Integer> cycle, Integer countVertex)
    {
        for(Vertex<T> vertex : _connectVertex.values())
        {
            if(cycle.size() == countVertex && vertex.getId() == cycle.getFirst()) { return true; }
            if(cycle.search(vertex.getId()) != -1) { continue; }
            cycle.push(vertex.getId());
            if(vertex.hamiltonianCycle(cycle, countVertex)) { return true; }
            cycle.pop();
        }
        return false;
    }

    public void printConnections()
    {
        System.out.printf("%d -> ", _id);
        for (var id : _connectVertex.keySet()) {
            System.out.printf("%d ", _connectVertex.get(id).getId());
        }
        IO.println();
    }

    public boolean eulerianCycle(Stack<Integer> cycle, int countConnections) {
        for(Vertex<T> vertex : _connectVertex.values())
        {
            boolean hasConnect = false;
            for(int i = 0; i < cycle.size() - 1; i++)
            {
                if(cycle.get(i) == getId() && cycle.get(i + 1) == vertex.getId() ||
                        cycle.get(i + 1) == getId() && cycle.get(i) == vertex.getId()) {
                    hasConnect = true;
                    break;
                }
            }
            if(hasConnect) { continue; }
            if(cycle.size() == countConnections && vertex.getId() == cycle.getFirst()) { return true; }
            cycle.push(vertex.getId());
            if(vertex.eulerianCycle(cycle, countConnections)) { return true; }
            cycle.pop();
        }
        return false;
    }

}
