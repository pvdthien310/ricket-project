package com.shipmentserivce.apiimpl.services.persistence;

import com.shipmentserivce.apiimpl.services.persistence.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
    Optional<Shipment> findByOrderId(String orderId);
}
