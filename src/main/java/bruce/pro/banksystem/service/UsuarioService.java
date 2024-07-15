package bruce.pro.banksystem.service;

import bruce.pro.banksystem.domain.repository.UsuarioRepository;
import bruce.pro.banksystem.domain.usuario.Usuario;
import bruce.pro.banksystem.domain.usuario.UsuarioDTO;
import org.springframework.stereotype.Service;

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
}
