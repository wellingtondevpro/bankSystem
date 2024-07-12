package bruce.pro.banksystem.domain.usuario;


import java.math.BigDecimal;

public record UsuarioDTO(

        String name,
        String document,
        String email,
        String password,
        BigDecimal balance,
        UserType userType
) {

}
