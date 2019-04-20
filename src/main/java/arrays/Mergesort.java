package arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] data = new int[]{1, 4, 3, 10, 12, 15, 7, 8};
        mergesort(data);
        for (int item : data) {
            System.out.print(item + " ");
        }
    }

    public static int[] mergesort(int[] arr) {
        int arrSize = arr.length;
        if (arrSize < 2) {
            return arr;
        }
        int middpoint = arrSize / 2;

        int[] left = new int[middpoint];
        int[] right = new int[arrSize - middpoint];

        for (int i = 0; i < middpoint; i++) {
            left[i] = arr[i];
        }

        for (int i = middpoint; i < arrSize; i++) {
            right[i - middpoint] = arr[i];
        }

        mergesort(left);
        mergesort(right);

        return merge(left, right, arr);
    }

    /**
     * @param l is the left subarray
     * @param r is the right subarray
     * @param p is the parent array
     */
    public static int[] merge(int[] l, int[] r, int[] p) {
        int i, j, k;
        i = j = k = 0;
        int lSize = l.length;
        int rSize = r.length;

        // Comparisons
        while (i < lSize && j < rSize) {
            if (l[i] <= r[j]) {
                p[k++] = l[i++];
            } else {
                p[k++] = r[j++];
            }
        }

        // Exhaust level 1
        while (i < lSize) {
            p[k++] = l[i++];
        }

        // Exhaust level 2
        while (j < rSize) {
            p[k++] = r[j++];
        }

        // Sorted sub-solution
        return p;
    }
}
