package cw;

public class TwoColorDoubleStack<T> {
    private int redTop; 
    private int blueTop; 
    private int capacity; 
    private T[] arr; 

    
    public TwoColorDoubleStack(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        redTop = -1; 
        blueTop = capacity; 
    }


    public boolean isRedEmpty() {
    	return redTop == -1;
    }


    public boolean isBlueEmpty() {
        return blueTop == capacity;
    }


    public boolean isRedFull() {
        return redTop == blueTop - 1;
    }


    public boolean isBlueFull() {
        return blueTop == redTop + 1;
    }


    public void redPush(T element) {
        if (isRedFull()) {
            throw new RuntimeException("Red stack is full");
        }
        arr[++redTop] = element;
    }


    public void bluePush(T element) {
        if (isBlueFull()) {
            throw new RuntimeException("Blue stack is full");
        }
        arr[--blueTop] = element;
    }


    public T redPop() {
        if (isRedEmpty()) {
            throw new RuntimeException("Red stack is empty");
        }
        return arr[redTop--];
    }


    public T bluePop() {
        if (isBlueEmpty()) {
            throw new RuntimeException("Blue stack is empty");
        }
        return arr[blueTop++];
    }


    public T redTop() {
        if (isRedEmpty()) {
            throw new RuntimeException("Red stack is empty");
        }
        return arr[redTop];
    }


    public T blueTop() {
        if (isBlueEmpty()) {
            throw new RuntimeException("Blue stack is empty");
        }
        return arr[blueTop];
    }
    
    public static void main(String[] args) {
    	
    	TwoColorDoubleStack<Integer> stack = new TwoColorDoubleStack<>(10);


    	stack.redPush(1);
    	stack.redPush(2);
    	stack.redPush(3);


    	stack.bluePush(4);
    	stack.bluePush(5);
    	stack.bluePush(6);


    	int redElement1 = stack.redPop(); 
    	int redElement2 = stack.redPop(); 


    	int blueElement1 = stack.bluePop(); 
    	int blueElement2 = stack.bluePop(); 


    	int redTop = stack.redTop(); 
    	int blueTop = stack.blueTop(); 

    	System.out.println(redElement1);
    	System.out.println(redElement2);
    	System.out.println(blueElement1);
    	System.out.println(blueElement2);
    	System.out.println(redTop);
    	System.out.println(blueTop);
    }

}
