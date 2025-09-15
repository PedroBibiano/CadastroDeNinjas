package dev.PedroBibiano.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    MissoesService missoesService;
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar (CRETE)
    @PostMapping("/criar")
    public String criarMissao() {return "missao criada";}

    //Listar TODAS (READ)
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.ListarMissoes();
    }

    //Listar POR ID (READ)
    @GetMapping("/listar-id")
    public String listarMissoesPorId() {
        return "listar missoes por id";
    }

    //Alterar dados (UPDATE)
    @PutMapping("/alterar")
    public String AlterarMissoesPorId() {return "Mostrar missao por ID";}

    //Deletar (DELETE)
    @DeleteMapping("/deletar")
    public String deletarMissoesPorId() {return "missao deletada por ID";}
}
