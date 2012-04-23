package array;

public class SearchInRotatedSortedArray {

	public static boolean isLessThanByPosition(int first, int last, int a, int b) {
		if (a == b)
			return false;
		// if a and b are in the same partition
		if (a >= first && b >= first || a <= last && b <= last)
			return a < b;
		else
			return a > b;
	}

	public static int search(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] == key)
				return mid;
			else if (isLessThanByPosition(a[0], a[a.length - 1], key, a[mid]))
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 5, 6, 7, 9, 1, 2, 3 };
		for (int i = 0; i <= 10; i++)
			System.out.println(i + ": " + search(a, i));
	}

}