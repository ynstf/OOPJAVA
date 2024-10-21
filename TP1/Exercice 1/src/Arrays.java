public class Arrays {

	public static void show(float array[]) {
		for (int i=0; i<array.length;i++) {
			System.out.println(array[i]);
		}
	}


    public static void sort(float[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {

                    float temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

}