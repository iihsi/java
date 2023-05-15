public class Enshuu5 {
	public static void main(String[] args) throws Exception{
		IntFIFO fifo = new IntFIFO(10);

		for(int i = 0; i < 10; i++){
			fifo.put(2*i);
			System.out.println("Put: " + 2*i);
		}

		System.out.println("First: " + fifo.first());
		System.out.println("Last: " + fifo.last());
		System.out.println("Size: " + fifo.size());
		System.out.println("Get: " + fifo.get());
		System.out.println("Size: " + fifo.size());
		System.out.println("First: " + fifo.first());
		System.out.println("Last: " + fifo.last());
		System.out.println("Get: " + fifo.get());
		System.out.println("Get: " + fifo.get());
		System.out.println("Get: " + fifo.get());
		System.out.println("Get: " + fifo.get());
		System.out.println("Get: " + fifo.get());
		System.out.println("Get: " + fifo.get());
		System.out.println("First: " + fifo.first());
		System.out.println("Last: " + fifo.last());
		System.out.println("Size: " + fifo.size());
	}
}
