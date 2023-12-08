package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_user')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(billService.getAllBills());
    }

    //da de alta la factura solo a los usuarios en el grupo providers
    @PostMapping
    @PreAuthorize("hasAnyAuthority('GROUP_providers')")
    public ResponseEntity<Bill> createNewBill(@RequestBody Bill bill) {
        return ResponseEntity.ok().body(billService.createNewBill(bill));
    }

    //busca la factura por el id del usuario
    @GetMapping("/userId={id}")
    public ResponseEntity<List<Bill>> getBillByUserId(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(billService.getBillsByUserId(id));
    }


}
