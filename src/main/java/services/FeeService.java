package services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.Fee;
import domain.Student;
import domain.types.PaymentStatus;
import persistence.FeeRepository;

public class FeeService {

    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public void generateFees(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
    
        List<Fee> fees = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Fee fee = new Fee();
            fee.setDueDate(LocalDate.now().plusMonths(i));
            fee.setStudent(student);
            fees.add(fee);
        }
    
        feeRepository.saveAll(fees);
    }

    public void updateStatus(Fee fee){
        fee.setPaymentStatus(PaymentStatus.OVERDUE);
    }

    public void verifyOverdueFees(){
        List<Fee> overdueFees = feeRepository.findOverdueFees(LocalDate.now());
        overdueFees.forEach(this::updateStatus);

        feeRepository.saveAll(overdueFees);
    }

    public BigDecimal getTotalFeesPrice(){
        return feeRepository.getAllFees().stream()
        .map(Fee::getPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    
    
    }

    public Long countByPaymentStatus(PaymentStatus status){
        return feeRepository.getAllFees().stream()
                .filter(fee -> fee.getPaymentStatus().equals(status))
                .count();
    }
    
    
}
