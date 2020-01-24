package fr.tboutale.api.services;

import fr.tboutale.api.dtos.CandidateDto;
import fr.tboutale.api.dtos.CandidateViewDto;
import fr.tboutale.api.entities.Candidate;
import fr.tboutale.api.repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepo;

    public CandidateServiceImpl(CandidateRepository candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    @Override
    public void create(CandidateDto dto) {
        Candidate candidate = new Candidate();
        populateAndSave(dto, candidate);
    }

    private void populateAndSave(CandidateDto dto, Candidate candidate) {
        candidate.setEmail(dto.getEmail());
        candidate.setPassword(dto.getPassword());
        candidateRepo.save(candidate);
    }

    @Override
    public void delete(Long id) {
        candidateRepo.deleteById(id);
    }

    @Override
    public CandidateViewDto getOne(Long id) {
        return candidateRepo.getById(id);
    }

    @Override
    public List<CandidateViewDto> getAll() {
        return candidateRepo.getAll();
    }

    @Override
    public void update(Long id, CandidateDto dto) {
        Candidate candidate = candidateRepo.findById(id).get();
        populateAndSave(dto, candidate);
    }
}
