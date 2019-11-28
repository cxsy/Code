// /**
//  * ProducerConsumer
//  */
// public class ProducerConsumer {

//     public static void main(String[] args) {
//         SyncStack ss = new SyncStack();
//         Producer p = new Producer(ss);
//         Consumer c = new Consumer(ss);
//         new Thread(p).start();
//         new Thread(c).start();
//     }
// }

// class WoTou {
//     int id;

//     WoTou(int id) {
//         this.id = id;
//     }

//     @Override
//     public String toString() {
//         return "WoTou: " + id;
//     }
// }

// class SyncStack {
//     int index = 0;
//     WoTou[] arrWT = new WoTou[6];

//     public synchronized void push(WoTou wt) {
//         while (index == arrWT.length) {
//             try {
//                 this.wait();
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//         System.out.println("生产了: " + wt.toString());
//         arrWT[index++] = wt;
//         this.notify();
//     }

//     public synchronized void pop() {
//         while (index == 0) {
//             try {
//                 this.wait();
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//         System.out.println("消费了: " + arrWT[--index].toString());
//         this.notify();
//     }
// }

// class Producer implements Runnable {
//     SyncStack ss = null;

//     Producer(SyncStack ss) {
//         this.ss = ss;
//     }

//     @Override
//     public void run() {
//         for (int i = 0; i < 20; i++) {
//             WoTou wt = new WoTou(i);
//             ss.push(wt);
//             try {
//                 Thread.sleep((int) (Math.random() * 1000));
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// class Consumer implements Runnable {
//     SyncStack ss = null;

//     Consumer(SyncStack ss) {
//         this.ss = ss;
//     }

//     @Override
//     public void run() {
//         for (int i = 0; i < 20; i++) {
//             ss.pop();
//             try {
//                 Thread.sleep((int) (Math.random() * 200));
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }