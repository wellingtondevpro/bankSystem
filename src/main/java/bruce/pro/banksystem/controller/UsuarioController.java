package bruce.pro.banksystem.controller;

import bruce.pro.banksystem.domain.usuario.Usuario;
import bruce.pro.banksystem.domain.usuario.UsuarioDTO;
import bruce.pro.banksystem.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")

public class UsuarioController {


    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuario){
        Usuario NewUsuario = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(NewUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> BuscarTodosUsuarios(){
        var usuario = this.usuarioService.BuscarTodosUsuarios();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
