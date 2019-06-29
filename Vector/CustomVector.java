/**
 * Resizeable arrays implemented without pointers
 */
class CustomVector {

    private int capacity;
    private int[] array; 
    private int usage; 
    private static final int margin = 2; 
    private static final int defaultSize = 5; 

    //TODO: make this work for any data type using Java generics

    /**
     * Takes in a size as @param usrSize
     * Creates a private array with the size = first power of 2 greater than usrSize
     */
    public CustomVector(int usrSize){
        int power = (int)Math.ceil((double)Math.log(usrSize) / (double)Math.log(2));
        capacity = (int)Math.pow(2, power);
        array = new int[capacity];
    }

    /**
    * Fallback constructor in case no size is provided
    */
    public CustomVector(){
        capacity = margin * defaultSize; 
        array = new int[capacity]; 
    }

    public int size(){
        return usage; 
    }

    public int capacity() {
        return capacity; 
    }

    public boolean isEmpty() {
        if (usage > 0) {
            return false;
        } else {
            return true; 
        }
    }

    /**
    * Returns the element at @param index 
    * @throws IllegalArgumentException if @param index is out of bounds 
    */
    public int at(int index) {
        if (index < usage) {
            return array[index];
        } else {
            throw new IllegalArgumentException("Supplied index is out of bounds"); 
        }
    }

    /**
    * Inserts @param value at @param index and right-shifts all the elements to the right of @param index by one
    */

    public void insert(int index, int value){   
        if(index > usage) {
            throw new IllegalArgumentException("Supplied index is out of bounds");
        } else if(index == usage){
            push(value);
            return;
        }

        usage++; 
        autoResize();

        int[] newArray = new int[capacity];
        for(int i = 0; i < usage; i++){
            if (i < index) {
                newArray[i] = array[i];
            } else if (i == index) {
                newArray[i] = value;
            } else {
                newArray[i] = array[i - 1];
            }
        }
        array = newArray; 
    }

    /**
    * Deletes the value at @param index and left-shifts all the elements to the right of @param index by one
    */

    public void delete(int index) {
        if (index > usage) {
            throw new IllegalArgumentException("Supplied index is out of bounds");
        }
        if (index == usage - 1) {
            pop();
        }
        int[] newArray = new int[capacity];
        for(int i = 0; i < usage; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else if(i > index) {
                newArray[i - 1] = array[i];
            }
        }
        array = newArray; 
        usage--;
        autoResize();
    }

    /**
    * Removes all instances of @param value and does the necessary shifting
    */

    public void remove(int value) {
        int[] newArray = new int[capacity];
        int ctr = 0; 
        for(int i = 0; i < usage; i++) {
            if (array[i] == value){
                ctr++; 
            } else {
                newArray[i - ctr] = array[i];
            }
        }
        array = newArray; 
        usage-=ctr;
        autoResize();
    }

    /**
    * @return the index of the first instance of @param value 
    */
    public int find(int value) {
        for(int i = 0; i < usage; ++i) {
            if(array[i] == value) {
                return i; 
            }
        }
        return -1; 
    }

    public void prepend(int value) {
        insert(0, value);
    }

    /**
    * Updates the value at @param index to @param value
    */

    public void update(int index, int value) {
        if (index < usage) {
            array[index] = value;
        } else {
            throw new IllegalArgumentException("Supplied index is out of bounds");
        }
    }

    /**
    * Inserts @param value at the end of the array and resizes if needed 
    */
    public int push(int value) {
        array[usage] = value; 
        usage++; 
        autoResize();

        return usage-1; 
    }

    /**
    * @return the value removed from the end of the array 
    */
    public int pop() {
        int ret = array[--usage];
        autoResize();

        return ret; 
    }

    @Override
    public String toString() {
        String ret = new String();
        ret += "["; 
        for(int i = 0; i < usage - 1; i++){
            ret += array[i] + ", ";
        }
        ret += array[usage-1] + "]";

        return ret; 
    }

    /**
    * Creates a new array of size @param newSize and replaces the underlying array with it
    */
    private void resize(int newSize){
        int[] newArray = new int[newSize];

        for(int i = 0; i < usage; i++) {
            newArray[i] = array[i];
        }
        array = newArray; 
        capacity = newSize; 
    }

    /**
    * Determines if a resize is needed because of over-usage or under-usage of the array
    */
    private void autoResize() {
        if (usage <= capacity / 4) {
            resize(capacity / 2);
        } else if (usage >= capacity) {
            resize(capacity * margin);
        }
    }

}