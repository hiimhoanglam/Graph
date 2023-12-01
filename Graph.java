package LT8_22001605_HoangThietLam.bai1;

import java.util.Iterator;

/*
Tạo giao diện và cài đặt kiểu dữ liệu đồ thị vô hướng không có trọng số (U/U) sử dụng ma trận kề.
Tham khảo các phương thức trong slide bài giảng hoặc sách M.Goodrich, tiểu mục 14.1.1, trang
618.
 */
public class Graph<E,V> implements GraphInterface<E,V> {
    private int n;
    private Edge<E>[][] matrix;
    private Vertex<V>[] vertices;

    public Graph(int n, Vertex<V>[] vertices) {
        this.n = n;
        this.matrix = new Edge[n][n];
        this.vertices = vertices;
    }

    public Graph(int n) {
        this.n = n;
        this.matrix = new Edge[n][n];
        this.vertices = new Vertex[n];
    }

    @Override
    public int numVertices() {
        return n;
    }
    private int index = 0;
    @Override
    public Iterator<Vertex<V>> vertices() {

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index + 1 < vertices.length;
            }

            @Override
            public Vertex<V> next() {
                Vertex<V> result = vertices[index];
                index++;
                return result;
            }
        };
    }

    @Override
    public int numEdges() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != null) {
                    count++;
                }
            }
        }
        return count;
    }
    int startEdge = 0;
    int endEdge = 0;
    @Override
    public Iterator<Edge<E>> edges() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return startEdge < n && endEdge < n;
            }

            @Override
            public Edge<E> next() {
                if (startEdge > n || endEdge > n) {
                    return null;
                }
                Edge<E> result = matrix[startEdge][endEdge];
                if (endEdge + 1 > n) {
                    startEdge++;
                    endEdge = 0;
                }
                else {
                    endEdge++;
                }
                return result;
            }
        };
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        int starting = 0;
        int ending = 1;
        for (int i = 0; i < n; i++) {
            if (u.equals(vertices[i])) {
                starting = i;
            }
            else if (v.equals(vertices[i])) {
                ending = i;
            }
        }
        return matrix[starting][ending];
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> e) {
        Vertex<V>[] result = (Vertex<V>[]) new Object[2] ;
        result[0] = e.getStartPoint();
        result[1] = e.getEndPoint();
        return result;
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        if (!e.getStartPoint().equals(v) && !e.getEndPoint().equals(v)) {
            return null;
        }
        if (e.getStartPoint() != v) {
            return e.getEndPoint();
        }
        return e.getStartPoint();
    }

    @Override
    public int outDegree(Vertex<V> v) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (v.equals(vertices[i])) {
                index = i;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[index][j] != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int inDegree(Vertex<V> v) {
        return outDegree(v);
    }

    @Override
    public Iterator<Edge<E>> outgoingEdges(Vertex<V> v) {
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (v.equals(vertices[i])) {
                index = i;
                break;
            }
        }
        int finalIndex = index;
        return new Iterator<>() {
            int j = 1;
            @Override
            public boolean hasNext() {
                return j < n;
            }

            @Override
            public Edge<E> next() {
                Edge<E> result = matrix[finalIndex][j];
                j++;
                return result;
            }
        };
    }

    @Override
    public Iterator<Edge<E>> incomingEdges(Vertex<V> v) {
        return outgoingEdges(v);
    }


    @Override
    public void insertEdge(Vertex<V> u, Vertex<V> v, E x) {
        int starting = 0;
        int ending = 1;
        for (int i = 0; i < n; i++) {
            if (u.equals(vertices[i])) {
                starting = i;
            }
            else if (v.equals(vertices[i])) {
                ending = i;
            }
        }
        if (matrix[starting][ending] == null) {
            matrix[starting][ending] = new Edge<>(x,u,v);
        }
    }

    @Override
    public void removeEdge(Edge<E> e) {
        Vertex<V> start = e.getStartPoint();
        Vertex<V> end = e.getEndPoint();
        int starting = 0;
        int ending = 1;
        for (int i = 0; i < n; i++) {
            if (start.equals(vertices[i])) {
                starting = i;
            }
            else if (end.equals(vertices[i])) {
                ending = i;
            }
        }
        matrix[starting][ending] = null;
    }
}
