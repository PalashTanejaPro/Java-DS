class TestVector {
    public static void main(String[] args) {
        CustomVector vec = new CustomVector(10);
        vec.push(1);
        vec.push(2);
        vec.push(3);
        vec.push(4);
        vec.push(5);
        vec.push(6);
        vec.push(1);
        vec.push(2);
        vec.push(3);
        vec.push(4);
        vec.push(5);
        vec.push(6);

        // for (int i = 0; i < 10; ++i) vec.pop();
        vec.find(4);
        System.out.println(vec.find(3));
    }
}