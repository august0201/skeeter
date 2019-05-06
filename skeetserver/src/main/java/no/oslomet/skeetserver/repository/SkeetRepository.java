package no.oslomet.skeetserver.repository;

import no.oslomet.skeetserver.model.Skeet;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkeetRepository extends JpaRepository<Skeet, Long>, JpaSpecificationExecutor<Skeet> {
    List<Skeet> findSkeetsByUserId(Long UserId, Sort sort);
}
