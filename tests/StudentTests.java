package tests;

import static org.junit.Assert.*;
import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;
import org.junit.Test;
import java.util.*;

public class StudentTests<T> {

 Comparator<Integer> cp = new Comparator<Integer>() {
  public int compare(Integer o1, Integer o2) {
   return o1.compareTo(o2);
  }
 };

 @Test
 public void testBasicConstructor() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  assertEquals(0, bl.getSize());
 }

 @Test
 public void testAddToFront() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  bl.addToFront(3);
  bl.addToFront(33);
  bl.addToFront(333);

  assertEquals(3, bl.getSize());
  Iterator iter = bl.iterator();
  int[] arr = new int[] { 333, 33, 3 };
  int i = 0;
  while (iter.hasNext()) {
   assertEquals(arr[i], iter.next());
   i++;
  }
 }

 @Test
 public void testAddToEnd() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  bl.addToEnd(12);
  bl.addToEnd(8);
  bl.addToEnd(365);
  bl.addToEnd(40);

  assertEquals(4, bl.getSize());
  ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 8, 365, 40));
  Collections.reverse(arr);
  assertEquals(arr, bl.getReverseArrayList());
 }

 @Test
 public void testGetFirst() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  int[] arr = new int[] { 12, 3, 4, 5, 6, 7, 8, 9 };
  for (int i : arr) {
   bl.addToEnd(i);
  }
  assertTrue(12 == bl.getFirst());
 }

 @Test
 public void testGetLast() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  int[] arr = new int[] { 12, 3, 4, 5, 6, 7, 8, 9 };
  for (int i : arr) {
   bl.addToEnd(i);
  }
  assertTrue(9 == bl.getLast());
 }

 @Test
 public void testRetrieveFirst() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  int[] arr = new int[] { 40, 5, 6, 7, 8, 9 };
  for (int i : arr) {
   bl.addToEnd(i);
  }
  assertTrue(40 == bl.retrieveFirstElement());
  assertEquals(5, bl.getSize());
  assertTrue(5 == bl.getFirst());
 }

 @Test
 public void testRetrieveLast() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  int[] arr = new int[] { 40, 5, 6, 7, 8, 9 };
  for (int i : arr) {
   bl.addToEnd(i);
  }
  ArrayList<Integer> checkArr = new ArrayList<>(Arrays.asList(40, 5, 6, 7, 8));
  Collections.reverse(checkArr);
  assertTrue(9 == bl.retrieveLastElement());
  assertEquals(checkArr, bl.getReverseArrayList());
 }

 @Test
 public void testRemove() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  int[] arr = new int[] { 1, 1, 1, 1, 1, 1, 12, 3, 4, 5, 6, 7 };
  for (int i : arr) {
   bl.addToEnd(i);
  }
  bl.remove(1, cp);
  ArrayList<Integer> checkArr = new ArrayList<>(Arrays.asList(7, 6, 5, 4, 3, 12));
  assertEquals(checkArr, bl.getReverseArrayList());
 }

 @Test
 public void testReverse() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  int[] arr = new int[] { 1, 1, 1, 1, 1, 1, 12, 3, 4, 5, 6, 7 };
  for (int i : arr) {
   bl.addToEnd(i);
  }
  bl.remove(1, cp);
  bl.getReverseArrayList();
  ArrayList<Integer> checkArr = new ArrayList<>(Arrays.asList(7, 6, 5, 4, 3, 12));
  assertEquals(checkArr, bl.getReverseArrayList());
  bl = bl.getReverseList();
  Collections.reverse(checkArr);
  assertEquals(checkArr, bl.getReverseArrayList());
 }

 @Test
 public void testBasicIter() {
  BasicLinkedList<Integer> bl = new BasicLinkedList<>();
  int[] arr = new int[] { 1, 1, 1, 1, 1, 1, 12, 3, 4, 5, 6, 7, 8, 9 };
  for (int i : arr) {
   bl.addToEnd(i);
  }
  Iterator iter = bl.iterator();
  int i = 0;
  while (iter.hasNext()) {
   assertEquals(arr[i], iter.next());
   i++;
  }
 }

 @Test
 public void testSorted() {
  SortedLinkedList<Integer> bl = new SortedLinkedList<Integer>(cp);
  ArrayList<Integer> checkArr = new ArrayList<>(Arrays.asList(1, 10, 1, 12, 5, 6, 700, 19));

  for (int i : checkArr) {
   bl.add(i);
  }

  Collections.sort(checkArr);
  Collections.reverse(checkArr);
  assertEquals(checkArr, bl.getReverseArrayList());

 }

 @Test
 public void testSortedRemove() {
  SortedLinkedList<Integer> bl = new SortedLinkedList<Integer>(cp);
  ArrayList<Integer> checkArr = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 10, 1, 12, 5, 1, 16, 700, 19, 1, 1));

  for (int i : checkArr) {
   bl.add(i);
  }

  Collections.sort(checkArr);
  Collections.reverse(checkArr);
  checkArr.removeAll(Collections.singleton(1));
  assertEquals(checkArr, bl.remove(1).getReverseArrayList());
 }

 @Test
 public void testSortedAddToFront() {
  SortedLinkedList<Integer> bl = new SortedLinkedList<Integer>(cp);
  try {
   bl.addToFront(1);
   fail();
  } catch (Exception e) {
   assertTrue(e.getClass() == UnsupportedOperationException.class);
   assertEquals(e.getMessage(), "Invalid operation for sorted list.");
  }
 }

 @Test
 public void testSortedAddToEnd() {
  SortedLinkedList<Integer> bl = new SortedLinkedList<Integer>(cp);
  try {
   bl.addToEnd(1);
   fail();
  } catch (Exception e) {
   assertTrue(e.getClass() == UnsupportedOperationException.class);
   assertEquals(e.getMessage(), "Invalid operation for sorted list.");
  }
 }

}