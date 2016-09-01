package com.trial.TIJ4.io;//: io/DirList2.java
// Uses anonymous inner classes.
// {Args: "D.*\.java"}
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList2 {
  public static FilenameFilter filter(String regex) {
    // Creation of anonymous inner class:
    return new FilenameFilter() {
      private Pattern pattern = Pattern.compile(regex);
      public boolean accept(File dir, String name) {
//          System.out.println(name);
        return pattern.matcher(name).matches();
      }
    }; // End of anonymous inner class
  }
  public static void main(String[] args) {
//    File path = new File(".");
      String filePath = "F:/ideal/demo2/src/main/java/com/trial/TIJ4/generics";
      String regex = "^D\\w+\\.cpp";
      args[0] = regex;
      System.out.println("\targs[0] = " + (args[0]));
      Pattern pattern = Pattern.compile(regex);
      File path = new File(filePath);
    String[] list;
    if(args.length == 0)
      list = path.list();
    else{
        list = path.list(filter(args[0]));
//        list = path.list();
        System.out.println(list.length + "\t" + path.getAbsolutePath() + "\targs[0] = " + (args[0]));
    }
    Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    for(String dirItem : list)
      System.out.println(dirItem);
  }
} /* Output:
DirectoryDemo.java
DirList.java
DirList2.java
DirList3.java
*///:~
