package dev.PedroBibiano.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {


    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

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
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO)
    {
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
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