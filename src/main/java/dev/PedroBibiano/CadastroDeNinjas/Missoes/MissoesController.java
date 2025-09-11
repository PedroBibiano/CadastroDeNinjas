package dev.PedroBibiano.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissoesController {
    //Adicionar Missão-(CRETE)
    @PostMapping("/missoes-criar")
    public String missoesCriar() {
        return "Missão Criada";
    }

    //Mostrar todas as Missões-(READ)
    @GetMapping("/missoes-todos")
    public String missoeTodos() {return "Mostrar missões"; }

    //Mostrar as Missões por ID-(READ)
    @GetMapping("/missoes-todo-id")
    public String mostrarMissoesPorId(){return "Mostrar missões por ID";}

    //Alterar dados das Missões-(UPDATE)
    @PutMapping("/missoes-alterar-id")
    public String missoesAlterarId(){return "Alterar ID";}

    //Deletar Missões-(DELETE)
    @DeleteMapping ("/missoes-deletar-id")
    public String missoesDeletarPorId(){return "missão deletada por ID";}
}
