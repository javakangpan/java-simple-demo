 package UB;

import java.util.Arrays;

import Interface.SimpleStack;

public class SimpleStackUseBean implements SimpleStack<Integer>{
     private int[] storage;//存放栈中元素的数组
     private int capacity;//栈的容量
     private int count;//栈中元素数量
     private static final int GROW_FACTOR = 2;

     //TODO：不带初始容量的构造方法。默认容量为8
     public SimpleStackUseBean() {
         this.capacity = 8;
         this.storage=new int[8];
         this.count = 0;
     }

     //TODO：带初始容量的构造方法
     public SimpleStackUseBean(int initialCapacity) {
         if (initialCapacity < 1)
             throw new IllegalArgumentException("Capacity too small.");

         this.capacity = initialCapacity;
         this.storage = new int[initialCapacity];
         this.count = 0;
     }

     //TODO：入栈
     public void push(Integer value) {
         if (count == capacity) {
             ensureCapacity();
         }
         storage[count++] = value;
     }

     //TODO：确保容量大小
     private void ensureCapacity() {
         int newCapacity = capacity * GROW_FACTOR;
         storage = Arrays.copyOf(storage, newCapacity);
         capacity = newCapacity;
     }

     //TODO：返回栈顶元素并出栈
     public Integer pop() {
         count--;
         if (count == -1)
             throw new IllegalArgumentException("Stack is empty.");

         return storage[count];
     }

     //TODO：返回栈顶元素不出栈
     public int peek() {
         if (count == 0){
             throw new IllegalArgumentException("Stack is empty.");
         }else {
             return storage[count-1];
         }
     }

     //TODO：判断栈是否为空
     public boolean isEmpty() {
         return count == 0;
     }

     //TODO：返回栈中元素的个数
     public int size() {
         return count;
     }
}
