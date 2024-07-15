package bruce.pro.banksystem.service;

import bruce.pro.banksystem.domain.repository.UsuarioRepository;
import bruce.pro.banksystem.domain.transaction.Transaction;
import bruce.pro.banksystem.domain.transaction.TransactionDTO;
import bruce.pro.banksystem.domain.usuario.UserType;
import bruce.pro.banksystem.domain.usuario.Usuario;
import bruce.pro.banksystem.domain.usuario.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service

public class UsuarioService {


    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    ///
    private void saveUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }
    ///Método publico para criar um usuário apartir de um DTO
    public Usuario createUsuario(UsuarioDTO usuario) {///Recebe um usuario DTo
        Usuario NewUsuario = new Usuario(usuario);
        this.saveUsuario(NewUsuario);
        return NewUsuario;
    }

    public List<Usuario> BuscarTodosUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Usuario BuscarUsuarioId(Long id) throws Exception {
        return this.usuarioRepository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public boolean validactionUsuario(Usuario payer, BigDecimal amount) throws Exception {
        if(payer.getUserType() == UserType.MERCHANT){
            throw new Exception("Lojista não pode realizar transferencia");
        }
        if(payer.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
        return true;
    }
    public Usuario atualizarUsuario(Usuario usuario) throws Exception {
        return this.usuarioRepository.save(usuario);
    }
}
