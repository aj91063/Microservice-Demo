package aj.micro.organigationService.service.impl;

import aj.micro.organigationService.dto.OrganizationDto;
import aj.micro.organigationService.entity.Organization;
import aj.micro.organigationService.mapper.OrganizationMapper;
import aj.micro.organigationService.repository.OrganizationRepository;
import aj.micro.organigationService.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
       Organization organization= OrganizationMapper.mapToOrganization(organizationDto);
       Organization savedOrganization = organizationRepository.save(organization);
       OrganizationDto savedOrganizationDto = OrganizationMapper.mapToOrganizationDto(savedOrganization);
       return savedOrganizationDto;
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
       Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
       return  OrganizationMapper.mapToOrganizationDto(organization);
    }
}
