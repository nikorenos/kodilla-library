package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.domain.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class TitleMapper {
    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getBookTitle(),
                titleDto.getAuthor(),
                titleDto.getPublicationYear());
    }

    public TitleDto mapToTitleDto(final Title title) {
        return new TitleDto(
                title.getBookTitle(),
                title.getAuthor(),
                title.getPublicationYear());
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> TitleList) {
        return TitleList.stream()
                .map(t -> new TitleDto(t.getBookTitle(), t.getAuthor(), t.getPublicationYear()))
                .collect(Collectors.toList());
    }
}

