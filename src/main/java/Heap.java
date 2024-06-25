import java.util.*;

public class Heap {
  private List<Integer> heap;

  public Heap() {
    this.heap = new ArrayList<Integer>();
  }

  private int leftChild(int index) {
    return index * 2 + 1;
  }

  private int rightChild(int index) {
    return index * 2 + 2;
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private void swap(int index1, int index2) {
    int temp = heap.get(index1);
    heap.set(index1, heap.get(index2));
    heap.set(index2, temp);
  }

  public void insert(int value) {
    heap.add(value);

    int current = heap.size() - 1;
    while (current > 0 && (heap.get(current) > heap.get(parent(current)))) {
      swap(current, parent(current));
      current = parent(current);
    }
  }

  private void sinkdown(int index) {
    int maxIndex = index;
    while (true) {
      int indexLeft = leftChild(index);
      int indexRight = rightChild(index);
      if (indexLeft < heap.size() && heap.get(indexLeft) > heap.get(maxIndex)) {
        maxIndex = indexLeft;
      }
      if (indexRight < heap.size() && heap.get(indexRight) > heap.get(maxIndex)) {
        maxIndex = indexRight;
      }

      if (index != maxIndex) {
        swap(index, maxIndex);
        index = maxIndex;
      } else {
        return;
      }
    }
  }

  public Integer remove() {
    if (heap.size() == 0) {
      return null;
    }

    if (heap.size() == 1) {
      return heap.remove(0);
    }

    int maxValue = heap.get(0);

    heap.set(0, heap.remove(heap.size() - 1));
    sinkdown(0);

    return maxValue;
  }

  public void printHeap() {
    System.out.println(heap);
  }

}