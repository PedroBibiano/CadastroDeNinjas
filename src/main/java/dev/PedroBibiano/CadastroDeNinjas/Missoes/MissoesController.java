package dev.PedroBibiano.CadastroDeNinjas.Missoes;


import dev.PedroBibiano.CadastroDeNinjas.Ninja.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Adicionar missão (CRETE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDTO missoes) {
        MissoesDTO novaMissao = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("nova Missao criada com sucesso!" + "\n" + novaMissao.getNome() + "(ID):" + novaMissao.getId());
    }

    //LISTAR TODAS AS MISSOES(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.ListarMissoes();
        return ResponseEntity.ok(missoes);
    }

    //Listar POR ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {

        MissoesDTO missao = missoesService.listarMissoesPorId(id);
            if (missao!= null) {
                return ResponseEntity.ok(missao +"\nMissao encontrada com sucesso!");
            } else {return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id:" +id+ "\n não encontrada!");
            }
    }

    //Alterar dados (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missao = missoesService.atualizarMissao(id, missaoAtualizada);
       if (missao!= null) {
           return ResponseEntity.ok(missao + "\n Missao Atualizada com sucesso!");
       } else{return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("missao nao encontrada!");}
    }

    //Deletar (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissoesPorId(@PathVariable Long id)
    {
    if (missoesService.listarMissoesPorId(id) != null)
    {
        missoesService.deletarMissoesPorId(id);
        return ResponseEntity.ok("ninja com o ID: " + id + "\nDeletado com sucesso!");
    } else {return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Missão com o id:" +id+ "\n não encontrada!");
    }
    }

}
