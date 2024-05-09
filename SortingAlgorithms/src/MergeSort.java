public class MergeSort extends Sort {
    public int[] myList;

    public MergeSort() {
        super.list = new int[]{38, 27, 43, 3, 9, 82, 10, 11};
    }

    @Override
    public void sort() {
        test(0, (list.length));
    }

    public void test(int first, int last) {
        if (last <= 1) {
            return;
        }
        int p = testOps(first, last / 2);
        testOps(p, last);
        test(first, last / 2);
    }

    public int testOps(int first, int last) {
        System.out.println(first + "," + last);
        return last;
    }
}