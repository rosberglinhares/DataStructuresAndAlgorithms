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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.BiPredicate;

import org.junit.jupiter.api.Test;

/**
 * Test cases for the {@link rosberglinhares.datastructuresandalgorithms.algorithms.searching.BinarySearch} class.
 */
class BinarySearchTests {

    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.searching.BinarySearch#iterativeBinarySearch(java.lang.Comparable<T>[], java.lang.Comparable<T>)}.
     */
    @Test
    void iterativeBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        
        this.testBinarySearch(binarySearch::iterativeBinarySearch);
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.searching.BinarySearch#iterativeBinarySearch(java.lang.Comparable<T>[], int, int, java.lang.Comparable<T>)}.
     */
    @Test
    void iterativeBinarySearchRange() {
        BinarySearch binarySearch = new BinarySearch();
        
        Integer[] ints = { 2, 5, 8, 20, 28, 32, 36, 40, 46, 51, 55 };
        
        assertFalse(binarySearch.iterativeBinarySearch(ints, 0, 4, 32));
        assertFalse(binarySearch.iterativeBinarySearch(ints, 1, 4, 2));
        assertFalse(binarySearch.iterativeBinarySearch(ints, 7, 9, 55));
        assertTrue(binarySearch.iterativeBinarySearch(ints, 3, 7, 20));
        assertTrue(binarySearch.iterativeBinarySearch(ints, 3, 7, 40));
        assertTrue(binarySearch.iterativeBinarySearch(ints, 3, 7, 32));
        assertTrue(binarySearch.iterativeBinarySearch(ints, 0, 10, 2));
        assertTrue(binarySearch.iterativeBinarySearch(ints, 0, 10, 55));
    }
    
    /**
     * Test method for {@link rosberglinhares.datastructuresandalgorithms.algorithms.searching.BinarySearch#recursiveBinarySearch(java.lang.Comparable<T>[], java.lang.Comparable<T>)}.
     */
    @Test
    void recursiveBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        
        this.testBinarySearch(binarySearch::recursiveBinarySearch);
    }
    
    /**
     * The iterative and recursive methods can be tested in the same way.
     * 
     * @param binarySearchMethodRef a method reference to the method to be tested.
     */
    private <T> void testBinarySearch(BiPredicate<Integer[], Integer> binarySearchMethodRef) {
        Integer[] ints = { 2, 5, 8, 20, 28, 32, 36, 40, 46, 51, 55 };
        
        assertFalse(binarySearchMethodRef.test(new Integer[0], 200));
        assertTrue(binarySearchMethodRef.test(ints, 2));
        assertTrue(binarySearchMethodRef.test(ints, 55));
        assertTrue(binarySearchMethodRef.test(ints, 32));
        assertTrue(binarySearchMethodRef.test(ints, 20));
        assertFalse(binarySearchMethodRef.test(ints, 3));
        assertFalse(binarySearchMethodRef.test(ints, 31));
        assertFalse(binarySearchMethodRef.test(ints, 54));
        assertFalse(binarySearchMethodRef.test(ints, 1000));
        assertFalse(binarySearchMethodRef.test(ints, -10));
    }
}