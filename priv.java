
class priv {

    private priv() {
        System.out.println("Private constructor called");
    }

    public static void createObject() {
        priv obj = new priv();
    }
}

class Main {
    public static void main(String[] args) {
        priv.createObject();
    }
}
