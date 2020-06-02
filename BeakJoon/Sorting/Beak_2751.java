import java.io.*;

class HeapSort {
	public static void heapSort(int[] arr, int num) {
		Heap heap = new Heap(num);
		for (int i = 0; i < arr.length; i++)
			heap.insertHeap(arr[i]);

		for (int i = arr.length - 1; i >= 0; --i)
			arr[i] = heap.deleteHeap();
	}
}

class Heap {
	private static int heapSize;
	private static int itemHeap[];

	public Heap(int num) {
		heapSize = 0;
		itemHeap = new int[num + 1];
	}

	public static void insertHeap(int item) {
		int i = ++heapSize;

		while ((i != 1) && (item > itemHeap[i / 2])) {
			itemHeap[i] = itemHeap[i / 2];
			i /= 2;
		}

		itemHeap[i] = item;
	}

	public static int deleteHeap() {
		int parent, child;
		int item, tmp;
		item = itemHeap[1];
		tmp = itemHeap[heapSize--];
		parent = 1;
		child = 2;

		while (child <= heapSize) {
			if ((child < heapSize) && (itemHeap[child] < itemHeap[child + 1]))
				child++;
			if (tmp >= itemHeap[child])
				break;

			itemHeap[parent] = itemHeap[child];
			parent = child;
			child *= 2;
		}

		itemHeap[parent] = tmp;
		return item;
	}

}

public class Beak_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(sc.readLine());
		int arr[] = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sc.readLine());
		}

		HeapSort.heapSort(arr, num);

		for (int i : arr)
			System.out.println(i);

	}
}
