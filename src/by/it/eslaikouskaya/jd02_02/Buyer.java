package by.it.eslaikouskaya.jd02_02;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

class Buyer extends Thread implements IBuyer, IUseBasket{


    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        addToQueue();
        goOut();
    }

    Object getMonitor(){
        return this;
    }

    Buyer(int number, String pensioner) {
        super("Buyer"+pensioner+" № "+number);
        Dispatcher.newBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" start to choose goods");
        if (this.toString().contains("pensioner")){
            int timeout = Util.random(750, 3000);
            Util.sleep(timeout);
        } else {
            int timeout = Util.random(500, 2000);
            Util.sleep(timeout);
        }
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" take basket");
        if (this.toString().contains("pensioner")){
            int timeout = Util.random(100, 200);
            Util.sleep(timeout);
        } else {
            int timeout = Util.random(150, 300);
            Util.sleep(timeout);
        }
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this+" start put goods to basket");
        if (this.toString().contains("pensioner")){
            int timeout = Util.random(100, 200);
            Util.sleep(timeout);
        } else {
            int timeout = Util.random(150, 300);
            Util.sleep(timeout);
        }
        String check = check();
	    System.out.println(check);
	    System.out.println(this+" finish put goods to basket");
    }

   public String check() {
	   Map<String, Double> products = Dispatcher.getGoods();
	   Set<String> keySets = products.keySet();
	   ArrayList<String> productNames = new ArrayList<>(keySets);
	   StringBuilder sb = new StringBuilder();

	   int goodsInBasket = Util.random(1, 4);
	   double amount = 0;
	   for (int i = 0; i < goodsInBasket; i++) {
		   String productInBasket = productNames.get(Util.random
				   (0, productNames.size() - 1));
		   Double value = products.get(productInBasket);
		   amount+=value;
		   sb.append(this).append(" buy ").append(productInBasket).append(": ").append(value).append("\n");
	   }
	   sb.append("Total amount is: ").append(amount);
	   return sb.toString();
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
        String check = check();
	    System.out.println(check);
    }

    @Override
    public void goOut() {
        System.out.println(this+" go out from the market");
        Dispatcher.deleteBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
