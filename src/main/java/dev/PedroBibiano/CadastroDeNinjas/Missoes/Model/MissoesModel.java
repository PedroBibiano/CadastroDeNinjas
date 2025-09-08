package dev.PedroBibiano.CadastroDeNinjas.Missoes.Model;

import dev.PedroBibiano.CadastroDeNinjas.Ninja.Model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor //Construtor vazio
@AllArgsConstructor //Construtor cheio
@Data //getters e setters
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //Uma missão pode possuir mais de 1 ninja;
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
