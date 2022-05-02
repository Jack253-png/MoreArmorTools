package com.mccreater.morearmortools.serverscreen;

import net.minecraft.text.TranslatableText;
import net.minecraft.util.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mccreater.morearmortools.serverscreen.ModDebugOptions;

public class GridLayoutDemo
{
    public void main()
    {
        JFrame frame=new JFrame("Mod Options");
        frame.setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        JPanel panel=new JPanel();
        GridLayout gridLayout = new GridLayout(5,5,10,10);

        Font font = new Font("Consolas",Font.ITALIC,20);

        ModDebugOptions m = new ModDebugOptions();

        JLabel jLabel = new JLabel("Mod Options");
        JButton jButton = new JButton("Mod Debug Options");
        jButton.addActionListener(e -> {
            m.init();
            m.frame.show();
        });
        JButton close = new JButton("Done");
        close.addActionListener(e -> {
            frame.dispose();
        });
        jLabel.setFont(new Font("Consolas",Font.ITALIC,26));
        jButton.setFont(font);
        close.setFont(font);

        panel.add(jLabel);

        panel.add(jButton);
        panel.add(close);


        frame.add(panel);    //添加面板到容器
        frame.setBounds(300,200,300,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}