/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicentro.acaddecomp.view;

/**
 *
 * @author Renan
 */
public class BeatController implements ControllerInterface {

    BeatModelInterface model;
    DJControlViewInterface view;

    public BeatController(BeatModelInterface model) {
        this.model = model;
        new BeatView(model, this).setVisible(true);
        DJControl djControl = new DJControl(this, model);
        djControl.setVisible(true);
        view = djControl;
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.initialize();
    }

    @Override
    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }

    @Override
    public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);

    }

    @Override
    public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

    @Override
    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    @Override
    public void quit() {
        System.exit(0);
    }
}
