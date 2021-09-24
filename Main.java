public class Main {
	public static void main(String[] args) {
		MinhaThread mT1 = new MinhaThread(1, 99);
		MinhaThread mT2 = new MinhaThread(2, 99);
		MinhaThread mT3 = new MinhaThread(3, 99);

		mT1.setPriority(Thread.MIN_PRIORITY);
		mT2.setPriority(Thread.MIN_PRIORITY);
		mT3.setPriority(Thread.MAX_PRIORITY);
		
		mT1.start();
		mT2.start();
		mT3.start();
		
		for(int i = 0; i < 99; i++) {
			int a = i + 1;
		}
		System.out.println("\nMain");
	}
}

class MinhaThread extends Thread {
	int id = 0, limite = 0;
	static volatile int x;

	MinhaThread(int novoId, int novoLimite) {
		this.id = novoId;
		this.limite = novoLimite;
	}

	public void run() {
		for(int i = 0; i < limite; i++) {
			x = id;
			int a = id + i;
			System.out.print(".");
			System.out.print("\nT: " + id + " L: " + x);
		}
		System.out.println("\nTerminou thread " + id);
	}
}