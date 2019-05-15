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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test cases for the {@link OrderedArray} class.
 */
class OrderedArrayTests {

    /**
     * Test method for {@link OrderedArray#insert(java.lang.Comparable)}.
     * When insert random elements, these elements should be correctly stored.
     */
    @Test
    void insert_RandomElements_CorrectlyStored() {
        OrderedArray<Integer> array = new OrderedArray<Integer>(11);
        
        array.insert(51);
        array.insert(5);
        array.insert(8);
        array.insert(46);
        array.insert(40);
        array.insert(2);
        array.insert(55);
        array.insert(20);
        array.insert(28);
        array.insert(36);
        array.insert(32);
        
        assertEquals(2, array.get(0));
        assertEquals(5, array.get(1));
        assertEquals(8, array.get(2));
        assertEquals(20, array.get(3));
        assertEquals(28, array.get(4));
        assertEquals(32, array.get(5));
        assertEquals(36, array.get(6));
        assertEquals(40, array.get(7));
        assertEquals(46, array.get(8));
        assertEquals(51, array.get(9));
        assertEquals(55, array.get(10));
    }

    /**
     * Test method for {@link OrderedArray#insert(java.lang.Comparable)}.
     * When try to insert more elements than the capacity, an exception should be be thrown.
     */ 
    @Test
    void insert_ElementsCountGreaterThanSize_ExceptionThrown() {
        OrderedArray<Integer> array = new OrderedArray<Integer>(4);
        
        array.insert(7);
        array.insert(9);
        array.insert(3);
        array.insert(11);
        
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            array.insert(8);
        });
    }
    
    /**
     * Test method for {@link OrderedArray#insert(java.lang.Comparable)}.
     * When insert random elements, the size should be correctly updated.
     */
    @Test
    void insert_RandomElements_SizeCorrectlyUpdated() {
        OrderedArray<Integer> array = new OrderedArray<Integer>(10);
        
        assertEquals(0, array.size());
        
        array.insert(7);
        array.insert(9);
        array.insert(3);
        array.insert(11);
        array.insert(8);
        
        assertEquals(5, array.size());
    }
    
    /**
     * Test method for {@link OrderedArray#binarySearch(java.lang.Comparable)}.
     */
    @Test
    void binarySearch() {
        OrderedArray<Integer> array = new OrderedArray<Integer>(20);
        
        assertFalse(array.binarySearch(200));
        
        array.insert(51);
        array.insert(5);
        array.insert(8);
        array.insert(46);
        array.insert(40);
        array.insert(2);
        array.insert(55);
        array.insert(20);
        array.insert(28);
        array.insert(36);
        array.insert(32);
        
        assertFalse(array.binarySearch(200));
        assertFalse(array.binarySearch(6));
        assertTrue(array.binarySearch(55));
        assertTrue(array.binarySearch(2));
        assertTrue(array.binarySearch(32));
        assertTrue(array.binarySearch(28));
        
        array.delete(2);
        array.delete(32);
        
        assertFalse(array.binarySearch(2));
        assertFalse(array.binarySearch(32));
        assertTrue(array.binarySearch(55));
        assertTrue(array.binarySearch(28));
    }
    
    /**
     * Test method for {@link OrderedArray#delete(java.lang.Comparable)}.
     * When insert and delete random elements, the remaining elements should be correctly stored.
     */
    @Test
    void delete_RandomElements_CorrectlyStored() {
        OrderedArray<Integer> array = new OrderedArray<Integer>(11);
        
        array.insert(51);
        array.insert(5);
        array.insert(8);
        array.insert(46);
        array.insert(40);
        array.insert(2);
        array.insert(55);
        array.insert(20);
        array.insert(28);
        array.insert(36);
        array.insert(32);
        
        array.delete(55);
        array.delete(2);
        array.delete(46);
        array.delete(8);
        
        assertEquals(5, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(28, array.get(2));
        assertEquals(32, array.get(3));
        assertEquals(36, array.get(4));
        assertEquals(40, array.get(5));
        assertEquals(51, array.get(6));
    }
    
    /**
     * Test method for {@link OrderedArray#delete(java.lang.Comparable)}.
     * The array must return the correct value if the element to be deleted exists or not.
     */
    @Test
    void delete_RandomElements_ShouldReturnCorrectlyIfElementExists() {
        OrderedArray<Integer> array = new OrderedArray<Integer>(6);
        
        assertFalse(array.delete(9)); 
        
        array.insert(7);
        array.insert(9);
        array.insert(3);
        array.insert(11);
        array.insert(8);
        
        assertTrue(array.delete(9));
        assertTrue(array.delete(11));
        assertFalse(array.delete(20));
        assertFalse(array.delete(11));
    }
    
    /**
     * Test method for {@link OrderedArray#delete(java.lang.Comparable)}.
     * When delete random elements, the size should be correctly updated.
     */
    @Test
    void delete_RandomElements_SizeCorrectlyUpdated() {
        OrderedArray<Integer> array = new OrderedArray<Integer>(5);
        
        array.insert(7);
        array.insert(9);
        array.insert(3);
        array.insert(11);
        array.insert(8);
        
        array.delete(9);
        array.delete(11);
        
        assertEquals(3, array.size());
        
        array.delete(7);
        array.delete(3);
        array.delete(8);
        
        assertEquals(0, array.size());
    }
}