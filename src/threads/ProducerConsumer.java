package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {
    public static void main(String[] args) {
        final int COUNT = 1000;
        final int N_THREADS = 1;
        
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                int [] data = new int[COUNT];
                while (true) {
                    try {
                        int num = q.take();
                        data[num]++;
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
                for (int idx = 0; idx < COUNT; idx++) {
                    int x = data[idx];
                    if (x != N_THREADS) {
                        System.out.println("ERROR!!! at index ");
                    }
                }
                System.out.println("All finished at consumer");
            }
        };
        
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < COUNT; i++) {
                    try {
                        q.put(i);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        
        Thread[] ta = new Thread[N_THREADS];
        for (int idx = 0; idx < ta.length; idx++) {
            ta[idx] = new Thread(producer);
            ta[idx].start();
        }
        Thread cons = new Thread(consumer);
        cons.start();
        
        for (int idx = 0; idx < ta.length; idx++) {
            try {
                ta[idx].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("All producers finished, interrupting consumer...");
        cons.interrupt();
    }
}
