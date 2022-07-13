package com.company;

public class SynchronizationExample {
	private String mMessage;

	public static void main(String[] agrs) {
		SynchronizationExample temp = new SynchronizationExample();

		System.out.println("Test start!");
		new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				temp.callMe("Thread1");
			}
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				temp.callMe("Thread2");
			}
		}).start();
		System.out.println("Test end!");

	}

	// 여기에 synchronized를 적용함으로써 해당 쓰레드에서 사용하는 변수를 다른 쓰레드에서 접근하지 못하도록 한다.
	public synchronized void callMe(String whoCallMe) {
		mMessage = whoCallMe;

		try {
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//만약 위의 synchronized 키워드를 뺸다면 아래 if문에서 false가 엄청 나올 것이다.
		if (!mMessage.equals(whoCallMe)) {
			System.out.println(whoCallMe + " | " + mMessage);
		}
	}
}