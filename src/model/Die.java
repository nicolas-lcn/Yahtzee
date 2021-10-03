package model;

import java.util.Random;

public class Die {

  private Random generator = new Random();
  private int faceValue;
  private boolean isBlocked;

  public Die() {
    this.faceValue = generator.nextInt(6)+1;
    this.isBlocked = true;
  }

  public boolean isBlocked() {
    return isBlocked;
  }

  public void unblock() {
    isBlocked = false;
  }

  public void block() {
    isBlocked = true;
  }

  public int value() {
    return faceValue;
  }

  public void roll(){
    if (!isBlocked){
      faceValue = generator.nextInt(6)+1;
    }
  }
}
