import java.util.ArrayList;

public class IntFIFO {
	public int max = 0;
	ArrayList<Integer> fifo = new ArrayList<>(max);
	
    class InvalidSizeException extends Exception {
    	private static final long serialVersionUID = 1L; 
    	InvalidSizeException(String x) {
    		super(x);
    	}
    }
    
    class MaxException extends Exception {
    	private static final long serialVersionUID = 1L;
    	MaxException(String x) {
    		super(x);
    	}
    }
    
    class NoSuchElementException extends Exception{
    	private static final long serialVersionUID = 1L;
    	NoSuchElementException(String x) {
    		super(x);
    	}
    }

    public IntFIFO(int n) throws InvalidSizeException {
    	this.max = n;
    	this.fifo = new ArrayList<>(n);
    	if (n <= 0) {
    		throw new InvalidSizeException("Input natural number.");
    	}
    }

    public void put(int x) throws MaxException {
    	if (this.fifo.size() == this.max) {
    		throw new MaxException("FIFO Max");
    	}
    	this.fifo.add(x);
    }

    public int get() throws NoSuchElementException {
    	int g = 0;
    	if (this.fifo.size() == 0) {
    		throw new NoSuchElementException("NoSuchElement");
    	}
    	g = this.fifo.get(0);
    	this.fifo.remove(0);
    	return g;
    }

    public int last( ) throws NoSuchElementException {
    	if (this.fifo.size() == 0) {
    		throw new NoSuchElementException("NoSuchElement");
    	}    	
    	return this.fifo.get(this.fifo.size() - 1);
    }

    public int first() throws NoSuchElementException {
    	if (this.fifo.size() == 0) {
    		throw new NoSuchElementException("NoSuchElement");
    	}
    	return this.fifo.get(0);
    }

    public int size() {
    	return this.fifo.size();
    }
}