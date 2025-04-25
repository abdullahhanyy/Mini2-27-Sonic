package com.example.miniapp.controllers;

import com.example.miniapp.models.Payment;
import com.example.miniapp.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // 9.4.2.1 Add Payment
    @PostMapping("/addPayment")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }

    // 9.4.2.2 Get All Payments
    @GetMapping("/allPayments")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // 9.4.2.3 Get Payment By ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // 9.4.2.4 Update Payment
    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    // 9.4.2.5 Delete Payment
    @DeleteMapping("/delete/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }

    // 9.4.2.6 Get Payments By Trip ID
    @GetMapping("/byTrip/{tripId}")
    public List<Payment> findPaymentsByTripId(@PathVariable Long tripId) {
        return paymentService.findPaymentsByTripId(tripId);
    }

    // 9.4.2.7 Get Payments Above Amount Threshold
    @GetMapping("/findByAmountThreshold")
    public List<Payment> findByAmountThreshold(@RequestParam Double threshold) {
        return paymentService.findByAmountThreshold(threshold);
    }
}
