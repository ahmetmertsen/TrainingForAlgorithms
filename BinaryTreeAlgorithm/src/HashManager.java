public class HashManager {
    private Hash[] array;

    HashManager(int length) {
        array = new Hash[length];
    }

    public void add(int value) {
        int index = value % array.length;
        if (array[index] == null) {
            array[index] = new Hash(value);
        } else {
            Hash temp = array[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Hash(value);
        }
    }

    public boolean delete(int value) {
        int index = value % array.length;
        if (array[index] == null) {
            return false;
        }
        Hash temp = array[index];
        while (temp.next != null) {
            if (temp.next.value == value) {
                if (temp.next.next == null) {
                    temp.next = null;
                } else {
                    temp.next = temp.next.next;
                }
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void showHashTable() {
        if (isNull()) {
            System.out.println("Your hash table is null");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            Hash temp = array[i];
            if (temp != null) {
                System.out.print(i + " -> "+temp.value+", ");
                while (temp.next != null) {
                    temp = temp.next;
                    System.out.print(temp.value+", ");
                }
                System.out.println();
            }
        }
    }

    public boolean isNull() {
        for (Hash i : array) {
            if (i != null) {
                return false;
            }
        }
        return true;
    }

}
