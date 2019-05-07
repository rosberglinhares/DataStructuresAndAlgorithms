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
 * @param <T> the type of elements in this array
 */
public class UnorderedArray<T> {
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
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean find(T value) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(value)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean delete(T value) {
        int i;
        
        for (i = 0; i < this.size; i++) {
            if (this.elements[i].equals(value)) {
                break;
            }
        }
        
        if (i < this.size) {  // Element found
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