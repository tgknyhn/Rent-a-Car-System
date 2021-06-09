public class Quick_sort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length-1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        int pivotIndex;

        if(low < high) {
            pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex-1);
            quickSort(array, pivotIndex+1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot      = array[low];
        int leftWall = low;

        for(int i=low+1; i<=high; i++) {
            if(array[i].compareTo(pivot) < 0) {
                swap(array, i, leftWall+1);
                leftWall++;
            }
        }

        swap(array, low, leftWall);

        return leftWall;
    }

    private static <T extends Comparable<T>> void swap(T[] array, int first, int second) {
        T temp = array[first];

        array[first] = array[second];

        array[second] = temp;
    }

}
