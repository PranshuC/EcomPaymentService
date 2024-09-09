# ECommerce Project - Payment Service

### Backend Projects: Integration Payment Gateway - 2 [06-02-24]
1. Create the Project - boilerplate code
2. Create new DB ecom_payment(Postgres) & update datasource details
3. Razorpay account set-up : Key Id & Secret
4. RazorpayPaymentGateway, RazorpayConfig

In Payment Gateway, we don't pass double/float due to Precision Error. <br>
Even though minimal, we can't afford such issues in Financial application <br>
Rs10.75 -> double amount = 10.75; (NO)  -> Long amount = 1075L; (last 2digits decimal)

RazorpayPaymentGateway (reuse single RazorpayClient object)