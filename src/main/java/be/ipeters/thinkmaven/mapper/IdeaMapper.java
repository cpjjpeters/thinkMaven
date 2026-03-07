package be.ipeters.thinkmaven.mapper;

import be.ipeters.thinkmaven.entity.IdeaEntity;
import be.ipeters.thinkmaven.model.IdeaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IdeaMapper {
    IdeaDto toDto(IdeaEntity entity);
    IdeaEntity toEntity(IdeaDto dto);
}
