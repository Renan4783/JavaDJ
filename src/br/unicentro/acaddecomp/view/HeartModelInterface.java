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
public interface HeartModelInterface {

    int getHeartRate();

    void registerObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BeatObserver o);

    void removeObserver(BPMObserver o);

}
