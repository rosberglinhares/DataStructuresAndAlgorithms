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
 * In most cases the insertion sort is the best of the elementary sorts. It still executes in O(N²) time,
 * but it’s about twice as fast as the bubble sort and somewhat faster than the selection sort in normal situations.
 * It’s also not too complex, although it’s slightly more involved than the bubble and selection sorts.
 * It’s often used as the final stage of more sophisticated sorts, such as merge sort or quick sort.
 * 
 * For data that is already sorted or almost sorted, the insertion sort does much better. When data is in order,
 * the algorithm runs in O(N) time. If the data is almost sorted, insertion sort runs in almost O(N) time,
 * which makes it a simple and efficient way to order information that is only slightly out of order.
 * However, for data arranged in inverse sorted order, every possible comparison and shift is carried out,
 * so the insertion sort runs no faster than the bubble sort.
 * 
 * You start marking the second item in the left. This item will be the leftmost unsorted item in the list.
 * Then you walking down the line to the left. At each position you shift another item to the right, but you also
 * compare the marked item with the item about to be shifted.
 * The shifting process stops when you’ve shifted the last item that’s taller than the marked item.
 * The last shift opens up the space where the marked item, when inserted, will be in sorted order.
 * Now the partially sorted group is one item bigger, and the unsorted group is one item smaller. Then the marked item
 * is moved one space to the right, so it’s again the leftmost unsorted item. This process is repeated until all the
 * unsorted items have been inserted (hence the name insertion sort) into the appropriate place in the partially sorted group.
 */
public class InsertionSort {
    
    /**
     * Implements an iterative insertion sort.
     * 
     * Time complexity: O(N²)
     * Space complexity: O(1)
     * 
     * @param <T> the type of elements in the array. In order for the sort to work, these elements must be
     *            {@link java.lang.Comparable} to themselves.
     * @param items an array containing the elements to sort.
     */
    public <T extends Comparable<T>> void iterativeInsertionSort(T[] items) {
        for (int i = 1; i < items.length; i++) {
            T insertItem = items[i];
            
            for (int j = i; j >= 1 && (items[j].compareTo(items[j - 1]) < 0); j--) {
                items[j] = items[j - 1];
                items[j - 1] = insertItem;
            }
        }
    }
    
    /**
     * Implements a recursive insertion sort.
     * 
     * Time complexity: O(N²)
     * Space complexity: O(N)
     * 
     * @param <T> the type of elements in the array. In order for the sort to work, these elements must be
     *            {@link java.lang.Comparable} to themselves.
     * @param items an array containing the elements to sort.
     */
    public <T extends Comparable<T>> void recursiveInsertionSort(T[] items) {
        this.recursiveInsertionSort(items, 1);
    }
    
    private <T extends Comparable<T>> void recursiveInsertionSort(T[] items, int itemIndex) {
        if (itemIndex < items.length) {
            T insertItem = items[itemIndex];
            
            for (int i = itemIndex; i >= 1 && (items[i].compareTo(items[i - 1]) < 0); i--) {
                items[i] = items[i - 1];
                items[i - 1] = insertItem;
            }
            
            recursiveInsertionSort(items, itemIndex + 1);
        }
    }
}