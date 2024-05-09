public class ShellSort extends Sort {
    private int condition = 5;

    @Override
    public void sort() {
        super.list = new int[]{13, 14, 94, 33, 82,
                25, 59, 94, 65, 23,
                45, 27, 73, 25, 39};
        while (condition >= 1) {
            for (int i = 0; i < list.length; i++) {
                for (int j = i; j < list.length; j += condition) {
                    if (list[j] < list[i]) {
                        int temp = list[i];
                        list[i] = list[j];
                        list[j] = temp;
                    }
                }
            }
            showList();
            condition -= 2;
        }
    }

    @Override
    public void showList() {
        for (int i = 0; i < list.length; i++) {
            if (i % condition == 0 && i > 0) {
                System.out.println();
            }
            System.out.print(list[i] + ",");
        }
        System.out.println();
        System.out.println("----------------------------------");
    }
}