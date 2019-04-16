//package bluebridgestudy.datastructure.链表;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class DoubleLinkListTest {
//    public DoubleLinkList doubleLinkList;
//
//    @Before
//    public void befor(){
//        doubleLinkList = new DoubleLinkList();
//        add();
//    }
//
//    @Test
//    public void add() {
//        doubleLinkList.add("a");
//        doubleLinkList.add("b");
//        doubleLinkList.add("c");
//        doubleLinkList.add("d");
//        doubleLinkList.add("e");
//        doubleLinkList.add("f");
//        doubleLinkList.add("g");
//        doubleLinkList.add("h");
//        doubleLinkList.add("i");
//        assertEquals(doubleLinkList.toString(),"[a,b,c,d,e,f,g,h,i]");
//    }
//
//    @Test
//    public void delete() {
//        doubleLinkList.delete("b");
//        assertEquals(doubleLinkList.toString(),"[a,c,d,e,f,g,h,i]");
//        doubleLinkList.delete("a");
//        assertEquals(doubleLinkList.toString(),"[c,d,e,f,g,h,i]");
//        doubleLinkList.delete("i");
//        assertEquals(doubleLinkList.toString(),"[c,d,e,f,g,h]");
//    }
//
//    @Test
//    public void delete1() {
//        doubleLinkList.delete(1);
//        assertEquals(doubleLinkList.toString(),"[a,c,d,e,f,g,h,i]");
//        doubleLinkList.delete(0);
//        assertEquals(doubleLinkList.toString(),"[c,d,e,f,g,h,i]");
//        doubleLinkList.delete(6);
//        assertEquals(doubleLinkList.toString(),"[c,d,e,f,g,h]");
//        doubleLinkList.delete(0);
//        doubleLinkList.delete(0);
//        doubleLinkList.delete(0);
//        doubleLinkList.delete(0);
//        doubleLinkList.delete(0);
//        doubleLinkList.delete(0);
//        doubleLinkList.delete(0);
//        doubleLinkList.delete(0);
//        doubleLinkList.delete(0);
//        doubleLinkList.delete(0);
//        assertEquals(doubleLinkList.toString(),"[]");
//
//    }
//
//    @Test
//    public void update() {
//        doubleLinkList.update(1,"q");
//        assertEquals(doubleLinkList.toString(),"[a,q,c,d,e,f,g,h,i]");
//        doubleLinkList.update(0,"x");
//        assertEquals(doubleLinkList.toString(),"[x,q,c,d,e,f,g,h,i]");
//        doubleLinkList.update(6,"1");
//        assertEquals(doubleLinkList.toString(),"[x,q,c,d,e,f,1,h,i]");
//    }
//
//    @Test
//    public void contains() {
//        assertTrue(doubleLinkList.contains("a"));
//        assertTrue(doubleLinkList.contains("i"));
//        assertTrue(doubleLinkList.contains("e"));
//        assertFalse(doubleLinkList.contains("aa"));
//    }
//
//    @Test
//    public void indexOf() {
//        assertEquals(doubleLinkList.indexOf("a"),0);
//        assertEquals(doubleLinkList.indexOf("i"),8);
//        assertEquals(doubleLinkList.indexOf("c"),2);
//        assertEquals(doubleLinkList.indexOf("z"),-1);
//    }
//
//    @Test
//    public void get() {
//
//        assertEquals(doubleLinkList.get(0),"a");
//        assertEquals(doubleLinkList.get(8),"i");
//        assertEquals(doubleLinkList.get(2),"c");
//        assertEquals(doubleLinkList.get(10),null);
//    }
//}