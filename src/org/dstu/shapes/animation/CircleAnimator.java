package org.dstu.shapes.animation;

import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CircleAnimator extends Animator {

    public CircleAnimator(Circle shape, JComponent component) {
        super(shape, component);
    }

    public void trySwitchColor() {
        if ((shape.getX() >= (component.getSize().width - shape.getRadius()) && shape.getY() == 0) ||
                shape.getX() >= (component.getSize().width - shape.getRadius()) && shape.getY() >= (component.getSize().height - shape.getRadius()) ||
                ((shape.getX() <= 0) && shape.getY() >= (component.getSize().height - shape.getRadius())) ||
                shape.getX() <= 0 && shape.getY() <= 0) {
            Random rand = new Random();
            shape.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        }
    }

    @Override
    public void run() {
        while (true) {
            if (shape.getX() < (component.getSize().width - shape.getRadius()) && shape.getY() <= 0) {
                shape.moveTo(shape.getX() + (int) (Math.random() * 10), 0);
                trySwitchColor();
            }
            else if (shape.getX() >= component.getSize().width - shape.getRadius() && shape.getY() < component.getSize().height - shape.getRadius()) {
                    shape.moveTo(shape.getX(), shape.getY() + (int) (Math.random() * 10));
                trySwitchColor();
                }
            else if (shape.getX() > 0 && shape.getY() >= (component.getSize().height - shape.getRadius())) {
                shape.moveTo(shape.getX() - (int) (Math.random() * 10), shape.getY());
                trySwitchColor();
            } else if (shape.getX() <= 0 && shape.getY() > 0) {
                shape.moveTo(shape.getX(), shape.getY() - (int) (Math.random() * 10));
                trySwitchColor();
            }
            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
