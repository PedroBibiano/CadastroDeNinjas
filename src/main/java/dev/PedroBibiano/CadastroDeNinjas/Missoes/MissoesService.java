package dev.PedroBibiano.CadastroDeNinjas.Missoes;

import dev.PedroBibiano.CadastroDeNinjas.Ninja.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository)
    {
        this.missoesRepository = missoesRepository;
    }


    //listar
    public List<MissoesModel> ListarMissoes()
    {
      return   missoesRepository.findAll();
    }


}