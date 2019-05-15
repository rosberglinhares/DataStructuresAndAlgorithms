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
 * The selection sort improves on the bubble sort by reducing the number of swaps necessary from O(N²) to O(N).
 * Unfortunately, the number of comparisons remains O(N²).
 * 
 * What’s involved in the selection sort is making a pass through all the items and picking (or selecting,
 * hence the name of the sort) the shortest one. This shortest item is then swapped with the item on the left end of the line,
 * at position 0. Now the leftmost item is sorted and won’t need to be moved again. Notice that in this algorithm the
 * sorted items accumulate on the left (lower indices), whereas in the bubble sort they accumulated on the right.
 * The next time you pass down the row of items, you start at position 1, and, finding the minimum, swap with position 1.
 * This process continues until all the items are sorted.
 * 
 * The selection sort performs the same number of comparisons as the bubble sort: N*(N-1)/2. For large values of N,
 * the comparison times will dominate, so we would have to say that the selection sort runs in O(N²) time, just as
 * the bubble sort did. However, it is unquestionably faster because there are so few swaps. For smaller values of N,
 * the selection sort may in fact be considerably faster, especially if the swap times are much larger than the comparison times.
 */
public class SelectionSort {
    
    /**
     * Implements an iterative selection sort.
     * 
     * Time complexity: O(N²)
     * Space complexity: O(1)
     * 
     * @param <T> the type of elements in the array. In order for the sort to work, these elements must be
     *            {@link java.lang.Comparable} to themselves.
     * @param items an array containing the elements to sort.
     */
    public <T extends Comparable<T>> void iterativeSelectionSort(T[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            int minimumIndex = i;
            
            for (int j = i + 1; j < items.length; j++) {
                if (items[j].compareTo(items[minimumIndex]) < 0) {
                    minimumIndex = j;
                }
            }
            
            if (minimumIndex != i) {
                T temp = items[i];
                items[i] = items[minimumIndex];
                items[minimumIndex] = temp;
            }
        }
    }
    
    /**
     * Implements a recursive selection sort.
     * 
     * Time complexity: O(N²)
     * Space complexity: O(N)
     * 
     * @param <T> the type of elements in the array. In order for the sort to work, these elements must be
     *            {@link java.lang.Comparable} to themselves.
     * @param items an array containing the elements to sort.
     */
    public <T extends Comparable<T>> void recursiveSelectionSort(T[] items) {
        this.recursiveSelectionSort(items, 0);
    }
    
    private <T extends Comparable<T>> void recursiveSelectionSort(T[] items, int lowerIndex) {
        if (lowerIndex < items.length - 1) {
            int minimumIndex = lowerIndex;
            
            for (int i = lowerIndex + 1; i < items.length; i++) {
                if (items[i].compareTo(items[minimumIndex]) < 0) {
                    minimumIndex = i;
                }
            }
            
            if (minimumIndex != lowerIndex) {
                T temp = items[lowerIndex];
                items[lowerIndex] = items[minimumIndex];
                items[minimumIndex] = temp;
            }
            
            recursiveSelectionSort(items, lowerIndex + 1);
        }
    }
}