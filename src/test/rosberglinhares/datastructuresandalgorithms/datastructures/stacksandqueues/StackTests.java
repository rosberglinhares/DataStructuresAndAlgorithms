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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test cases for the following classes:
 * 
 * <ul>
 *     <li>{@link StackArray}</li>
 * </ul>
 */
class StackTests {

    /**
     * Test method for {@link StackArray#isEmpty()}.
     */
    @Test
    void isEmpty() {
        StackArray<Integer> stack = new StackArray<Integer>(5);
        
        assertTrue(stack.isEmpty());
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(8);
        
        assertFalse(stack.isEmpty());
        
        stack.pop();
        
        assertFalse(stack.isEmpty());
        
        stack.peek();
        stack.peek();
        stack.peek();
        
        assertFalse(stack.isEmpty());
        
        stack.pop();
        stack.pop();
        stack.pop();
        
        assertTrue(stack.isEmpty());
    }

    /**
     * Test method for {@link StackArray#size()}.
     */
    @Test
    void size() {
        StackArray<Integer> stack = new StackArray<Integer>(5);
        
        assertEquals(0, stack.size());
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(8);
        
        assertEquals(4, stack.size());
        
        stack.pop();
        
        assertEquals(3, stack.size());
        
        stack.peek();
        stack.peek();
        
        assertEquals(3, stack.size());
        
        stack.pop();
        stack.pop();
        stack.pop();
        
        assertEquals(0, stack.size());
    }

    /**
     * Test method for {@link StackArray#isFull()}.
     */
    @Test
    void isFull() {
        StackArray<Integer> stack = new StackArray<Integer>(5);
        
        assertFalse(stack.isFull());
        
        stack.push(10);
        
        assertFalse(stack.isFull());
        
        stack.push(20);
        stack.push(30);
        stack.push(8);
        
        assertFalse(stack.isFull());
        
        stack.push(15);
        
        assertTrue(stack.isFull());
        
        stack.pop();
        
        assertFalse(stack.isFull());
        
        stack.pop();
        stack.pop();
        
        assertFalse(stack.isFull());
    }

    /**
     * Test method for {@link StackArray#push(java.lang.Object) StackArray.push(T)}.
     */
    @Test
    void push() {
        StackArray<Integer> stack = new StackArray<Integer>(5);
        
        stack.push(10);
        
        assertEquals(10, stack.pop());
        
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        assertEquals(40, stack.peek());
        
        stack.push(50);
        stack.push(60);
        
        // Stack full
        assertThrows(RuntimeException.class, () -> {
            stack.push(70);
        });
    }

    /**
     * Test method for {@link StackArray#pop()}.
     */
    @Test
    void pop() {
        StackArray<Integer> stack = new StackArray<Integer>(5);
        
        // Stack empty
        assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
        
        stack.push(10);
        
        assertEquals(10, stack.pop());
        
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        assertEquals(40, stack.pop());
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        
        stack.push(200);
        stack.push(300);
        stack.push(400);
        
        assertEquals(400, stack.pop());
        assertEquals(300, stack.pop());
        assertEquals(200, stack.pop());
        
        // Stack empty again
        assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
    }

    /**
     * Test method for {@link StackArray#peek()}.
     */
    @Test
    void peek() {
        StackArray<Integer> stack = new StackArray<Integer>(5);
        
        // Stack empty
        assertThrows(RuntimeException.class, () -> {
            stack.peek();
        });
        
        stack.push(10);
        
        assertEquals(10, stack.peek());
        
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        assertEquals(40, stack.peek());
        
        stack.pop();
        assertEquals(30, stack.peek());
        
        stack.pop();
        assertEquals(20, stack.peek());
        
        // 10 and 20 are still in the stack
        stack.push(200);
        stack.push(300);
        stack.push(400);
        
        assertEquals(400, stack.peek());
        
        stack.pop();
        assertEquals(300, stack.peek());
        
        stack.pop();
        assertEquals(200, stack.peek());
        
        stack.pop();
        assertEquals(20, stack.peek());
        
        stack.pop();
        assertEquals(10, stack.peek());
        
        stack.pop();
        
        // Stack empty again
        assertThrows(RuntimeException.class, () -> {
            stack.peek();
        });
    }
}