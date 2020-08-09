package com.haulmont.testtask;

import com.haulmont.testtask.entities.Patient;
import com.vaadin.annotations.Theme;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

import static com.haulmont.testtask.data.PatientData.getAllPatietns;

@Theme(ValoTheme.THEME_NAME)
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();

        List<Patient> patientList = getAllPatietns();

        Grid<Patient> grid = new Grid<>();
        grid.setItems(patientList);
        grid.setHeightByRows(true);

        Grid.Column<Patient> name = grid.addColumn(Patient::getName).setHeader("Имя");


        layout.setSizeFull();
        layout.setMargin(true);

        layout.addComponent(new Label("Main UI"));

        setContent(layout);
    }
}