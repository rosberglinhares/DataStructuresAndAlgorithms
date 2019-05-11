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

package rosberglinhares.datastructuresandalgorithms.datastructures.arrays;

import rosberglinhares.datastructuresandalgorithms.algorithms.searching.BinarySearch;

/**
 * Implements an ordered array.
 * 
 * The payoff for using an ordered array comes when we use a binary search. This kind of search is much faster than
 * a linear search, especially for large arrays.
 *
 * @param <T> the type of elements in this array. For the ordering to work, these elements must be
 *            {@link java.lang.Comparable} to themselves.
 */
public class OrderedArray<T extends Comparable<T>> {
    private T[] elements;
    private int size;
    
    @SuppressWarnings("unchecked")
    public OrderedArray(int maxSize) {
        // It is not possible to create an array whose component type is a concrete parameterized type
        this.elements = (T[])new Comparable<?>[maxSize];
        this.size = 0;
    }
    
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public int size() {
        return this.size;
    }
    
    /**
     * When we insert an item into this array, the correct location must be found for the insertion:
     * just above a smaller value and just below a larger one. Then all the larger values must be moved up to make room.
     * 
     * We could have used a binary search to locate the position where a new item will be inserted.
     * But the speed penalty may not be important because an average of half the items must be moved anyway when
     * an insertion is performed, so insertion will not be very fast even if we locate the item with a binary search.
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public void insert(T value) {
        int indexToInsert = 0;
        
        while (indexToInsert < this.size && value.compareTo(this.elements[indexToInsert]) > 0) {
            indexToInsert++;
        }
        
        for (int i = this.size - 1; i >= indexToInsert; i--) {
            // An ArrayIndexOutOfBoundsException can be thrown here, if inserting more elements than the capacity.
            this.elements[i + 1] = this.elements[i];
        }
        
        this.elements[indexToInsert] = value;
        this.size++;
    }
    
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public T get(int index) {
        return this.elements[index];
    }
    
    /**
     * Searches for a specified item by repeatedly dividing in half the range of array elements to be considered.
     * 
     * Time complexity: O(log(n))
     * Space complexity: O(1)
     */
    public boolean binarySearch(T value) {
        BinarySearch binarySearch = new BinarySearch();
        
        return binarySearch.iterativeBinarySearch(this.elements, 0, this.size - 1, value);
    }
    
    /**
     * Deletion works much the same as it did in the {@link UnorderedArray} class, shifting items with higher index
     * numbers down to fill in the hole left by the deletion. In the ordered array, however, the deletion algorithm can
     * quit partway through if it doesn’t find the item, just as the search routine can.
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     * 
     * @param value element to be removed from this array, if present.
     * @return {@code true} if this array contained the specified element.
     */
    public boolean delete(T value) {
        int indexToDelete = 0;
        int comparisonResult = -1;
        
        while (indexToDelete < this.size && (comparisonResult = value.compareTo(this.elements[indexToDelete])) > 0) {
            indexToDelete++;
        }
        
        if (comparisonResult == 0) {  // Element found
            for (int i = indexToDelete; i < this.size - 1; i++) {
                this.elements[i] = this.elements[i + 1]; 
            }
            
            this.size--;
            
            return true;
        } else {
            return false;
        }
    }
}