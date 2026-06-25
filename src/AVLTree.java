import java.util.ArrayList;

public class AVLTree {

    private AVLNode root;

    private int height(AVLNode node){
        if(node == null) return 0;
        return node.height;
    }
    private void updateHeight(AVLNode node){
        if(node == null) return;
        node.height =
                1 + Math.max(
                        height(node.left),
                        height(node.right)
                );
    }
    private int getBalance(AVLNode node){
        if(node == null) return 0;
        return height(node.left) - height(node.right);
    }
    private AVLNode rightRotate(AVLNode y){
        AVLNode x = y.left;
        y.left = x.right;
        x.right = y;
        updateHeight(y);
        updateHeight(x);
        return x;

    }
    private AVLNode leftRotate(AVLNode y){
        AVLNode x = y.right;
        y.right = x.left;
        x.left = y;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    public void insert(int key, Record value){
        root = insert(root, key, value);
    }
    private AVLNode insert(
            AVLNode node,
            int key,
            Record value){
        if(node == null){
            return new AVLNode(key, value);
        }else if(key < node.key){
            node.left = insert(node.left, key, value);
        }else if(key > node.key){
            node.right = insert(node.right, key, value);
        }else {
            node.value = value;
        }
        updateHeight(node);
        int balance = getBalance(node);
        if(balance > 1 && key < node.left.key){
            return rightRotate(node);
        }
        if(balance < -1 && key > node.right.key){
            return leftRotate(node);
        }
        if(balance > 1 && key > node.left.key){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance < -1 && key < node.right.key){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }


    public Record search(int key) {
        AVLNode current = root;
        if(current == null) return null;
        while(true){
            if(current.key == key){
                return current.value;
            }else if(current.key > key){
                if(current.left == null){
                    return null;
                }
                current = current.left;
            }else {
                if(current.right == null){
                    return null;
                }
                current = current.right;
            }
        }

    }

    public boolean delete(int key) {
        if(search(key) == null) return false;
        root = delete(root, key);
        return true;


    }
    private AVLNode delete(AVLNode node, int key){
        if(node == null) return null;
        if(key < node.key){
            node.left = delete(node.left, key);
        }else if(key > node.key){
            node.right = delete(node.right, key);
        }else {
            if(node.left == null && node.right == null){
                return null;
            }else if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }else {
                AVLNode successor = findMin(node.right);
                node.key = successor.key;
                node.value = successor.value;
                node.right = delete(node.right, successor.key);
            }
        }
        updateHeight(node);
        int balance = getBalance(node);
        if(balance > 1 &&
                getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        if(balance < -1 &&
                getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        if(balance > 1 &&
                getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance < -1 &&
                getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    private AVLNode findMin(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public ArrayList<Record> findAll() {
        ArrayList<Record> result = new ArrayList<>();
        if(root == null) return result;
        findAll(root, result);
        return result;
    }
    private void findAll(AVLNode node,ArrayList<Record> result) {
        if(node == null) return;
        findAll(node.left, result);
        result.add(node.value);
        findAll(node.right, result);
    }

}
