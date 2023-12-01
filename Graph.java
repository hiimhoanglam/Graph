package LT8_22001605_HoangThietLam.bai1;

import java.util.Iterator;

/*
Tạo giao diện và cài đặt kiểu dữ liệu đồ thị vô hướng không có trọng số (U/U) sử dụng ma trận kề.
Tham khảo các phương thức trong slide bài giảng hoặc sách M.Goodrich, tiểu mục 14.1.1, trang
618.
 */
public class Graph<E,V> implements GraphInterface<E,V> {
    @Override
    public int numVertices() {
        return 0;
    }

    @Override
    public Iterator<Vertex<V>> vertices() {
        return null;
    }

    @Override
    public int numEdges() {
        return 0;
    }

    @Override
    public Iterator<Edge<E>> edges() {
        return null;
    }

    @Override
    public Edge<E> getEdge(Vertex<V> v, Vertex<V> u) {
        return null;
    }

    @Override
    public int[] endVertices(Edge<E> e) {
        return new int[0];
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        return null;
    }

    @Override
    public int outDegree(Vertex<V> v) {
        return 0;
    }

    @Override
    public int inDegree(Vertex<V> v) {
        return 0;
    }

    @Override
    public Iterator<Edge<E>> outgoingEdges(Vertex<V> v) {
        return null;
    }

    @Override
    public Iterator<Edge<E>> incomingEdges(Vertex<V> v) {
        return null;
    }

    @Override
    public void insertVertex(E x) {

    }

    @Override
    public void insertEdge(Vertex<V> u, Vertex<V> v, E x) {

    }

    @Override
    public void removeVertex(Vertex<V> v) {

    }

    @Override
    public void removeEdge(Vertex<V> e) {

    }
}
