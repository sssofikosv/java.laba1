package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest<T> extends Container {
    ContainerTest<Integer> cont;

    @BeforeEach
    public void init() {
        cont = new ContainerTest<>();
    }

    @Test
    public void addToListCheck(){
        cont.addToList(1);
        cont.addToList(2);
        cont.addToList(3);
        assertEquals(3, cont.next.next.data);
        assertEquals(1, cont.data);
    }

    @Test
    public void getDataCheck(){
        cont.addToList(1);
        cont.addToList(2);
        cont.addToList(3);
        assertEquals(3, cont.getData());
    }

    @Test
    public void deleteData(){
        cont.addToList(1);
        cont.addToList(2);
        cont.addToList(3);
        assertTrue(cont.delELem(2));
    }

    @Test
    public void deleteWhenNoData(){
        cont.addToList(1);
        cont.addToList(2);
        cont.addToList(3);
        assertFalse(cont.delELem(10));
    }

}