package data_structure.hash;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

public class MyHashMapTest {

    IMap iMap = new MyHashMap();

    @Before
    public void setUp() throws Exception {
        //初始化myHashMap
        iMap.put("one",1);
        iMap.put("two",2);
        iMap.put("three",3);
        iMap.put("one",10);
        iMap.put("four",4);
        iMap.put("five",5);
        iMap.put("six",6);
        iMap.put("seven",7);
        iMap.put("eight",8);
        iMap.put("nine",9);
    }

    @Test
    public void clear() {
        System.out.println(iMap.toString());
        iMap.clear();
        System.out.println(iMap.toString());
    }

    @Test
    public void containsKey() {
        assertTrue(iMap.containsKey("one"));
        assertFalse(iMap.containsKey("five"));
    }

    @Test
    public void containsValue() {
        assertTrue(iMap.containsValue(10));
        assertFalse(iMap.containsValue(6));
    }

    @Test
    public void get() {
        assertEquals(iMap.get("one"),10);
        assertNotEquals(iMap.get("one"),4);
    }

    @Test
    public void isEmpty() {
        assertFalse(iMap.isEmpty());
        iMap.clear();
        assertTrue(iMap.isEmpty());
    }

    @Test
    public void keySet() {
        MyHashSet myHashSet = iMap.keySet();
        System.out.println(myHashSet.toString());
    }

    @Test
    public void put() {

    }

    @Test
    public void putAll() {
    }

    @Test
    public void remove() {
        assertEquals(iMap.remove("one"),10);
        assertEquals(iMap.get("one"),null);
        assertFalse(iMap.containsKey("one"));
        assertEquals(iMap.remove("two"),2);
        assertEquals(iMap.remove("three"),3);
        assertEquals(iMap.remove("four"),4);
        assertTrue(iMap.isEmpty());
    }

    @Test
    public void size() {

    }

    @Test
    public void values() {
    }

    @Test
    public void hash() {
    }

    @Test
    public void iterator(){
        Iterator iterator = iMap.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }



}