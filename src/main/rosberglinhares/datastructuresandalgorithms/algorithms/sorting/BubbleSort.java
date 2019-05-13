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

/**
 * The bubble sort is notoriously slow, but it’s conceptually the simplest of the sorting algorithms and for that
 * reason is a good beginning for the exploration of sorting techniques.
 * 
 * You start at the beginning of the array and compare the two items in positions 0 and 1. If the one on the left (in 0)
 * is greater, you swap them. If the one on the right is greater, you don’t do anything. Then you move over one position
 * and compare the items in positions 1 and 2. Again, if the one on the left is greater, you swap them. When you reach
 * the first already sorted item, start over at the beginning and do it again. You continue this process until all the
 * items are in order.
 * 
 * You always do know that the greatest item is on the right. This must be true because, as soon as you encounter
 * the greatest item, you'll end up swapping it every time you compare two items, until eventually it will reach
 * the right end. This is why it's called the bubble sort: As the algorithm progresses, the biggest items "bubble up"
 * to the top end of the array.
 */
public class BubbleSort {
    
    /**
     * Implements an iterative bubble sort.
     * 
     * Time complexity: O(N²)
     * Space complexity: O(1)
     * 
     * @param <T> the type of elements in the array. In order for the sort to work, these elements must be
     *            {@link java.lang.Comparable} to themselves.
     * @param items an array containing the elements to sort.
     */
    public <T extends Comparable<T>> void iterativeBubbleSort(T[] items) {
        // After N - 1 iterations, we will have N - 1 elements in the right order. Therefore, the last element will
        // be automatically in the right order too.
        for (int n = 1; n <= items.length - 1; n++) {
            for (int i = 0; i < items.length - n; i++) {
                if (items[i].compareTo(items[i + 1]) > 0) {
                    T temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                }
            }
        }
    }
    
    /**
     * Implements a recursive bubble sort.
     * 
     * Time complexity: O(N²)
     * Space complexity: O(N)
     * 
     * @param <T> the type of elements in the array. In order for the sort to work, these elements must be
     *            {@link java.lang.Comparable} to themselves.
     * @param items an array containing the elements to sort.
     */
    public <T extends Comparable<T>> void recursiveBubbleSort(T[] items) {
        this.recursiveBubbleSort(items, items.length - 1);
    }
    
    private <T extends Comparable<T>> void recursiveBubbleSort(T[] items, int upperIndex) {
        if (upperIndex > 0) {
            for (int i = 0; i <= upperIndex - 1; i++) {
                if (items[i].compareTo(items[i + 1]) > 0) {
                    T temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                }
            }
            
            recursiveBubbleSort(items, upperIndex - 1);
        }
    }
}