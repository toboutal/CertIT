package fr.tboutale.api.repositories;

import fr.tboutale.api.dtos.CandidateViewDto;
import fr.tboutale.api.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    CandidateViewDto getById(Long id);
    List<CandidateViewDto> getAll();
}
