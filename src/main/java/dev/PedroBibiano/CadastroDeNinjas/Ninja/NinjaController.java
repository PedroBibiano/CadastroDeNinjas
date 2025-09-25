package dev.PedroBibiano.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    private NinjaService ninjaService;
    private  NinjaMapper ninjaMapper;

    public NinjaController(NinjaService ninjaService, NinjaMapper ninjaMapper) {
        this.ninjaService = ninjaService;
        this.ninjaMapper = ninjaMapper;
    }

    // Adicionar ninja (CRETE)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Bem vindo a primeira rota, continue estudando";
    }

    //Listar TODOS OS NINJAS (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.ListarNinjas();
    }

    //Listar NINJA POR ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorID(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO AlterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return  ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja(DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return deletarNinjaPorId(id);
    }

}
