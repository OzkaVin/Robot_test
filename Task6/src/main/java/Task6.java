public class Task6 {
    int firstNumber;
    int secondNumber;
    int thirdNumber;
    int fourthNumber;

    int firstPair;
    int secondPair;

    Task6(int first, int second, int third, int fourth){
        firstNumber = first;
        secondNumber = second;
        thirdNumber = third;
        fourthNumber = fourth;
    }

    int GetFirstPair(){
        return firstPair;
    }

    int GetSecondPair(){
        return secondPair;
    }

    void Sum(){
        firstPair = firstNumber + secondNumber;
        secondPair = thirdNumber + fourthNumber;
    }

    boolean Compare(){
        return (firstPair > secondPair);
    }

    void IncreaseFirstPair(){
        firstPair++;
    }

    void DecreaseSecondPair(){
        secondPair-=2;
    }

    boolean Comparison(){
        return ((firstPair%2==0) || (secondPair%2==0));
    }
}
