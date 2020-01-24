package fr.tboutale.api.services;

import fr.tboutale.api.dtos.CandidateDto;
import fr.tboutale.api.dtos.CandidateViewDto;

import java.util.List;

public interface CandidateService {
    void create(CandidateDto dto);
    void delete(Long id);
    CandidateViewDto getOne(Long id);
    List<CandidateViewDto> getAll();
    void update(Long id, CandidateDto dto);
}
