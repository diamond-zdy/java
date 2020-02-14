package com.bitedu.gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TreeTableView;

public class OSmonitorController {
    private LineChart cpuChart;
    private TreeTableView fileStat;

    public void handleCPUSelectionChanged(Event event) {
        System.out.println("hello" );
    }

    public void handleSelectFile(ActionEvent actionEvent) {
        System.out.println("hehe");
    }
}
