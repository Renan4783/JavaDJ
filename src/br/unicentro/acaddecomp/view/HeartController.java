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
public class HeartController implements ControllerInterface {

    HeartModelInterface model;
    DJControlViewInterface view;

    public HeartController(HeartModelInterface model) {
        this.model = model;
        new BeatView(new HeartAdapter(model), this).setVisible(true);
        DJControl djControl = new DJControl(this, new HeartAdapter(model));
        djControl.setVisible(true);
        view = djControl;
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }

    @Override
    public void setBPM(int bpm) {
        
    }

    @Override
    public void increaseBPM() {
    }

    @Override
    public void decreaseBPM() {
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void quit() {
        System.exit(0);
    }
}
