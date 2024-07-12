package bruce.pro.banksystem.domain.usuario;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Generated;

import java.math.BigDecimal;

@Entity(name - "Usuario")
@Table(name = "Usuario")
@EqualsAndHashCode(of = "id")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private UserType userType;
    private BigDecimal balance;
}
