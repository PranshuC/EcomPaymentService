# ECommerce Project - Payment Service

### Backend Projects: Integration Payment Gateway - 2 [06-02-24]
1. Create the Project - boilerplate code
2. Create new DB ecom_payment(Postgres) & update datasource details
3. Razorpay account set-up : Key Id & Secret
4. RazorpayPaymentGateway, RazorpayConfig <br>
https://razorpay.com/docs/api/payments/capture

In Payment Gateway, we don't pass double/float due to Precision Error. <br>
Even though minimal, we can't afford such issues in Financial application <br>
Rs10.75 -> double amount = 10.75; (No)  -> Long amount = 1075L; (last 2digits decimal)

RazorpayPaymentGateway (reuse single RazorpayClient object)


### Backend Projects: Integrating No Sql Database: Mongo Db [08-02-24]
1. Stripe Payment Gateway Integration <br>
https://docs.stripe.com/api/payment-link/create <br>
https://docs.stripe.com/api/prices/create <br>
@Primary -> StripePaymentGateway, define the source bean for the interface
2. GlobalControllerAdvice -> Handling RazorpayException & StripeException
3. AfterCompletion REDIRECT URL, UI moves to this page after payment completion <br>
Dummy payment : https://docs.stripe.com/testing#international-cards
4. Webhook URL : Needs to be public for PaymentGateway to reach constantly. <br>
So, for testing the scenario locally : https://theboroer.github.io/localtunnel-www/ <br>
It provides a public URL for local server. Ex : https://moody-rooms-heal.loca.lt/sample/ <br>
(Tunnel Password : My Public IP)

Any 3rd party API functionality upgrade is always backward compatible. <br>
They can't change over-night, causing failure to existing businesses.
