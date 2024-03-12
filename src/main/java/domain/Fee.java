package domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import domain.types.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_fees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @PrePersist
    public void prePersist() {
        this.price = BigDecimal.valueOf(125);
        this.paymentStatus = PaymentStatus.PENDING;
    }

}
