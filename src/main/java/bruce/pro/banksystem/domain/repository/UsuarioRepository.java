package bruce.pro.banksystem.domain.repository;

import bruce.pro.banksystem.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
