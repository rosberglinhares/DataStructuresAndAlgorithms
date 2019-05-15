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

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

/**
 * Test cases for the following classes:
 * 
 * <ul>
 *     <li>{@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort}</li>
 *     <li>{@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort}</li>
 *     <li>{@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.InsertionSort}</li>
 * </ul>
 */
class SortTests {

    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort#iterativeBubbleSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeBubbleSort_EmptyArray_ShouldReturnEmptyArray() {
        BubbleSort bubbleSort = new BubbleSort();
        
        this.sort_EmptyArray_ShouldReturnEmptyArray(bubbleSort::iterativeBubbleSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort#iterativeBubbleSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeBubbleSort_RandomElements_CorrectlySorted() {
        BubbleSort bubbleSort = new BubbleSort();
        
        this.sort_RandomElements_CorrectlySorted(bubbleSort::iterativeBubbleSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort#recursiveBubbleSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveBubbleSort_EmptyArray_ShouldReturnEmptyArray() {
        BubbleSort bubbleSort = new BubbleSort();
        
        this.sort_EmptyArray_ShouldReturnEmptyArray(bubbleSort::recursiveBubbleSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.BubbleSort#recursiveBubbleSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveBubbleSort_RandomElements_CorrectlySorted() {
        BubbleSort bubbleSort = new BubbleSort();
        
        this.sort_RandomElements_CorrectlySorted(bubbleSort::recursiveBubbleSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort#iterativeSelectionSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeSelectionSort_EmptyArray_ShouldReturnEmptyArray() {
        SelectionSort selectionSort = new SelectionSort();
        
        this.sort_EmptyArray_ShouldReturnEmptyArray(selectionSort::iterativeSelectionSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort#iterativeSelectionSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeSelectionSort_RandomElements_CorrectlySorted() {
        SelectionSort selectionSort = new SelectionSort();
        
        this.sort_RandomElements_CorrectlySorted(selectionSort::iterativeSelectionSort);
    }

    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort#recursiveSelectionSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveSelectionSort_EmptyArray_ShouldReturnEmptyArray() {
        SelectionSort selectionSort = new SelectionSort();
        
        this.sort_EmptyArray_ShouldReturnEmptyArray(selectionSort::recursiveSelectionSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort#recursiveSelectionSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveSelectionSort_RandomElements_CorrectlySorted() {
        SelectionSort selectionSort = new SelectionSort();
        
        this.sort_RandomElements_CorrectlySorted(selectionSort::recursiveSelectionSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.InsertionSort#iterativeInsertionSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeInsertionSort_EmptyArray_ShouldReturnEmptyArray() {
        InsertionSort insertionSort = new InsertionSort();
        
        this.sort_EmptyArray_ShouldReturnEmptyArray(insertionSort::iterativeInsertionSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.InsertionSort#iterativeInsertionSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeInsertionSort_RandomElements_CorrectlySorted() {
        InsertionSort insertionSort = new InsertionSort();
        
        this.sort_RandomElements_CorrectlySorted(insertionSort::iterativeInsertionSort);
    }

    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.InsertionSort#recursiveInsertionSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveInsertionSort_EmptyArray_ShouldReturnEmptyArray() {
        InsertionSort insertionSort = new InsertionSort();
        
        this.sort_EmptyArray_ShouldReturnEmptyArray(insertionSort::recursiveInsertionSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.InsertionSort#recursiveInsertionSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveInsertionSort_RandomElements_CorrectlySorted() {
        InsertionSort insertionSort = new InsertionSort();
        
        this.sort_RandomElements_CorrectlySorted(insertionSort::recursiveInsertionSort);
    }
    
    private <T> void sort_EmptyArray_ShouldReturnEmptyArray(Consumer<Integer[]> sortMethodRef) {
        Integer[] items = {};
        
        sortMethodRef.accept(items);
        assertArrayEquals(new Integer[0], items);
    }
    
    private <T> void sort_RandomElements_CorrectlySorted(Consumer<Integer[]> sortMethodRef) {
        Integer[] items;
        
        items = new Integer[]{ 50 };
        sortMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 50 }, items);
        
        items = new Integer[]{ 20, 15 };
        sortMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 15, 20 }, items);
        
        items = new Integer[]{ 8, 20, 5, 15, 3, 17 };
        sortMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 3, 5, 8, 15, 17, 20 }, items);
        
        items = new Integer[]{ 20, 17, 15, 8, 5, 3 };
        sortMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 3, 5, 8, 15, 17, 20 }, items);
    }
}