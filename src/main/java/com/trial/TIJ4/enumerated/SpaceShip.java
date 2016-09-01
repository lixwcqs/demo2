package com.trial.TIJ4.enumerated;

//: enumerated/SpaceShip.java
public enum SpaceShip {
  SCOUT("xomqo"), CARGO("xomqo"), TRANSPORT("xomqo"), CRUISER, BATTLESHIP, MOTHERSHIP;

  SpaceShip() {
  }

  private String meaning;

  SpaceShip(String meaning) {
    this.meaning = meaning;
  }

  public String toString() {
    String id = name();
//    System.out.println("name: " + id);
    String lower = id.substring(1).toLowerCase();
    return id.charAt(0) + lower;
  }
  public static void main(String[] args) {
    for(SpaceShip s : values()) {
      System.out.println(s + "\t" + SpaceShip.CARGO.meaning);
    }
  }
} /* Output:
Scout
Cargo
Transport
Cruiser
Battleship
Mothership
*///:~
