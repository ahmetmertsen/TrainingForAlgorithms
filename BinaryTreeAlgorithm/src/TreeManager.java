public class TreeManager {
    public Tree root;

    public void add(int value) {
        if (root == null) {
            root = new Tree(value);
        } else {
            addOperation(root, value);
        }
    }

    private void addOperation(Tree tree, int value) {
        if (tree == null) {
            return;
        }
        if (value < tree.value) {
            if (tree.left == null) {
                tree.left = new Tree(value);
            } else {
                addOperation(tree.left, value);
            }
        } else {
            if (tree.right == null) {
                tree.right = new Tree(value);
            } else {
                addOperation(tree.right, value);
            }
        }
    }

    public void delete(int value) {
        Tree tree = tripper(root, value);
        if (tree == null) {
            return;
        }
        if (value != tree.value) {
            if (value < tree.value) {
                tree.left = null;
            } else {
                tree.right = null;
            }
        } else {
            if (tree.left.right != null) {
                Tree temp = findMaxChildOnRight(tree);
                tree.value = temp.value;
            } else {
                tree.value = tree.left.value;
                tree.left = null;
            }
        }
        System.out.println("The value is deleted --> " + value);
    }


    private Tree findMaxChildOnRight(Tree tree) {
        Tree temp = tree.left;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public Tree tripper(Tree tree, int value) {
        if (tree == null) {
            System.out.println("The tree is not contain this value -> " + value);
            return null;
        }
        if (isChildLeaf(tree.left) && isChildLeaf(tree.right)) {
            return tree;
        }
        if (value == tree.value) {
            return tree;
        } else if (value < tree.value) {
            return tripper(tree.left, value);
        } else {
            return tripper(tree.right, value);
        }
    }

    private boolean isChildLeaf(Tree tree) {
        if (tree != null) {
            return tree.left == null && tree.right == null;
        }
        return false;
    }

    public int calculateHeight() {
        return Math.max(calculateLeft(root, 0), calculateRight(root, 0));
    }

    private int calculateLeft(Tree tree, int counter) {
        if (tree == null) {
            return counter;
        }
        return calculateLeft(tree.left, ++counter);
    }

    private int calculateRight(Tree tree, int counter) {
        if (tree == null) {
            return counter;
        }
        return calculateRight(tree.right, ++counter);
    }

    public void pre_order() {
        preOrder(root);
    }

    public void in_order() {
        inOrder(root);
    }

    public void post_order() {
        postOrder(root);
    }

    public void level_order() {
        levelOrder(root, 0, 0);
    }

    private void preOrder(Tree tree) {
        if (tree != null) {
            System.out.print(tree.value + " - ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    private void inOrder(Tree tree) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left);
        System.out.print(tree.value + "-");
        inOrder(tree.right);
    }

    private void postOrder(Tree tree) {
        if (tree == null) {
            return;
        }
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.print(tree.value + " - ");
    }

    private void levelOrder(Tree tree, int leftLevel, int rightLevel) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            System.out.print(tree.left.value + " - ");
        }
        if (tree.right != null) {
            System.out.print(tree.right.value + " - ");
        }
        if (leftLevel == rightLevel) {
            levelOrder(tree.left, leftLevel, ++rightLevel);
            levelOrder(tree.right, ++leftLevel, rightLevel);
        }
    }

}
