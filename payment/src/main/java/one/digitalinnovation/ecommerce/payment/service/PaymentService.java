package one.digitalinnovation.ecommerce.payment.service;

import one.digitalinnovation.ecommerce.checkout.event.CheckoutCreatedEvent;
import one.digitalinnovation.ecommerce.payment.entity.PaymentEntity;

import java.util.Optional;

public interface PaymentService {
    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}
