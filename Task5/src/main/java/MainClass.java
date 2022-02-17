public class MainClass {
    public static void main(String[] args) {
        OtherClass classInstance = new OtherClass();

        int value = classInstance.printReturnNumber();
        System.out.println(String.format("~~~%d~~~",value));
    }
}
