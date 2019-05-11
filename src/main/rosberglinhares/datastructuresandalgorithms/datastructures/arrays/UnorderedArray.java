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

/**
 * Implements an unordered array.
 *
 * @param <T> the type of elements in this array.
 */
public class UnorderedArray<T> {
    private static int ELEMENT_NOT_FOUND = -1;
    
    private T[] elements;
    private int size;
    
    @SuppressWarnings("unchecked")
    public UnorderedArray(int maxSize) {
        this.elements = (T[])new Object[maxSize];
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
     * A new item is always inserted in the first vacant cell in the array, and the algorithm knows this location
     * because it knows how many items are already in the array. The new item is simply inserted in the next available space.
     * Searching and deletion, however, are not so fast.
     * 
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public void insert(T value) {
        this.elements[this.size++] = value;
    }
    
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public T get(int index) {
        return this.elements[index];
    }
    
    /**
     * Executes a linear search.
     * 
     * Notice that the search algorithm must look through an average of half the data items to find a specified item.
     * Items close to the beginning of the array will be found sooner, and those toward the end will be found later.
     * If N is the number of items, the average number of steps needed to find an item is N/2. In the worst-case scenario,
     * the specified item is in the last occupied cell, and N steps will be required to find it.
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     * 
     * @param value the element to be searched.
     * @return the index of the element found or {@code -1} if the element was not found.
     */
    public int search(T value) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(value)) {
                return i;
            }
        }
        
        return ELEMENT_NOT_FOUND;
    }
    
    /** 
     * Implicit in the deletion algorithm is the assumption that holes are not allowed in the array.
     * A hole is one or more empty cells that have filled cells above them (at higher index numbers).
     * If holes are allowed, all the algorithms become more complicated because they must check to see whether a cell
     * is empty before examining its contents. Also, the algorithms become less efficient because they must waste time
     * looking at unoccupied cells.
     * A deletion requires searching through an average of N/2 elements and then moving the remaining elements
     * (an average of N/2 moves) to fill up the resulting hole.
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     * 
     * @param value element to be removed from this array, if present.
     * @return {@code true} if this array contained the specified element.
     */
    public boolean delete(T value) {
        int i = this.search(value);
        
        if (i > ELEMENT_NOT_FOUND) {
            for (; i < this.size - 1; i++) {
                this.elements[i] = this.elements[i + 1]; 
            }
            
            this.size--;
            
            return true;
        } else {
            return false;
        }
    }
}