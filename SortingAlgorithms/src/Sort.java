public abstract class Sort implements ISort {
    public int[] list;

    Sort() {
        list = new int[]{64, 25, 12, 22, 11, 100, 200, 50, 1, 3, 4, 2};
    }

    public void showList() {
        System.out.println();
        for (int i : list) {
            System.out.print(i + ",");
        }
    }
}