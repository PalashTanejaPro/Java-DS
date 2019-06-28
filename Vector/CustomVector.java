class CustomVector {

    private int capacity;
    private int[] array; 
    private int usage; 
    private static final int margin = 2; 
    private static final int defaultSize = 5; 

    //TODO: function that checks and resizes if needed
    
    public CustomVector(int usrSize){
        int power = (int)Math.ceil((double)Math.log(usrSize) / (double)Math.log(2));
        capacity = (int)Math.pow(2, power);
        array = new int[capacity];
    }

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

    public int at(int index) {
        if (index < usage) {
            return array[index];
        } else {
            throw new IllegalArgumentException("Supplied index is out of bounds"); 
        }
    }

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

    public void update(int index, int value) {
        if (index < usage) {
            array[index] = value;
        } else {
            throw new IllegalArgumentException("Supplied index is out of bounds");
        }
    }

    public int push(int val) {
        array[usage] = val; 
        usage++; 
        autoResize();

        return usage-1; 
    }

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

    private void resize(int newSize){
        int[] newArray = new int[newSize];

        for(int i = 0; i < usage; i++) {
            newArray[i] = array[i];
        }
        array = newArray; 
        capacity = newSize; 
    }

    private void autoResize() {
        if (usage <= capacity / 4) {
            resize(capacity / 2);
        } else if (usage >= capacity) {
            resize(capacity * margin);
        }
    }

}