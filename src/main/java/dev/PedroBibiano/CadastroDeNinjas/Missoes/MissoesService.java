package dev.PedroBibiano.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {


    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository)
    {   this.missoesRepository = missoesRepository;     }

    //listar
    public List<MissoesModel> ListarMissoes()
    {
      return   missoesRepository.findAll();
    }
    //listar por id
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }

}