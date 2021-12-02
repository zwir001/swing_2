package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Kanwa extends JPanel implements MouseInputListener {

    private int x=0;
    private int y=0;
    private int draw=2;

    public Kanwa(){
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar()=='k'){
                    draw=0;
                }
                if(e.getKeyChar()=='o'){
                    draw=1;
                }
            }
        });
        addMouseListener( this);
    }
    public void paint( Graphics g ){
        super.paint(g);
        if(draw==0){
            g.fillRect(x,y, 30, 30);
        }
        if(draw==1){
            g.fillOval(x,y, 30, 30);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.x=e.getX();
        this.y=e.getY();
        repaint();
    }

    public void erase_drawing(){
        draw=2;
        repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
