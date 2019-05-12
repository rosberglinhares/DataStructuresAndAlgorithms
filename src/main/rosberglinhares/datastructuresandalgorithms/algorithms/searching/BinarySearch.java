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

package rosberglinhares.datastructuresandalgorithms.algorithms.searching;

/**
 * Searches for a specified item by repeatedly dividing in half the range of array elements to be considered.
 */
public class BinarySearch {
    
    /**
     * Executes an iterative binary search.
     * 
     * Time complexity: O(log N)
     * Space complexity: O(1)
     * 
     * @param <T> the type of elements in the array. For the ordering to work, these elements must be
     *            {@link java.lang.Comparable} to themselves.
     * @param elements a sorted array containing the elements to search.
     * @param value the value to search.
     * @return {@code true} if the element is found.
     */
    public <T extends Comparable<T>> boolean iterativeBinarySearch(T[] elements, T value) {
        return this.iterativeBinarySearch(elements, 0, elements.length - 1, value);
    }
    
    public <T extends Comparable<T>> boolean iterativeBinarySearch(T[] elements, int lowerIndex, int upperIndex, T value) {
        while (lowerIndex <= upperIndex) {
            int middleIndex = (lowerIndex + upperIndex) / 2;
            
            if (value.compareTo(elements[middleIndex]) == 0) {
                return true;
            } else if (value.compareTo(elements[middleIndex]) < 0) {
                upperIndex = middleIndex - 1;
            } else {
                lowerIndex = middleIndex + 1;
            }
        }
        
        return false;
    }
    
    /**
     * Executes a recursive binary search.
     *
     * Time complexity: O(log N)
     * Space complexity: O(log N)
     * 
     * @param <T> the type of elements in the array. For the ordering to work, these elements must be
     *            {@link java.lang.Comparable} to themselves.
     * @param elements a sorted array containing the elements to search.
     * @param value the value to search.
     * @return {@code true} if the element is found.
     */
    public <T extends Comparable<T>> boolean recursiveBinarySearch(T[] elements, T value) {
        return this.recursiveBinarySearch(elements, 0, elements.length - 1, value);
    }
    
    private <T extends Comparable<T>> boolean recursiveBinarySearch(T[] elements, int lowerIndex, int upperIndex, T value) {
        if (lowerIndex <= upperIndex) {
            int middleIndex = (lowerIndex + upperIndex) / 2;
            
            if (value.compareTo(elements[middleIndex]) == 0) {
                return true;
            } else if (value.compareTo(elements[middleIndex]) < 0) {
                return this.recursiveBinarySearch(elements, lowerIndex, middleIndex - 1, value);
            } else {
                return this.recursiveBinarySearch(elements, middleIndex + 1, upperIndex, value);
            }
        } else {
            return false;
        }
    }
}