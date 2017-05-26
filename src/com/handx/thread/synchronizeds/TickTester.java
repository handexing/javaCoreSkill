package com.handx.thread.synchronizeds;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BuyTicket implements Runnable {

	private Ticket t;
	private int amount;

	public BuyTicket(Ticket t, int amount) {
		this.t = t;
		this.amount = amount;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(((int) (Math.random() * 10000)));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.withBuyTicket(amount);
	}
}

class Ticket {

	private int ticketCount;

	public Ticket(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public synchronized void withBuyTicket(int amount) {
		int currentTicketAmount = ticketCount;

		System.out.println("\n目前票数:" + currentTicketAmount);
		if (currentTicketAmount == 0) {
			System.out.println("票已全部售出！");
			return;
		}
		if (amount > currentTicketAmount) {
			System.out.println("需售出票数: " + amount + " 剩下票数为: " + currentTicketAmount + " 剩余票数不足 !");
		} else {
			currentTicketAmount = currentTicketAmount - amount;
			System.out.println(
					"售出票数:" + amount + " 剩余票数: " + currentTicketAmount + "::" + Thread.currentThread().getName());
			ticketCount = currentTicketAmount;
		}
	}
}

public class TickTester {

	public static void main(String[] args) {

		ExecutorService pool = Executors.newFixedThreadPool(5);

		Ticket t = new Ticket(10);

		BuyTicket a1 = new BuyTicket(t, 2);
		BuyTicket a2 = new BuyTicket(t, 2);
		BuyTicket a3 = new BuyTicket(t, 1);
		BuyTicket a4 = new BuyTicket(t, 1);
		BuyTicket a5 = new BuyTicket(t, 2);
		BuyTicket a6 = new BuyTicket(t, 3);

		pool.execute(a1);
		pool.execute(a2);
		pool.execute(a3);
		pool.execute(a4);
		pool.execute(a5);
		pool.execute(a6);


		pool.shutdown();
	}
}