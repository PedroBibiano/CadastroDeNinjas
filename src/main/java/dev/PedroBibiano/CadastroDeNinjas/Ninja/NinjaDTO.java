package dev.PedroBibiano.CadastroDeNinjas.Ninja;

//DTO-copia da entidade do DB sem conexão com o DB;

import dev.PedroBibiano.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Construtores + getters e setters
@AllArgsConstructor //cosntrutor cheio
@NoArgsConstructor //construtor vazio
@Data //getters e setters

public class NinjaDTO {


    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String imgUrl;
    private MissoesModel missoes;
    private String Rank;

}
