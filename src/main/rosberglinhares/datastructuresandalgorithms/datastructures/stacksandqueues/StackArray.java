/*
 * MIT License
 * 
 * Copyright (c) 2019 Rosberg Linhares (rosberglinhares@gmail.com)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package rosberglinhares.datastructuresandalgorithms.datastructures.stacksandqueues;

/**
 * A stack allows access to only one data item: the last item inserted. If you remove this item, you can access
 * the next-to-last item inserted, and so on. The interface of this structure is designed to enforce restricted access.
 * Access to other items is (in theory) not allowed.
 * 
 * Placing a data item on the top of the stack is called pushing it. Removing it from the top of the stack is called popping it.
 * These are the primary stack operations. A stack is said to be a Last-In-First-Out (LIFO) storage mechanism because
 * the last item inserted is the first one to be removed.
 * 
 * @param <T> the type of elements in this stack.
 */
public class StackArray<T> {

    private T[] elements;
    private int top;
    
    @SuppressWarnings("unchecked")
    public StackArray(int maxSize) {
        this.elements = (T[])new Object[maxSize];
        this.top = -1;
    }
    
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public boolean isEmpty() {
        return (this.top == -1);
    }
    
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public int size() {
        return this.top + 1;
    }
    
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public boolean isFull() {
        return (this.size() == this.elements.length);
    }
    
    /**
     * Increments top so it points to the space just above the previous top and stores a data item there.
     * 
     * Time complexity: O(1)
     * Space complexity: O(1) 
     */
    public void push(T element) {
        if (!this.isFull()) {
            this.top++;
            this.elements[this.top] = element;
        } else {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Returns the value at top and then decrements top. This effectively removes the item from the stack;
     * it’s inaccessible, although the value remains in the array (until another item is pushed into the cell).
     * 
     * Time complexity: O(1)
     * Space complexity: O(1) 
     */
    public T pop() {
        if (!this.isEmpty()) {
            T element = this.elements[this.top];
            this.top--;
            
            return element;
        } else {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Simply returns the value at top, without changing the stack.
     * 
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public T peek() {
        if (!this.isEmpty()) {
            return this.elements[this.top];
        } else {
            throw new UnsupportedOperationException();
        }
    }
}