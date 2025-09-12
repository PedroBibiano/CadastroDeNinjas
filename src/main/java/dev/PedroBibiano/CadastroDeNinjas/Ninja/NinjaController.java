package dev.PedroBibiano.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Bem vindo a primeira rota, continue estudando";
    }

    // Adicionar ninja (CRETE)
    @PostMapping("/criar")
    public String criarNinja() {return "ninja criado";}

    //MOSTRAR TODOS OS NINJAS (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas() {return "Mostrar ninja(s)";}

    //MOSTRAR NINJA POR ID (READ)
    @GetMapping("/todos_id")
    public String mostrarTodosOsNinjasPorID() {return "Mostrar ninja por ID";}

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar_id")
    public String AlterarNinjaPorId() {return "Mostrar ninja por ID";}

    //Deletar Ninja(DELETE)
    @DeleteMapping("/deletar_id")
    public String deletarNinjaPorId() {return "Ninja deletado por ID";}
}
