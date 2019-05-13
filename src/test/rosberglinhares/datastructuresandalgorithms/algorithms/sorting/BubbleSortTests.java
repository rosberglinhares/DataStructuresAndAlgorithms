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

package rosberglinhares.datastructuresandalgorithms.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

/**
 * Test cases for the {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort} class.
 */
class BubbleSortTests {

    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort#iterativeBubbleSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeBubbleSort_EmptyArray_ShouldReturnEmptyArray() {
        BubbleSort bubbleSort = new BubbleSort();
        
        this.bubbleSort_EmptyArray_ShouldReturnEmptyArray(bubbleSort::iterativeBubbleSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort#iterativeBubbleSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeBubbleSort_RandomElements_CorrectlySorted() {
        BubbleSort bubbleSort = new BubbleSort();
        
        this.bubbleSort_RandomElements_CorrectlySorted(bubbleSort::iterativeBubbleSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort#recursiveBubbleSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveBubbleSort_EmptyArray_ShouldReturnEmptyArray() {
        BubbleSort bubbleSort = new BubbleSort();
        
        this.bubbleSort_EmptyArray_ShouldReturnEmptyArray(bubbleSort::recursiveBubbleSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort#recursiveBubbleSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveBubbleSort_RandomElements_CorrectlySorted() {
        BubbleSort bubbleSort = new BubbleSort();
        
        this.bubbleSort_RandomElements_CorrectlySorted(bubbleSort::recursiveBubbleSort);
    }
    
    private <T> void bubbleSort_EmptyArray_ShouldReturnEmptyArray(Consumer<Integer[]> bubbleSorthMethodRef) {
        Integer[] items = {};
        
        bubbleSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[0], items);
    }
    
    private <T> void bubbleSort_RandomElements_CorrectlySorted(Consumer<Integer[]> bubbleSorthMethodRef) {
        Integer[] items;
        
        items = new Integer[]{ 50 };
        bubbleSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 50 }, items);
        
        items = new Integer[]{ 20, 15 };
        bubbleSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 15, 20 }, items);
        
        items = new Integer[]{ 8, 5, 15, 20, 17, 3 };
        bubbleSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 3, 5, 8, 15, 17, 20 }, items);
        
        items = new Integer[]{ 20, 17, 15, 8, 5, 3 };
        bubbleSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 3, 5, 8, 15, 17, 20 }, items);
    }
}