import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Module {
    public static List<String> SUPPORTED_CURRENCIES = Arrays.asList("USD", "EUR", "JPY", "CHF");


    public String processPayment(int paymentAmount, String currency, String clientID)
            throws InvalidPaymentCurrencyException, InvalidPaymentAmountException, BankProcessingFailedException {

        if (!SUPPORTED_CURRENCIES.contains(currency)) {
            throw new InvalidPaymentCurrencyException(String.format("Currency %s not supported", currency));
        }

        if (paymentAmount <= 0) {
            throw new InvalidPaymentAmountException("Negative or zero payment amount");
        }

        return requestBankProcessing(paymentAmount);
    }

    public String requestBankProcessing(int paymentAmount) throws BankProcessingFailedException {
        // Some bank communication magic here
        Random random = new Random();
        int statusCode = random.nextInt(10);
        if (statusCode > 5) {
            throw new BankProcessingFailedException(String.format("Bank returned result code %s", statusCode));
        }
        return "trx_4knfsf4gs412355";
    }

    public static void main(String[] args) throws InvalidPaymentCurrencyException, BankProcessingFailedException, InvalidPaymentAmountException {
        Module newModule = new Module();
        try {
            System.out.println("Starting payment processing:");
            String result = newModule.processPayment(10, "USD", "FirstClient");
            System.out.printf("Transaction %s is successfull\n", result);
        } catch (InvalidPaymentAmountException | InvalidPaymentCurrencyException | BankProcessingFailedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unhandled exception occurred during operation performing");
        } finally {
            System.out.println("Payment processing is finished");
        }
    }

}

