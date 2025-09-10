package dev.PedroBibiano.CadastroDeNinjas.Missoes;

import dev.PedroBibiano.CadastroDeNinjas.Ninja.NinjaModel;
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
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;


    //Uma missão pode possuir mais de 1 ninja;
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;


}
