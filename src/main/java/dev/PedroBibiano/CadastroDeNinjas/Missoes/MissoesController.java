package dev.PedroBibiano.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    // Adicionar (CRETE)
    @PostMapping("/criar")
    public String criarMissao() {return "missao criada";}

    //MOSTRAR TODAS (READ)
    @GetMapping("/todos")
    public String mostrarTodosAsMissoes() {return "Mostrar Missoes";}

    //MOSTRAR POR ID (READ)
    @GetMapping("/todos-id")
    public String mostrarTodosAsMissoesPorID() {return "Mostrar missoes por ID";}

    //Alterar dados (UPDATE)
    @PutMapping("/alterar")
    public String AlterarMissoesPorId() {return "Mostrar missao por ID";}

    //Deletar (DELETE)
    @DeleteMapping("/deletar")
    public String deletarMissoesPorId() {return "missao deletada por ID";}
}
