In this assignment, we were challenged to implement simple data structures using only the standard collections of java.util.*

Code Structure:
Each data structure is implemented in a single file. All generics are properly bounded, if needed, with Comparable<T> for comparison support.

MyArrayList:
It internally keeps an Object[] array.

The array resizes automatically when full.

Methods: add, remove, get, set, size, isEmpty, clear, iterator.

MyLinkedList:
The private inner class MyNode<E> keeps next and prev references.

Methods are the same as MyArrayList, but using pointer implementation.

MyStack:
Uses MyLinkedList.

Methods: push, pop, peek, isEmpty.

MyQueue:
Based on MyLinkedList too.

Methods: enqueue, dequeue, peek, isEmpty.

MyMinHeap:
Based on MyArrayList.

Methods: add, poll, peek, isEmpty.

Used heapify methods for "bubble up" and "bubble down".

