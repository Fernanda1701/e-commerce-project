package one.digitalinnovation.ecommerce.payment.service;

import one.digitalinnovation.ecommerce.checkout.event.CheckoutCreatedEvent;
import one.digitalinnovation.ecommerce.payment.entity.PaymentEntity;
import one.digitalinnovation.ecommerce.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        final PaymentEntity paymentEntity = PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode())
                .code(UUID.randomUUID().toString())
                .build();
        paymentRepository.save(paymentEntity);
        return Optional.of(paymentEntity);
    }
}
