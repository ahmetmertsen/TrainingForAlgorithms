public class InsertionSort extends Sort {

    @Override
    public void sort() {
        showList();
        for (int i = 1; i < list.length; i++) {
            int index = i;
            for (int j = (i - 1); j >= 0; j--) {
                if (list[index] < list[j]) {
                    int keeper = list[j];
                    list[j] = list[index];
                    list[index] = keeper;
                    index = j;
                }
            }

        }
        showList();
    }

}