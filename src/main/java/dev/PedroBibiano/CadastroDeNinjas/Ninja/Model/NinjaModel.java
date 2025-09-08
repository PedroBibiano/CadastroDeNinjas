package dev.PedroBibiano.CadastroDeNinjas.Ninja.Model;
//JPA java persistence API

import dev.PedroBibiano.CadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

//Construtores + getters e setters
@AllArgsConstructor
@NoArgsConstructor
@Entity //transformando numa entidade
@Table(name = "tb_cadastro") // criando a tabela

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    //Um Ninja tem 1 unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key - Chave Estrangeira
    private MissoesModel missoes;



}

