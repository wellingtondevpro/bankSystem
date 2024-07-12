package bruce.pro.banksystem.domain.transaction;


import bruce.pro.banksystem.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "payer_id")
    private Usuario payer;
    @ManyToOne
    @JoinColumn(name = "payee_id")
    private Usuario payee;
    private String description;
    private LocalDateTime transactionTime;

}
