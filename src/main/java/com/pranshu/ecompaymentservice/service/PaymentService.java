package com.pranshu.ecompaymentservice.service;

import com.pranshu.ecompaymentservice.paymentgateway.PaymentGateway;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long orderId, Long amount, String phoneNumber) throws RazorpayException, StripeException {
        //Order order = OrderService.getOrderDetails(orderId);
        // We need to call the payment gateway to generate the payment link.
        return paymentGateway.generatePaymentLink(orderId, amount, phoneNumber);
    }
}
