package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)

  // TODO Question: What conclusions can you draw about the performance of LinkedList vs. ArrayList when
  // comparing their running times for AddRemove vs. Access? Record those running times in README.txt!
  // My conclusion is that when it comes to add/remove LinkedList is much faster than ArrayList since LinkedList is (O(1)) and ArrayList is (O(n)).
  // When it comes down to random access by the index the ArrayList is much more faster than LinkedList.
  // Overall, use LinkedList when you need constant insertions and removals at the beggining or the middle.
  // And use ArrayList wjem you need constant random access by index.
  
  // TODO (optional) refactor to DRY
  // which of the two lists performs better as the size increases?
  // And as the size increases the performance differences show up more.
  // Looking at it the LinkedList add/remove time stays constant no matter the size, while ArrayList add/remove time grows linear with the size.
  // ArrayList access time does stay constant while LinkedList acces time grows linear with the size.
  private final int SIZE = 1000; //number of elements in the list

  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes
  private final int REPS = 10000; //number of repetitions of the operation

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (var i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    for (var r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
  }

  @Test
  public void testArrayListAddRemove() {
    for (var r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
  }

  @Test
  public void testLinkedListAccess() {
    var sum = 0L;
    for (var r = 0; r < REPS; r++) {
      sum += linkedList.get(r % SIZE);
    }
  }

  @Test
  public void testArrayListAccess() {
    var sum = 0L;
    for (var r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);
    }
  }
}
