/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicentro.acaddecomp.view;

import java.util.*;

/**
 *
 * @author Renan
 */
public class HeartModel implements HeartModelInterface, Runnable {

    List<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
    List<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
    int time = 1000;
    int bpm = 90;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;

    public HeartModel() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        int lastrate = -1;
        for (;;) {
            int change = random.nextInt(10);
            if (random.nextInt(2) == 0) {
                change = 0 - change;
            }
            int rate = 60000 / (time + change);
            if (rate < 120 && rate > 50) {
                time += change;
                notifyBeatObservers();
                if (rate != lastrate) {
                    lastrate = rate;
                    notifyBPMObservers();
                }
            }
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        }
    }

    public int getHeartRate() {
        return 60000 / time;
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    private void notifyBeatObservers() {
        for (BeatObserver bo : beatObservers) {
            bo.updateBeat();
        }
    }

    @Override
    public void removeObserver(BeatObserver o) {
        beatObservers.remove(o);
    }

    @Override
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    private void notifyBPMObservers() {
        for (BPMObserver bo : bpmObservers) {
            bo.updateBPM();
        }
    }

    @Override
    public void removeObserver(BPMObserver o) {
        bpmObservers.remove(o);
    }
}
