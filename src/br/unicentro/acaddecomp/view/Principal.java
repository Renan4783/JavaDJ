/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicentro.acaddecomp.view;

import javax.swing.*;

/**
 *
 * @author Renan
 */
public class Principal {

    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        //HeartModelInterface model = new HeartModel();
        ControllerInterface controller = new BeatController(model);
        //ControllerInterface controller = new HeartController(model);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DJControl(controller, model);
                new BeatView(model, controller);
            }
         });
    }
}
