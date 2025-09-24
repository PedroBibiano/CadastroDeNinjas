package dev.PedroBibiano.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository)
    {   this.ninjaRepository = ninjaRepository; }


    //Listar todos os ninjas
    public List<NinjaModel> ListarNinjas()
    {   return ninjaRepository.findAll();   }

    //Listar todos os ninjas por Id
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }
    //Criar ninja
    public NinjaModel criarNinja(NinjaModel ninja)
    {
        return ninjaRepository.save(ninja);
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
