public class Main {
    public static void main(String[] args) {
        // Create an instance of OneDimensionalArray
        OneDimensionalArray array = new OneDimensionalArray(5);

        // Enter the array from the console
        array.enterArrayFromConsole();

        // Print the array
        System.out.println("Array: " + array);

        // Perform various operations on the array
        System.out.println("Sum: " + array.getSum());
        System.out.println("Max: " + array.getMax());
        System.out.println("Min index: " + array.getMinIndex());
        System.out.println("Positive elements array: " + array.getPositiveElementsArray());
        System.out.println("Linear search: " + array.linearSearch(5.5));
        System.out.println("Is sorted ascending: " + array.isSortedAscending());
        System.out.println("Binary search: " + array.binarySearch(7.5));

        // Create two more instances of OneDimensionalArray
        OneDimensionalArray array1 = new OneDimensionalArray(3);
        OneDimensionalArray array2 = new OneDimensionalArray(3);

        // Enter arrays from the console
        array1.enterArrayFromConsole();
        array2.enterArrayFromConsole();

        // Perform additional operations on the arrays
        System.out.println("Sum of arrays: " + OneDimensionalArray.sumOfArrays(array1, array2));
        System.out.println("Are arrays equal: " + OneDimensionalArray.isEqual(array1, array2));

        // Perform cyclic shift on the array
        array.cyclicShift(2);
        System.out.println("Cyclic shift: " + array);

        // Check if all elements are in a given range
        System.out.println("Are all in range: " + array.areAllInRange(1.0, 10.0));

        // Perform cocktail sort on the array
        array.cocktailSort();
        System.out.println("Cocktail sort: " + array);
    }
}
