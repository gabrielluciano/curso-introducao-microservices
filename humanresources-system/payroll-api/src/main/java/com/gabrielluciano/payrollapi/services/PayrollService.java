package com.gabrielluciano.payrollapi.services;

import com.gabrielluciano.payrollapi.domain.Payroll;
import com.gabrielluciano.payrollapi.domain.User;
import com.gabrielluciano.payrollapi.feign_clients.UserFeign;
import com.gabrielluciano.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayrollService {

    private final UserFeign userFeign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        try {
            User worker = userFeign.findById(workerId).getBody();
            if (worker != null) {
                return Payroll.builder()
                        .workerName(worker.getName())
                        .description(payroll.getDescription())
                        .hourlyPrice(worker.getHourlyPrice())
                        .workedHours(payroll.getWorkedHours())
                        .totalPayment(payroll.getWorkedHours() * worker.getHourlyPrice())
                        .build();
            }
        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}
