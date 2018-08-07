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
public interface ControllerInterface {

    public void setBPM(int bpm);

    public void increaseBPM();

    public void decreaseBPM();

    public void start();

    public void stop();

    public void quit();
}
