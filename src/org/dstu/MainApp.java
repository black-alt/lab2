package org.dstu;

import org.dstu.components.GraphicsPanel;
import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(50, 0, 110, Color.CYAN));
        shapes.add(new Circle(150, 0, 110, Color.RED));
        shapes.add(new Circle(250, 0, 110, Color.BLACK));
        shapes.add(new Circle(350, 0, 110, Color.GREEN));
        shapes.add(new Circle(450, 0, 110, Color.BLUE));

        GraphicsPanel canvas = new GraphicsPanel(shapes);

        for (Shape s: shapes) {
            Thread t = new Thread(s.getAnimator(canvas));
            t.start();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(canvas);
        frame.setVisible(true);
    }
}
