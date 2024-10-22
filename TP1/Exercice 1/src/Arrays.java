public class Arrays {

	public static void show(float array[]) {
		for (int i=0; i<array.length;i++) {
			System.out.println(array[i]);
		}
	}

    public static void sort(float array[]) {
        int n = array.length;
        boolean swap;
        for (int i = 0; i < n - 1; i++) {
            swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    float temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
    }

	public static float average(float array[]) {
		float totale = 0;
		for (int i=0; i<array.length;i++) {
			totale += array[i];
		}
		return totale/array.length;
	}

	public static void minmax(float array[]) {
		float min = 20;
		float max = 0;

		for (int i=0; i<array.length;i++) {
			if (array[i]<=min){
				min = array[i];
			}
			if (array[i]>=max){
				max = array[i];
			}
		}
		System.out.println("the min : "+min);
		System.out.println("the max : "+max);
	}

	public static int studentWithDegree(float array[], float degree) {
		int count = 0;

		for (int i=0; i<array.length;i++) {
			if (array[i]==degree){
				count++;
			}
		}
		return count;
	}

}