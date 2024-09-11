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


### Backend Projects: Payment Microservice, Webhooks & Crons [13-02-24]
1. Webhook : Host the app on Cloud Provider for Payment Gateway to reach it. <br>
(Localtunnel & Ngrok creates secure channel, exposing local server‘s IP to publicly reachable URL)
2. StripeWebhookController: PostMapping > RequestBody stripe.model.Event

For each Payment Gateway, we need separate Webhook API in PaymentService. <br>
Razorpay Dashboard: https://dashboard.razorpay.com/app/developers/webhooks <br>
Documentation: https://razorpay.com/docs/webhooks/ <br>
Stripe Events : https://docs.stripe.com/api/events/types <br>
Webhooks have re-try mechanism, Cloud Provider Services-very less downtime : https://uptime.is/ (99.999 availability)

References : <br>
https://www.javatpoint.com/what-is-cron-job <br>
https://www.baeldung.com/spring-scheduled-tasks

By default, Spring will use the server’s local time zone for the cron expression. However, we can use the **zone** 
attribute to change this timezone. Also, flexibility of **cron** expression controls the schedule of our tasks. <br>
@Scheduled(cron = "0 15 10 15 * ?", zone = "Europe/Paris") <br>
The **fixedDelay** property makes sure that there is a delay of n millisecond between the finish time 
of an execution of a task and the start time of the next execution of the task. The **fixedRate** property 
runs the scheduled task at every n millisecond. Executed the first time after the **initialDelay** value. <br>
@Scheduled(fixedDelay = 1000, initialDelay = 1000)