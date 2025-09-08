package dev.PedroBibiano.CadastroDeNinjas.Ninja.Model;
//JPA java persistence API

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//Construtores + getters e setters

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cadastro")

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String idade;

}
