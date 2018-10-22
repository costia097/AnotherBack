package com.domain.entities.oneToOneBidirectional;

import com.domain.entities.oneToOneBidirectional.dto.CountryDto;
import com.domain.entities.oneToOneBidirectional.dto.LanguageDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class ResponseModel {
    private CountryDto countryDto;
    private LanguageDto languageDto;
}
