//package bluebridgestudy.datastructure.链表;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class SingleLinkListTest {
//    SingleLinkList singleLinkList ;
//    @Before
//    public void before(){
//        singleLinkList = new SingleLinkList();
//    }
//    @Test
//    public void add() {
//        singleLinkList.add("a");
//        singleLinkList.add("b");
//        singleLinkList.add("c");
//        singleLinkList.add("d");
//        singleLinkList.add("e");
//        singleLinkList.add("f");
//        singleLinkList.add("g");
//        singleLinkList.add("h");
//        System.out.println(singleLinkList.toString());
//    }
//
//    @Test
//    public void delete() {
//        add();
//        singleLinkList.delete("c");
//        System.out.println(singleLinkList.toString());
//        singleLinkList.delete("a");
//        System.out.println(singleLinkList.toString());
//        singleLinkList.delete("h");
//        System.out.println(singleLinkList.toString());
//    }
//
//    @Test
//    public void delete1() {
//        add();
//        singleLinkList.delete(0);
//        System.out.println(singleLinkList.toString());
//        singleLinkList.delete(5);
//        System.out.println(singleLinkList.toString());
//        singleLinkList.delete(3);
//        System.out.println(singleLinkList.toString());
//    }
//
//    @Test
//    public void update() {
//        add();
//        singleLinkList.update(0,"x");
//        System.out.println(singleLinkList.toString());
//        singleLinkList.update(3,"y");
//        System.out.println(singleLinkList.toString());
//        singleLinkList.update(7,"z");
//        System.out.println(singleLinkList.toString());
//    }
//
//    @Test
//    public void contains() {
//        add();
//        Assert.assertTrue(singleLinkList.contains("a"));
//        Assert.assertFalse(singleLinkList.contains("x"));
//    }
//
//    @Test
//    public void indexOf() {
//        add();
//        Assert.assertEquals(singleLinkList.indexOf("a"),0);
//        Assert.assertEquals(singleLinkList.indexOf("x"),-1);
//        Assert.assertEquals(singleLinkList.indexOf("h"),7);
//    }
//
//    @Test
//    public void get() {
//        add();
//        Assert.assertEquals(singleLinkList.get(0),"a");
//        Assert.assertEquals(singleLinkList.get(-1),null);
//        Assert.assertEquals(singleLinkList.get(7),"h");
//    }
//
//}