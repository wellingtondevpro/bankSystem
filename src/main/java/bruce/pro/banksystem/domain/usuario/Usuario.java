package bruce.pro.banksystem.domain.usuario;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "Usuario")
@Table(name = "Usuario")
@Getter
@Setter

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

    public Usuario(){
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.balance = balance;
    }


    public Usuario(UsuarioDTO dto){

    this.name = dto.name();
    this.document = dto.document();
    this.email = dto.email();
    this.password = dto.password();
    this.userType = dto.userType();
    this.balance = dto.balance();
}

}
