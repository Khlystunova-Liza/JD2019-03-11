package by.it.bildziuh.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Buyer extends Thread implements IBuyer, IUseBucket {

    HashMap<String, Double> paymentCheck = new HashMap<>();

    static List<Thread> buyers = new ArrayList<>();

    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        putGoodsToBucket();
        addToQueue();
        goOut();
    }

    Object getMonitor() {
        return this;
    }

    boolean pensioneer = false;

    Buyer(int number) {
        super("Buyer № " + number);
        if (Util.random(1, 4) == 4)
            this.pensioneer = true;
        Dispatcher.newBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start to choose goods");
        int timeout = Util.random(500, 2000);
        if (pensioneer)
            timeout *= 3 / 2;
        Util.sleep(timeout);
        System.out.println(this + " finish to choose goods");
    }

    @Override
    public void addToQueue() {
        System.out.println(this + " added to queue and wait");
        QueueBuyers.add(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(this + " complete service at cashier");
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from the market");
        Dispatcher.deleteBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBucket() {
        int timeout = Util.random(100, 200);
        if (pensioneer)
            timeout *= 3 / 2;
        Util.sleep(timeout);
        System.out.println(this + " took a bucket");
    }

    @Override
    public void putGoodsToBucket() {
        int timeout = Util.random(100, 200);
        if (pensioneer)
            timeout *= 3 / 2;
        Util.sleep(timeout);
        HashMap<String, Double> chosenGoods = new HashMap<>(Util.listOfGoods);
        Iterator iterator = chosenGoods.entrySet().iterator();
        int size = chosenGoods.size();
        while (iterator.hasNext() && chosenGoods.size() != Util.random(1, 4)) {
            iterator.next();
            if (Util.random(1, size) != size) {
                iterator.remove();
                size--;
            }
        }
        System.out.println(this + " putted goods into a bucket");
        paymentCheck.putAll(chosenGoods);
    }
}

