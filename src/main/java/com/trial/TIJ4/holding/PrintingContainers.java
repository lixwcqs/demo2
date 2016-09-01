package com.trial.TIJ4.holding;//: holding/PrintingContainers.java
// Containers print themselves automatically.
import java.util.*;
import static net.mindview.util.Print.*;

public class PrintingContainers {
  static Collection fill(Collection<String> collection) {
    collection.add("rat");
    collection.add("cat");
    collection.add("dog");
    collection.add("dog");
    return collection;
  }
  static Map fill(Map<String,String> map) {
    map.put("rat", "Fuzzy");
    map.put("cat", "Rags");
    map.put("dog", "Bosco");
    map.put("dog", "Spot");
    return map;
  }
  public static void main(String[] args) {
    print(fill(new ArrayList<String>()));

    print(fill(new LinkedList<String>()));
    print(fill(new HashSet<String>()));
    print(fill(new TreeSet<String>()));
    print(fill(new LinkedHashSet<String>()));
    print(fill(new HashMap<String,String>()));
    print(fill(new TreeMap<String,String>()));
    print(fill(new LinkedHashMap<String,String>()));

      Set hashSet = new HashSet<>();//faster access
      Set treeSet = new TreeSet<>();//sorted
      Set linkSet = new LinkedHashSet<>() ;// remain add sort
      double tmp;
      Random randow = new Random();
      for (int i = 0; i < 20; i++) {
          tmp = ((int) (randow.nextDouble() * 10000 ))/100.0;
          hashSet.add(tmp);
          treeSet.add(tmp);
          linkSet.add(tmp);
      }
      System.out.println(linkSet);
      System.out.println(hashSet);
      System.out.println(treeSet);
  }
} /* Output:
[rat, cat, dog, dog]
[rat, cat, dog, dog]
[dog, cat, rat]
[cat, dog, rat]
[rat, cat, dog]
{dog=Spot, cat=Rags, rat=Fuzzy}
{cat=Rags, dog=Spot, rat=Fuzzy}
{rat=Fuzzy, cat=Rags, dog=Spot}
*///:~
