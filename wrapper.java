
class Wrapper {
    public static void main(String[] args) {
        int a = 10;

        Integer obj = a;

        System.out.println("Primitive value: " + a);
        System.out.println("Wrapper object: " + obj);

        Integer num = 20;

        int b = num;

        System.out.println("Wrapper object: " + num);
        System.out.println("Primitive value: " + b);
    }
}
