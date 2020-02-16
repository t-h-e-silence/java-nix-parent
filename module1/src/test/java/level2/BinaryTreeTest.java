package level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void getDepth() {
        BinaryTree b=new BinaryTree();
        b.addToTree(8);
        b.addToTree(10);
        b.addToTree(4);
        b.addToTree(2);
        b.addToTree(6);
        b.addToTree(3);
        b.addToTree(7);

        int d= b.getDepth();
        assertEquals(4,d);

        BinaryTree b1=new BinaryTree();
        d= b1.getDepth();
        assertEquals(0,d);
    }
}