package com.advantech.springsecurity.mapper;

import com.advantech.springsecurity.dto.BookDTO;
import com.advantech.springsecurity.jpa.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {

  @Mappings({
      @Mapping(source = "bookid", target = "id"),
      @Mapping(source = "name", target = "name"),
      @Mapping(source = "author", target = "author")
  })
  BookDTO toDTO(Book entity);

  List<BookDTO> toDTO(List<Book> entities);

  Book toEntity(BookDTO dto);
}
