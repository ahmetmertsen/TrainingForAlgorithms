public class SelectionSort extends Sort {

    public SelectionSort() {
        super();
    }

    public void sort() {
        for (int i = 0; i < (list.length - 1); i++) {
            int index = i;
            for (int j = i; j < list.length; j++) {
                if (list[j] <= list[index]) {
                    index = j;
                }
            }
            int keeper = list[i];
            list[i] = list[index];
            list[index] = keeper;
        }
        showList();
    }
}