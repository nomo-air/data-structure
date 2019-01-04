package _05_Heapify_and_Replace_in_Heap;
// Heapify 和 Replace


/*
    replace：取出最大元素后，放入一个新的元素
    实现：可以先extractMax，再add，两次O(logn)的操作
    实现：可以直接将堆顶元素替换以后Sift Down，一次O(logn) 的操作


    heapify：将任意数组整理成堆的形状
 */