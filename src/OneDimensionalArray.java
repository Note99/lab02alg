import java.util.Arrays;
import java.util.Random;

public class OneDimensionalArray {
    private double[] array;

    public OneDimensionalArray(int size) {
        array = new double[size];
    }

    public void enterArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + array.length + " elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextDouble();
        }
    }

    public void fillArrayWithRandomNumbers(double min, double max) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = min + random.nextDouble() * (max - min);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public double getElement(int index) {
        return array[index];
    }

    public void setElement(int index, double value) {
        array[index] = value;
    }

    public double getSum() {
        double sum = 0;
        for (double element : array) {
            sum += element;
        }
        return sum;
    }

    public double getMax() {
        double max = array[0];
        for (double element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public int getMinIndex() {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public OneDimensionalArray getPositiveElementsArray() {
        double[] positiveElements = new double[array.length];
        int count = 0;
        for (double element : array) {
            if (element > 0) {
                positiveElements[count++] = element;
            }
        }
        return new OneDimensionalArray(count);
    }

    public boolean linearSearch(double value) {
        for (double element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public boolean isSortedAscending() {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean binarySearch(double value) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == value) {
                return true;
            }
            if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static OneDimensionalArray sumOfArrays(OneDimensionalArray array1, OneDimensionalArray array2) {
        if (array1.array.length != array2.array.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }
        OneDimensionalArray result = new OneDimensionalArray(array1.array.length);
        for (int i = 0; i < result.array.length; i++) {
            result.array[i] = array1.array[i] + array2.array[i];
        }
        return result;
    }

    public static boolean isEqual(OneDimensionalArray array1, OneDimensionalArray array2) {
        return Arrays.equals(array1.array, array2.array);
    }

    public void cyclicShift(int positions) {
        if (positions < 0) {
            positions = array.length - Math.abs(positions) % array.length;
        } else {
            positions = positions % array.length;
        }
        reverse(0, array.length - 1);
        reverse(0, positions - 1);
        reverse(positions, array.length - 1);
    }

    private void reverse(int start, int end) {
        while (start < end) {
            double temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public boolean areAllInRange(double a, double b) {
        for (double element : array) {
            if (element < a || element > b) {
                return false;
            }
        }
        return true;
    }

    public void cocktailSort() {
        int left = 0;
        int right = array.length - 1;
        boolean swapped;
        do {
            swapped = false;
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
            right--;
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(i, i - 1);
                    swapped = true;
                }
            }
            left++;
        } while (swapped);
    }

    private void swap(int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        OneDimensionalArray array = new OneDimensionalArray(5);
        array.enterArrayFromConsole();
        System.out.println("Array: " + array);
        System.out.println("Sum: " + array.getSum());
        System.out.println("Max: " + array.getMax());
        System.out.println("Min index: " + array.getMinIndex());
        System.out.println("Positive elements array: " + array.getPositiveElementsArray());
        System.out.println("Linear search: " + array.linearSearch(5.5));
        System.out.println("Is sorted ascending: " + array.isSortedAscending());
        System.out.println("Binary search: " + array.binarySearch(7.5));
        OneDimensionalArray array1 = new OneDimensionalArray(3);
        array1.enterArrayFromConsole();
        OneDimensionalArray array2 = new OneDimensionalArray(3);
        array2.enterArrayFromConsole();
        System.out.println("Sum of arrays: " + OneDimensionalArray.sumOfArrays(array1, array2));
        System.out.println("Are arrays equal: " + OneDimensionalArray.isEqual(array1, array2));
        array.cyclicShift(2);
        System.out.println("Cyclic shift: " + array);
        System.out.println("Are all in range: " + array.areAllInRange(1.0, 10.0));
        array.cocktailSort();
        System.out.println("Cocktail sort: " + array);
    }
}
