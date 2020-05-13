package br.com.codenation;
import br.com.codenation.paymentmethods.PriceStrategy;

public class BillingProcessor {

    public Double calculate(Order order) {
        PriceStrategy formaDePagamento = order.getPaymentMethod().getPaymentStrategy();
        return formaDePagamento.calculate(order.getPrice());
    }
}