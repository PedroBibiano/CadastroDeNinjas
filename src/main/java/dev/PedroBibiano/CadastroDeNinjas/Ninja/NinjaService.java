package dev.PedroBibiano.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> ListarNinjas()
    {
    return ninjaRepository.findAll();
    }
}
