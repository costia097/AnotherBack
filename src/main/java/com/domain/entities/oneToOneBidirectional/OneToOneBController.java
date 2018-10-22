package com.domain.entities.oneToOneBidirectional;

import com.domain.entities.oneToOneBidirectional.dto.CountryDto;
import com.domain.entities.oneToOneBidirectional.dto.LanguageDto;
import com.domain.entities.oneToOneBidirectional.entites.Country;
import com.domain.entities.oneToOneBidirectional.entites.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one/b")
public class OneToOneBController {
    @Autowired
    private OneToOneBRepository oneToOneBRepository;

    @PostMapping("/save")
    public void save() {
        Country country = new Country();
        country.setName("UK");

        Language language = new Language();
        language.setPopular(true);

        country.setLanguage(language);
        language.setCountry(country);

        oneToOneBRepository.save(country,language);
    }

    @GetMapping("/find/country/{id}")
    public ResponseModel findCountry(@PathVariable Long id) {
        Country country = oneToOneBRepository.findCountry(id);
        Language language = country.getLanguage();

        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());

        LanguageDto languageDto = new LanguageDto();
        languageDto.setId(language.getId());
        languageDto.setPopular(language.getPopular());

        ResponseModel responseModel = new ResponseModel();
        responseModel.setCountryDto(countryDto);
        responseModel.setLanguageDto(languageDto);

        return responseModel;
    }
}
