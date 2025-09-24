package dev.PedroBibiano.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaModel> ListarNinjas()
    {   return ninjaRepository.findAll();   }

    //Listar todos os ninjas por Id
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }
    //Criar ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO)
    {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
       ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }
    //Deletar ninja(preciasa ser void por não retornar nada)
    public void deletarNinjaPorId(Long id){
       ninjaRepository.deleteById(id);
    }
    // Atualizar ninja
    public NinjaModel atualizarNinja(long id, NinjaModel ninjaAtualizado)
        {
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
        }
}
