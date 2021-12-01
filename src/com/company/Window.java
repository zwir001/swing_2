package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {

    public Window( String title ) throws HeadlessException {
        super(title);
        build_UI();
    }
    private void build_UI(){
        setBounds(0,0,650,460 );
        JPanel panel= new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0 , 650, 460 );
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn_running= new JButton("Run");


        btn_running.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                  run_away(btn_running);
            }
        }

        );
        panel.add(btn_running);
        JButton reset=new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefault(reset, btn_running, panel);
            }
        });
        panel.add(reset);
        setDefault(reset, btn_running, panel);
    }
    private void setDefault( JButton reset, JButton run, JPanel panel)
    {
        run.setBounds(220, 220, 100, 45);
        reset.setBounds(500, 300, 100,45);
    }
    private void run_away(JButton run)
    {
        run.setBounds(100, 199, 100, 45);
    }
}