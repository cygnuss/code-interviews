package dp;

/*
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water 
 * it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

	public static int trap2(int[] a) {
		if (a.length == 0 || a.length == 1)
			return 0;
		int total = 0;
		int highest = 0;
		for (int i = 1; i < a.length; i++)
			if (a[i] > a[highest])
				highest = i;
		int left = 0;
		for (int i = 1; i < highest; i++)
			if (a[i] < a[left])
				total += a[left] - a[i];
			else
				left = i;
		int right = a.length - 1;
		for (int i = a.length - 2; i > highest; i--)
			if (a[i] < a[right])
				total += a[right] - a[i];
			else
				right = i;
		return total;
	}
	
	public static int trap(int[] height) {
		if (height == null || height.length <= 1) return 0;
		
		int[] l = new int[height.length]; // l[i]: max height on the left of the i-th bar
		int[] r = new int[height.length]; // r[i]: max height on the right of the i-th bar

		for (int i = 1; i < height.length; i++)
			l[i] = Math.max(l[i - 1], height[i - 1]);
		for (int i = height.length - 2; i >= 0; i--)
			r[i] = Math.max(r[i + 1], height[i + 1]);
		
		int water = 0;
		for (int i = 0; i < height.length; i++) {
			int smallerHeightLeftAndRight = Math.min(l[i], r[i]);
			if (smallerHeightLeftAndRight > height[i]) {
				// trapped water is the difference
				water += smallerHeightLeftAndRight - height[i];
			}
		}
		return water;
    }
	
	public static void main(String[] s) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}
