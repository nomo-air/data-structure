package stacks;

public interface Stack<E> {

    // 获取栈中元素个数
    int getSize();

    // 是否为空栈
    boolean isEmpty();

    // 入栈
    void push(E e);

    // 出栈
    E pop();

    // 查看栈顶元素
    E peek();
}