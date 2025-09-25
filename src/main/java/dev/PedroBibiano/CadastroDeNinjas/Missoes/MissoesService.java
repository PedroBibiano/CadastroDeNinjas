package dev.PedroBibiano.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {


    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //listar
    public List<MissoesDTO> ListarMissoes()
    {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }
    //listar por id
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
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
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missaoDTO){
   Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
    if (missaoExistente.isPresent()) {
        MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
        missaoAtualizada.setId(id);
        MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
        return missoesMapper.map(missaoSalva);
    }
    return null;
    }


}