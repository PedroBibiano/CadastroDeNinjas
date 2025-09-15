package dev.PedroBibiano.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja (CRETE)
    @PostMapping("/criar")
    public String criarNinja() {return "ninja criado";}

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Bem vindo a primeira rota, continue estudando";
    }

    //Listar TODOS OS NINJAS (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
    return ninjaService.ListarNinjas();
    }

    //Listar NINJA POR ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorID(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar_id")
    public String AlterarNinjaPorId() {return "Mostrar ninja por ID";}

    //Deletar Ninja(DELETE)
    @DeleteMapping("/deletar_id")
    public String deletarNinjaPorId() {return "Ninja deletado por ID";}
}
