import java.util.ArrayList;

class Vehicle_Sort {
    public void sort(ArrayList<Vehicle> array) {
        quickSort(array, 0, array.size() - 1);
    }

    private void quickSort(ArrayList<Vehicle> array, int low, int high) {

        if(low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private int partition(ArrayList<Vehicle> array, int low, int high) {
        Vehicle pivot = array.get(high);
        int i = low;

        for(int j = low; j <= high - 1; j++) {
            if(array.get(j).getScore() < pivot.getScore()) {
                swap(array, i, j);
                i++;
            }
        }

        swap(array, i, high);

        return i;
    }

    private void swap(ArrayList<Vehicle> array, int i, int j) {
        Vehicle temp = array.get(i);

        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
