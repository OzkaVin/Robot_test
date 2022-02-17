public class Numbers {
    public static void main(String[] args) {
        Task6 task = new Task6(2, 3, 2, 5);

        task.Sum();
        System.out.format("Result of comparing %d and %d -> %b\n", task.GetFirstPair(), task.GetSecondPair(), task.Compare());

        task.IncreaseFirstPair();
        task.DecreaseSecondPair();
        System.out.format("Result of comparing %d and %d -> %b\n", task.GetFirstPair(), task.GetSecondPair(), task.Compare());

        System.out.format("Second comparison result (%d and %d) : %b", task.GetFirstPair(), task.GetSecondPair(), task.Comparison());

    }
}
