package br.com.fiap.irrigationapi.modules.areas.services;

import br.com.fiap.irrigationapi.exceptions.DatabaseException;
import br.com.fiap.irrigationapi.exceptions.NotFoundException;
import br.com.fiap.irrigationapi.modules.areas.dtos.CreateArea;
import br.com.fiap.irrigationapi.modules.areas.dtos.OutputArea;
import br.com.fiap.irrigationapi.modules.areas.dtos.UpdateArea;
import br.com.fiap.irrigationapi.modules.areas.models.Area;
import br.com.fiap.irrigationapi.modules.areas.repositories.AreaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public OutputArea create(CreateArea createArea){
        Area newArea = new Area();
        BeanUtils.copyProperties(createArea, newArea);
        newArea = areaRepository.save(newArea);
        return new OutputArea(newArea);
    }

    public OutputArea findById(Long id){
        return new OutputArea(areaRepository.findById(id).orElseThrow(() -> new NotFoundException("Area", id)));
    }

    public Page<OutputArea> findAll(Pageable pageable){
        return areaRepository.findAll(pageable).map(OutputArea::new);
    }

    public OutputArea update(UpdateArea updateArea){
        try {
            Area foundArea = areaRepository.getReferenceById(updateArea.id());
            BeanUtils.copyProperties(updateArea, foundArea);
            return new OutputArea(areaRepository.save(foundArea));
        }catch(EntityNotFoundException e){
            throw new NotFoundException("Area", updateArea.id());
        }
    }

    public void delete(Long id){
        try{
            if(!areaRepository.existsById(id)) throw new NotFoundException("Area", id);
            areaRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

}
