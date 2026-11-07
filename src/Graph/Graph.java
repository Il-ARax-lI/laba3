package Graph;

import java.util.*;

public class Graph<T> {
    private final Map<Integer, Vertex<T>> _vertexes = new HashMap<Integer, Vertex<T>>();

    //private final Stack<Integer> _cycle = new Stack<Integer>();

    public Graph<T> addVertex(Vertex<T> v)
    {
        if(_vertexes.get(v.getId()) != null) return null;
        _vertexes.put(v.getId(), v);
        return this;
    }
    public Graph<T> connectVertex(int v1, int v2)
    {
        if(_vertexes.get(v1) == null && _vertexes.get(v2) == null) return null;
        _vertexes.get(v1).addVertex(_vertexes.get(v2));
        _vertexes.get(v2).addVertex(_vertexes.get(v1));
        return this;
    }
    public Graph<T> connectVertex(int v1, int v2, int cost)
    {
        if(_vertexes.get(v1) == null && _vertexes.get(v2) == null) return null;
        _vertexes.get(v1).addVertex(_vertexes.get(v2), cost);
        _vertexes.get(v2).addVertex(_vertexes.get(v1), cost);
        return this;
    }
    public Vertex<T> getVertex(int id)
    {
        return _vertexes.get(id);
    }
    public void printGraph()
    {
        for (var id : _vertexes.keySet()) {
            _vertexes.get(id).printConnections();
        }
        IO.println();
    }
    public int countConnections()
    {
        int c = 0;
        for(Vertex<T> vertex : _vertexes.values())
        {
            c += vertex.getConnections().size();
        }
        return c / 2;
    }
    public boolean isHamiltonianCycle(Stack<Integer> cycle)
    {
        //_cycle.clear();
        if (_vertexes.size() < 3) return false;
        for(Vertex<T> vertex : _vertexes.values())
        {
            cycle.push(vertex.getId());
            if(vertex.hamiltonianCycle(cycle, _vertexes.size())) { return true; }
            cycle.pop();
        }
        return false;
    }
    public boolean isEulerianCycle(Stack<Integer> cycle)
    {
        //_cycle.clear();
        if (_vertexes.size() < 3) return false;
        for(Vertex<T> vertex : _vertexes.values())
        {
            cycle.push(vertex.getId());
            if(vertex.eulerianCycle(cycle, countConnections())) { return true; }
            cycle.pop();
        }
        return false;
    }

    public void printHamiltonianCycle()
    {
        Stack<Integer> cycle = new Stack<Integer>();

        if (isHamiltonianCycle(cycle)) {
            IO.println(true);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cycle.size(); i++) {
                if (i > 0) sb.append(" -> ");
                sb.append(cycle.get(i));
            }
            IO.println(sb.toString());
        } else {
            IO.println(false);
        }
    }
    public void printEulerianCycle()
    {
        Stack<Integer> cycle = new Stack<Integer>();

        if (isEulerianCycle(cycle)) {
            IO.println(true);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cycle.size(); i++) {
                if (i > 0) sb.append(" -> ");
                sb.append(cycle.get(i));
            }
            IO.println(sb.toString());
        } else {
            IO.println(false);
        }
    }
    public Map<Integer, Integer> dijkstra(Integer id)
    {
        return null;
    }
}
