package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.domain.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class TitleMapper {
    public Title mapToTitle(final TitleDto TitleDto) {
        return new Title(
                TitleDto.getId(),
                TitleDto.getBookTitle(),
                TitleDto.getAuthor(),
                TitleDto.getPublicationYear());
    }

    public TitleDto mapToTitleDto(final Title Title) {
        return new TitleDto(
                Title.getId(),
                Title.getBookTitle(),
                Title.getAuthor(),
                Title.getPublicationYear());
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> TitleList) {
        return TitleList.stream()
                .map(t -> new TitleDto(t.getId(), t.getBookTitle(), t.getAuthor(), t.getPublicationYear()))
                .collect(Collectors.toList());
    }
}

