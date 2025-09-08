package dev.PedroBibiano.CadastroDeNinjas.Missoes.Repository;

import dev.PedroBibiano.CadastroDeNinjas.Missoes.Model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {

}
