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
 * Test cases for the {@link UnorderedArray} class.
 */
class UnorderedArrayTests {

    /**
     * Test method for {@link UnorderedArray#insert(java.lang.Object) UnorderedArray.insert(T)}.
     * When insert random elements, these elements should be correctly stored.
     */
    @Test
    void insert_RandomElements_CorrectlyStored() {
        UnorderedArray<Integer> array = new UnorderedArray<Integer>(4);
        
        array.insert(7);
        array.insert(9);
        array.insert(3);
        array.insert(11);
        
        assertEquals(11, array.get(3));
        assertEquals(3, array.get(2));
        assertEquals(9, array.get(1));
        assertEquals(7, array.get(0));
    }
    
    /**
     * Test method for {@link UnorderedArray#insert(java.lang.Object) UnorderedArray.insert(T)}.
     * When try to insert more elements than the capacity, an exception should be be thrown.
     */
    @Test
    void insert_ElementsCountGreaterThanSize_ExceptionThrown() {
        UnorderedArray<Integer> array = new UnorderedArray<Integer>(4);
        
        array.insert(7);
        array.insert(9);
        array.insert(3);
        array.insert(11);
        
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            array.insert(8);
        });
    }
    
    /**
     * Test method for {@link UnorderedArray#insert(java.lang.Object) UnorderedArray.insert(T)}.
     * When insert random elements, the size should be correctly updated.
     */
    @Test
    void insert_RandomElements_SizeCorrectlyUpdated() {
        UnorderedArray<Integer> array = new UnorderedArray<Integer>(10);
        
        assertEquals(0, array.size());
        
        array.insert(7);
        array.insert(9);
        array.insert(3);
        array.insert(11);
        array.insert(8);
        
        assertEquals(5, array.size());
    }
    
    /**
     * Test method for {@link UnorderedArray#search(java.lang.Object) UnorderedArray.search(T)}.
     */
    @Test
    void search() {
        UnorderedArray<Integer> array = new UnorderedArray<Integer>(5);
        
        assertFalse(array.search(200) >= 0);
        
        array.insert(7);
        array.insert(9);
        array.insert(3);
        array.insert(11);
        array.insert(8);
        
        assertFalse(array.search(15) >= 0);
        assertTrue(array.search(3) >= 0);
        assertTrue(array.search(7) >= 0);
        assertTrue(array.search(8) >= 0);
        
        array.delete(9);
        array.delete(11);
        
        assertFalse(array.search(9) >= 0);
        assertTrue(array.search(3) >= 0);
    }
    
    /**
     * Test method for {@link UnorderedArray#delete(java.lang.Object) UnorderedArray.delete(T)}.
     * When insert and delete random elements, the remaining elements should be correctly stored.
     */
    @Test
    void delete_RandomElements_CorrectlyStored() {
        UnorderedArray<Integer> array = new UnorderedArray<Integer>(6);
        
        array.insert(7);
        array.insert(9);
        array.insert(3);
        array.insert(11);
        array.insert(8);
        array.insert(4);
        
        array.delete(7);
        array.delete(3);
        array.delete(4);
        
        assertEquals(9, array.get(0));
        assertEquals(11, array.get(1));
        assertEquals(8, array.get(2));
    }
    
    /**
     * Test method for {@link UnorderedArray#delete(java.lang.Object) UnorderedArray.delete(T)}.
     * The array must return the correct value if the element to be deleted exists or not.
     */
    @Test
    void delete_RandomElements_ShouldReturnCorrectlyIfElementExists() {
        UnorderedArray<Integer> array = new UnorderedArray<Integer>(6);
        
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
     * Test method for {@link UnorderedArray#delete(java.lang.Object) UnorderedArray.delete(T)}.
     * When delete random elements, the size should be correctly updated.
     */
    @Test
    void delete_RandomElements_SizeCorrectlyUpdated() {
        UnorderedArray<Integer> array = new UnorderedArray<Integer>(5);
        
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