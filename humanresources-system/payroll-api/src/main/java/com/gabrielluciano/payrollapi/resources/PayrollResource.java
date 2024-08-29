package com.gabrielluciano.payrollapi.resources;

import com.gabrielluciano.payrollapi.domain.Payroll;
import com.gabrielluciano.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Slf4j
public class PayrollResource {

    private final PayrollService service;
    private final Environment env;

    @PostMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        log.info("PAYROLL_SERVICE ::: Post request on " + env.getProperty("local.server.port") + " port");
        return ResponseEntity.ok(service.getPayment(workerId, payment));
    }
}
