package com.neweducation.application.external;

/**
 * Created by Maciej Wolański
 * maciekwski@gmail.com
 * on 05.02.2017.
 */
public class MockStudyDescriptionProviderService implements IStudyDescriptionProviderService {
    @Override
    public String getStudyDescription(long id) {
        return "http://www.wiz.pwr.wroc.pl/files/prv/id0/Informator/informator%20w-8_29.06.2015.pdf";
    }
}
