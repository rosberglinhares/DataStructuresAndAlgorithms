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
 * Implements a stack using linked list.
 */
public class StackLinkedList<T> implements Stack<T> {
    
    private static class Node<T> {
        private T data;
        private Node<T> next;
        
        public T getData() {
            return this.data;
        }
        
        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
        
        public Node(T data) {
            this.data = data;
        }
    }
    
    private Node<T> top;
    
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    @Override
    public boolean isEmpty() {
        return (this.top == null);
    }
    
    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    @Override
    public int size() {
        int size = 0;
        Node<T> currentNode = this.top;
        
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            size++;
        }
        
        return size;
    }
    
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    @Override
    public void push(T element) {
        Node<T> node = new Node<T>(element);
        node.setNext(this.top);
        
        this.top = node;
    }
    
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    @Override
    public T pop() {
        if (!this.isEmpty()) {
            T element = this.top.getData();
            this.top = this.top.getNext();
            
            return element;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    @Override
    public T peek() {
        if (!this.isEmpty()) {
            return this.top.getData();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}