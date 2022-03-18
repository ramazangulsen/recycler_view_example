package com.ramazangulsen.landmarkbook;

public class Singleton {
  private Landmark sentLandmark;
  private static Singleton singleton;
  private Singleton(){

  }
  public Landmark getSentLandmark(){
      return sentLandmark;
  }
  public Landmark setSentLandmark(Landmark sentLandmark){
      return sentLandmark;
  }
  //şu ana kadar oluşturulmuş objeyi döndürecek. her zaman aynı obje dönecek.
  public static Singleton getInstance(){
      if(singleton == null) {
          singleton = new Singleton();
      }

      return singleton;
  }

}
