package dev.PedroBibiano.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map (NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setRank(ninjaDTO.getRank());
        return ninjaModel;
    }
    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaDTO.getNome());
        ninjaDTO.setEmail(ninjaDTO.getEmail());
        ninjaDTO.setIdade(ninjaDTO.getIdade());
        ninjaDTO.setImgUrl(ninjaDTO.getImgUrl());
        ninjaDTO.setMissoes(ninjaDTO.getMissoes());
        ninjaDTO.setRank(ninjaDTO.getRank());
        return ninjaDTO;
    }
}
