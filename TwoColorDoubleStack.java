package cw;

public class TwoColorDoubleStack<T> {
    private int redTop; 
    private int blueTop; 
    private int capacity; // the size of the array
    private T[] arr; // the array that stores the elements of both stacks

    
    public TwoColorDoubleStack(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        redTop = -1;  // Setting no elements in the red stack
        blueTop = capacity; // Setting no elements in the blue stack
    }


    // Checking if the Red stack is empty
    public boolean isRedEmpty() {
    	return redTop == -1;
    }

    // Checking if the Blue stack is empty
    public boolean isBlueEmpty() {
        return blueTop == capacity;
    }


    // Checking if Red stack is full
    public boolean isRedFull() {
        return redTop == blueTop - 1;
    }


    // Checking if Blue stack is full
    public boolean isBlueFull() {
        return blueTop == redTop + 1;
    }


    // Pushing an element to the Red Stack
    public void redPush(T element) {
        if (isRedFull()) {
            throw new RuntimeException("Red stack is full");
        }
        arr[++redTop] = element;
    }


    // Pushing an element to the Blue Stack
    public void bluePush(T element) {
        if (isBlueFull()) {
            throw new RuntimeException("Blue stack is full");
        }
        arr[--blueTop] = element;
    }


    // Popping an element from the Red Stack
    public T redPop() {
        if (isRedEmpty()) {
            throw new RuntimeException("Red stack is empty");
        }
        return arr[redTop--];
    }


    // Popping an element from the Blue Stack
    public T bluePop() {
        if (isBlueEmpty()) {
            throw new RuntimeException("Blue stack is empty");
        }
        return arr[blueTop++];
    }


    // Getting the top element from the Red stack
    public T redTop() {
        if (isRedEmpty()) {
            throw new RuntimeException("Red stack is empty");
        }
        return arr[redTop];
    }


    // Getting the top element from the Blue stack
    public T blueTop() {
        if (isBlueEmpty()) {
            throw new RuntimeException("Blue stack is empty");
        }
        return arr[blueTop];
    }
    
    public static void main(String[] args) {
    	// Running the code
    	
        // Creating the stack
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
