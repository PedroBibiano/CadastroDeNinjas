package dev.PedroBibiano.CadastroDeNinjas.Ninja;
//JPA java persistence API

import dev.PedroBibiano.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Construtores + getters e setters
@AllArgsConstructor //cosntrutor cheio
@NoArgsConstructor //construtor vazio
@Data //getters e setters
@Entity //transformando numa entidade
@Table(name = "tb_cadastro") // criando a tabela

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name ="id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column (name = "rank")
    private String rank;

    //Um Ninja tem 1 unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key - Chave Estrangeira
    private MissoesModel missoes;

}

