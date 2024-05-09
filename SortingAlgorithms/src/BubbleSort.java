public class BubbleSort extends Sort {

    @Override
    public void sort() {
        showList();
        System.out.println();
        boolean iteration = true;
        while(iteration) {
            iteration = bubble();
        }
        showList();
    }
    private boolean bubble(){
        boolean control = false;
        for (int i = 0; i < (list.length - 1); i++) {
            if (list[i] > list[(i + 1)]) {
                int helper = list[i];
                list[i] = list[i + 1];
                list[i + 1] = helper;
                control = true;
            }
        }
        return control;
    }
}
