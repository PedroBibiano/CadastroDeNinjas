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
    //Criar missão
    public MissoesModel criarMissoes(MissoesModel missoes)
    {
        return missoesRepository.save(missoes);
    }

    //Deletar missão(preciasa ser void por não retornar nada)
    public void deletarMissoesPorId(Long id)
    {
        missoesRepository.deleteById(id);
    }

    //  ATUALIZAR missao
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada){
    if (missoesRepository.existsById(id)) {
        missaoAtualizada.setId(id);
        return missoesRepository.save(missaoAtualizada);
        }
    return null;
    }


}