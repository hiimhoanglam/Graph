package LT8_22001605_HoangThietLam.bai1;

import java.util.Iterator;
/*
Tạo giao diện và cài đặt kiểu dữ liệu đồ thị vô hướng không có trọng số (U/U) sử dụng ma trận kề.
Tham khảo các phương thức trong slide bài giảng hoặc sách M.Goodrich, tiểu mục 14.1.1, trang
618.
 */
public interface GraphInterface<E,V> {
    int numVertices();
    Iterator<Vertex<V>> vertices();
    int numEdges();
    Iterator<Edge<E>> edges();
    Edge<E> getEdge(Vertex<V> v, Vertex<V> u);
    int[] endVertices(Edge<E> e);
    Vertex<V> opposite(Vertex<V> v, Edge<E> e);
    int outDegree(Vertex<V> v);
    int inDegree(Vertex<V> v);
    Iterator<Edge<E>> outgoingEdges(Vertex<V> v);
    Iterator<Edge<E>> incomingEdges(Vertex<V> v);
    /*
    Remove inserting and removing edge for the sake of simplicity
     */
//    void insertVertex(E x);
    void insertEdge(Vertex<V> u, Vertex<V> v, E x);
//    void removeVertex(Vertex<V> v);
    void removeEdge(Vertex<V> e);
}
