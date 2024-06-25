public class Main {
  public static void main(String[] args) {

    Heap heap =  new Heap();

    heap.insert(1);
    heap.insert(2);
    heap.insert(3);
    heap.insert(55);
    heap.insert(44);

    heap.printHeap();

    heap.insert(100);

    heap.printHeap();

    heap.remove();

    heap.printHeap();
  }

}