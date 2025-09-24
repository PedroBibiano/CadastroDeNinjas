package dev.PedroBibiano.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.PedroBibiano.CadastroDeNinjas.Ninja.NinjaModel;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor //Construtor vazio
@AllArgsConstructor //Construtor cheio
@Data //getters e setters
//DTO-copia da entidade do DB
public class MissoesDTO {
    private Long id;
    private String nome;
    private String dificuldade;


}
