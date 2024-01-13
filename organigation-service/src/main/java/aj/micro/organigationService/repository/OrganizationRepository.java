package aj.micro.organigationService.repository;

import aj.micro.organigationService.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization findByOrganizationCode(String organizationCode);
}
