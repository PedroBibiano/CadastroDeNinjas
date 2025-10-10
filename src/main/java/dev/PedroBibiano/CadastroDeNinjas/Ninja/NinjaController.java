package dev.PedroBibiano.CadastroDeNinjas.Ninja;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.spel.spi.EvaluationContextExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    private final NinjaService ninjaService;
    private  NinjaMapper ninjaMapper;

    public NinjaController(NinjaService ninjaService, NinjaMapper ninjaMapper) {
        this.ninjaService = ninjaService;
        this.ninjaMapper = ninjaMapper;
    }

    // Adicionar ninja (CRETE)
    @PostMapping("/criar")
    @Operation(summary = "Criar ninja",description = "Essa rota cria um ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criada com sucesso!" + "\n" +  novoNinja.getNome() + "(ID):" + novoNinja.getId());
    }

    //LISTAR TODOS OS NINJAS (READ)
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "essa rota lista todos os dados dos ninjas cadastrados")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.ListarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //LISTAR NINJA POR ID (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por id",description = "Essa rota lista um ninja pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok("\n ninja encontrado com sucesso!" + "\n" + ninja);

        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + "\n não encontrado");
        }
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por id",description = "Essa rota altera um ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro na alteração do ninja,ninja não encontrado")
    })
    public ResponseEntity<?> AlterarNinja(
            @Parameter(description = "usuario manda o id no caminho da requisiçao")
            @PathVariable Long id,
            @Parameter(description ="usuario manda os dados do ninja a ser atualizado no corpo da requisiçao" )
            @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja  + "\nninja atualizado com sucesso!");
        } else{return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("ninja nao encontrado!");}
    }

    //Deletar Ninja(DELETE)
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta ninja",description = "Essa rota deleta um ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
    })
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("ninja com o id: " + id + " \n deletado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + "\n não encontrado");
        }
    }

}
