package com.study.MapAndListSource;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListSource {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        //寻址快,复制和扩容慢
        //  system.arraycopy    --  每次进行扩容和add,remove的时候都会copy数组
        //                             add时:将index之后的数组copy往后挪一位,在index处插入element
        //                              remove时: index + 1之后的数组往前挪一位 ,然后将last one置null
        //                          扩容:每次add时会进行扩容检查,检查内置数组的长度是否比add后的数组(size)大
        //                               如果小于则扩容50%(length >> 1)
        //                                  扩容50%后还小于,则将数组长度置为size,add后最小需要长度

        List linkList = new LinkedList();
        //寻址慢,增删有位置区别
        //  链表的每个节点为一个Node,Node中分为3个属性:前继引用,业务数据,后继引用
        //      后继引用指向下一个Node,前继引用指向上一个Node;
        //      通过后继/前继引用进行每个Node的寻址
        //      主要为node(index)使用了一次二分法,从而进行了双向链表的寻址(从头/从尾)
        //  增删分为两步:寻址-操作增删
        //      因为是双向链表,寻址如果靠前半部或后半部,速度较快,但若靠中间,则大幅减慢
        //      插入:找到index后,(1)新建Node,同时该Node指向index-1和index;(2)前Node的后引用指向Node,后Node的前引用指向Node
        //           该两步不能颠倒顺序,因为插入的位置是index决定的,找到前后Node也是index决定的,而新建的Node不能分辨前后Node
        //      删除:找到index后,通过前后继引用可以获得前后的Node,连接前后的Node,并将该index.item置null





        /**
         * 总结:
         *  1.ArrayList 为顺序存储结构,是数组,寻址快,慢在copy,
         *      记住，ArrayList底层数组扩容是一个既消耗时间又消耗空间的操作。
         *  2.LinkList 为链式存储结构,是Node对象,通过Node.next找到下一个Node,寻址慢,快在链式引用的重新指向
         *
         *      关于查:get(i)和增删:add(i),remove(i)
         *          1.查,ArrayList通常快于LinkList,因为它是数组,相对位置固定,index可以直接通过下标取到
         *              而LinkList需要查找index则需要从头或从尾通过next指向一个个的往下查找
         *
         *          2.增删,在实验下,10000个元素,ArrayList设置了初始数组长度
         *              在10和9990进行增删时,LinkList通常时间比较稳定,因为为双向链表结构,从头或从尾寻址很快就能找到
         *                  但ArrayList在10时:比LinkList慢2W纳秒;
         *                  而在9990时,却比LinList快2W纳秒
         *                      因为system.arraycopy这个方法决定了,在ArrayList中,越靠后增删,需要copy的元素就越少
         *              在5000进行增删时,ArrayList比LinkList快8W纳秒,因为LinkList的一次二分法的寻址方式导致了
         *              中间的index需要寻址很久,而ArrayList通过下标可以很快找到
         *         3.遍历List
         *              1>.for循环remove偶数        Array快Link慢 即arrayList用for遍历效率高
         *              2>.iterator循环remove偶数   Link快Array慢 即linkList用Iterator遍历效率高
         */
    }



    @Test
    public void ListAddTest(){
        List arrayList = new ArrayList(10002);
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        long arrayStart = System.nanoTime();
        arrayList.add(10,"a");
        long arrayStop = System.nanoTime();
        System.out.println("arrayTime: " + (arrayStop-arrayStart));


        List linkList = new LinkedList();
        for (int i = 0; i < 10000; i++) {
            linkList.add(i);
        }
        long linkStart = System.nanoTime();
        linkList.add(10,"a");
        long linkStop = System.nanoTime();
        System.out.println("linkTime: " + (linkStop-linkStart));
    }
}
