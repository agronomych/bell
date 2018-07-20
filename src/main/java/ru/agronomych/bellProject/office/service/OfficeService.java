package ru.agronomych.bellProject.office.service;

import ru.agronomych.bellProject.office.view.OfficeView;

import java.util.List;

public interface OfficeService {
    List<OfficeView> offices();

    void saveOffice(OfficeView office);

    void updateOffice(OfficeView office);

    OfficeView loadById(int id);
}
