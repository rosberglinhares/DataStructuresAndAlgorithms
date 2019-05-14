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
 * Test cases for the {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort} class.
 */
class SelectionSortTests {

    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort#iterativeSelectionSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeSelectionSort_EmptyArray_ShouldReturnEmptyArray() {
        SelectionSort selectionSort = new SelectionSort();
        
        this.selectionSort_EmptyArray_ShouldReturnEmptyArray(selectionSort::iterativeSelectionSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort#iterativeSelectionSort(java.lang.Comparable[])}.
     */
    @Test
    void iterativeSelectionSort_RandomElements_CorrectlySorted() {
        SelectionSort selectionSort = new SelectionSort();
        
        this.selectionSort_RandomElements_CorrectlySorted(selectionSort::iterativeSelectionSort);
    }

    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort#recursiveSelectionSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveSelectionSort_EmptyArray_ShouldReturnEmptyArray() {
        SelectionSort selectionSort = new SelectionSort();
        
        this.selectionSort_EmptyArray_ShouldReturnEmptyArray(selectionSort::recursiveSelectionSort);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.sorting.SelectionSort#recursiveSelectionSort(java.lang.Comparable[])}.
     */
    @Test
    void recursiveSelectionSort_RandomElements_CorrectlySorted() {
        SelectionSort selectionSort = new SelectionSort();
        
        this.selectionSort_RandomElements_CorrectlySorted(selectionSort::recursiveSelectionSort);
    }
    
    private <T> void selectionSort_EmptyArray_ShouldReturnEmptyArray(Consumer<Integer[]> selectionSorthMethodRef) {
        Integer[] items = {};
        
        selectionSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[0], items);
    }
    
    private <T> void selectionSort_RandomElements_CorrectlySorted(Consumer<Integer[]> selectionSorthMethodRef) {
        Integer[] items;
        
        items = new Integer[]{ 50 };
        selectionSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 50 }, items);
        
        items = new Integer[]{ 20, 15 };
        selectionSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 15, 20 }, items);
        
        items = new Integer[]{ 8, 20, 5, 15, 3, 17 };
        selectionSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 3, 5, 8, 15, 17, 20 }, items);
        
        items = new Integer[]{ 20, 17, 15, 8, 5, 3 };
        selectionSorthMethodRef.accept(items);
        assertArrayEquals(new Integer[]{ 3, 5, 8, 15, 17, 20 }, items);
    }
}