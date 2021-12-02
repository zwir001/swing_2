package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {

     private int position;

    public Window( String title ) throws HeadlessException {

        super(title);
        this.position=0;
        build_UI();
    }
    private void build_UI(){
        setBounds(0,0,650,460 );
        Kanwa panel= new Kanwa();
        panel.setLayout(null);
        panel.setBounds(0, 0 , 650, 460 );
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn_running= new JButton("Run");

        btn_running.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    if( need_to_run(e.getX()) )
                    run_away(btn_running);
                    panel.requestFocus(true);
            }
        }
        );
        panel.add(btn_running);
        JButton reset=new JButton("Reset");
        reset.addActionListener(e -> setDefault(reset, btn_running, panel));
        panel.add(reset);
        setDefault(reset, btn_running, panel);
    }
    private void setDefault( JButton reset, JButton run, Kanwa panel)
    {
        panel.erase_drawing();
        panel.requestFocus(true);
        run.setBounds(300, 300, 100, 45);
        reset.setBounds(500, 300, 100,45);
    }

    private boolean need_to_run( int x){
        return x >= 20 && x < 100;
    }

    private void run_away(JButton run)
    {
        switch (this.position) {
            case 0 -> {
                run.setBounds(100, 199, 100, 45);
                this.position = 1;
            }
            case 1 -> {
                run.setBounds(50, 130, 100, 45);
                this.position = 2;
            }
            case 2 -> {
                run.setBounds(400, 80, 100, 45);
                this.position = 3;
            }
            case 3 -> {
                run.setBounds(200, 250, 100, 45);
                this.position = 0;
            }
            default -> run.setBounds(220, 220, 100, 45);
        }
    }
}