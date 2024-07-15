package bruce.pro.banksystem.domain.transaction;

import java.math.BigDecimal;

public record TransactionDTO(

        BigDecimal amount,
        Long payerId,
        Long payeeId
) {
}
