public class AVLNode {
    int key;
    Record value;

    AVLNode left;
    AVLNode right;

    int height;
    public AVLNode(int key, Record value) {
        this.key = key;
        this.value = value;
        this.height = 1;
    }
}