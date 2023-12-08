package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill createNewBill(Bill bill){
        try {
            return billRepository.save(bill);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Bill> getBillsByUserId(String id){
        return billRepository.getBillsByCustomerId(id);
    }

}
