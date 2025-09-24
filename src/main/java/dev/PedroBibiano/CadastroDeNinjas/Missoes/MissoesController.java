package dev.PedroBibiano.CadastroDeNinjas.Missoes;


import dev.PedroBibiano.CadastroDeNinjas.Ninja.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    private MissoesService missoesService;
    private MissoesMapper missoesMapper;

    public MissoesController(MissoesService missoesService, MissoesMapper missoesMapper) {
        this.missoesService = missoesService;
        this.missoesMapper = missoesMapper;
    }

    // Adicionar (CRETE)
    @PostMapping("/criar")
    public MissoesDTO criarMissoes(@RequestBody MissoesDTO missoes) {
        return missoesService.criarMissoes(missoes);
    }

    //Listar TODAS (READ)
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.ListarMissoes();
    }

    //Listar POR ID (READ)
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {
        return missoesService.listarMissoesPorId(id);
    }

    //Alterar dados (UPDATE)
    @PutMapping("/alterar/{id}")
    public MissoesModel atualizarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada) {
        return missoesService.atualizarMissao(id, missaoAtualizada);
    }

    //Deletar (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarMissoesPorId(@PathVariable Long id)
    {
        missoesService.deletarMissoesPorId(id);
    return deletarMissoesPorId(id);
    }

}
