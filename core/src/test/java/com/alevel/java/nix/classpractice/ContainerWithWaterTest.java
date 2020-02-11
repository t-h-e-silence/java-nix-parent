package com.alevel.java.nix.classpractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithWaterTest {

    @Test
    void container() {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7, 6, 3,4};
        ContainerWithWater c=new ContainerWithWater(arr);
        int cont=c.container();
        assertEquals(49, cont);
        ContainerWithWater c1=new ContainerWithWater(new int[]{0});
        cont=c1.container();
        assertEquals(0, cont);
        ContainerWithWater c2=new ContainerWithWater(new int[]{0,2});
        cont=c2.container();
        assertEquals(0, cont);
    }
}