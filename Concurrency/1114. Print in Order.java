class Foo {

  //private AtomicInteger firstJobDone = new AtomicInteger(0);
  //private AtomicInteger secondJobDone = new AtomicInteger(0);
     Integer i1= 0;
     Integer i2=0;
  public Foo() {}

  public void first(Runnable printFirst) throws InterruptedException {
    // printFirst.run() outputs "first".
    printFirst.run();
    // mark the first job as done, by increasing its count.
    //firstJobDone.incrementAndGet();
      i1=1;
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (!i1.equals(1)) {
      // waiting for the first job to be done.
    }
    // printSecond.run() outputs "second".
    printSecond.run();
    // mark the second as done, by increasing its count.
   // secondJobDone.incrementAndGet();
      i2=1;
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (!i2.equals(1)) {
      // waiting for the second job to be done.
    }
    // printThird.run() outputs "third".
    printThird.run();
  }
}
