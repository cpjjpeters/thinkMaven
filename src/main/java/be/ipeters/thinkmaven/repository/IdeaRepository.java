package be.ipeters.thinkmaven.repository;

import be.ipeters.thinkmaven.entity.IdeaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends JpaRepository<IdeaEntity, Long> {
}
