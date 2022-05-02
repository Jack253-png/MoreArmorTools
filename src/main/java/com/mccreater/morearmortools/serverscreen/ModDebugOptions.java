package com.mccreater.morearmortools.serverscreen;

import com.mccreater.morearmortools.config.ConfigWriter;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModDebugOptions
{
    JFrame frame;
    ConfigWriter configWriter;
    public void init()
    {
        configWriter = new ConfigWriter();
        frame=new JFrame("Mod Debug Options");
        frame.setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        JPanel panel=new JPanel();
        Font font = new Font("Consolas",Font.ITALIC,20);
        Font label_font = new Font("Consolas",Font.ITALIC,26);

        JLabel jLabel = new JLabel("Mod Debug Options");
        JButton jButton = new JButton("Done");
        jLabel.setFont(label_font);
        jButton.setFont(font);
        jButton.addActionListener(e -> {
            configWriter.writeConfig();
            frame.dispose();
        });
        JLabel debug_label = new JLabel("Debug");
        debug_label.setFont(font);
        JButton debug_button = new JButton(configWriter.nowConfig.debug ? "Enabled" : "Disabled");
        debug_button.addActionListener(e -> {
            configWriter.nowConfig.debug = !configWriter.nowConfig.debug;
            debug_button.setText(configWriter.nowConfig.debug ? "Enabled" : "Disabled");
        });
        JLabel fontsizelabel = new JLabel("Server Font Size");
        fontsizelabel.setFont(new Font("Consolas",Font.ITALIC,16));
        JButton fontsizebutton = new JButton(getText(configWriter.nowConfig.FontSize));
        fontsizebutton.addActionListener(e -> {
            configWriter.nowConfig.FontSize += 6;
            if (configWriter.nowConfig.FontSize > 26){
                configWriter.nowConfig.FontSize = 14;
            }
            fontsizebutton.setText(getText(configWriter.nowConfig.FontSize));
        });
        fontsizebutton.setFont(font);
        debug_button.setFont(font);
        JLabel fonttypelabel = new JLabel("Server Font Type");
        fonttypelabel.setFont(new Font("Consolas",Font.ITALIC,16));
        JButton fonttypebutton = new JButton(getFontType(configWriter.nowConfig.FontType));
        fonttypebutton.addActionListener(e -> {
            configWriter.nowConfig.FontType ++;
            if (configWriter.nowConfig.FontType > 2){
                configWriter.nowConfig.FontType = 0;
            }
            fonttypebutton.setText(getFontType(configWriter.nowConfig.FontType));
        });
        fonttypelabel.setFont(new Font("Consolas",Font.ITALIC,14));
        fonttypebutton.setFont(font);
        JLabel changelooklabel = new JLabel("Change Feel");
        changelooklabel.setFont(new Font("Consolas",Font.ITALIC,16));
        JButton changelookbutton = new JButton(configWriter.nowConfig.changeUiLookAndFeel ? "Enabled" : "Disabled");
        changelookbutton.setFont(font);
        changelookbutton.addActionListener(e -> {
            configWriter.nowConfig.changeUiLookAndFeel = !configWriter.nowConfig.changeUiLookAndFeel;
            changelookbutton.setText(configWriter.nowConfig.changeUiLookAndFeel ? "Enabled" : "Disabled");
        });
        panel.add(jLabel);
        panel.add(debug_label);
        panel.add(new JLabel("     "));
        panel.add(debug_button);
        panel.add(fontsizelabel);
        panel.add(new JLabel("     "));
        panel.add(fontsizebutton);
        panel.add(fonttypelabel);
        panel.add(new JLabel("     "));
        panel.add(fonttypebutton);
        panel.add(changelooklabel);
        panel.add(new JLabel("     "));
        panel.add(changelookbutton);
        panel.add(jButton);

        frame.add(panel);    //添加面板到容器
        frame.setBounds(300,200,300,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    public String getFontType(int fonttypes){
        if (fonttypes == 0){
            return "Plain";
        }
        else if (fonttypes == 1){
            return "Bold";
        }
        else if (fonttypes == 2){
            return "Italic";
        }
        else{
            configWriter.nowConfig.FontType = 0;
            configWriter.writeConfig();
            return "Plain";
        }
    }
    public String getText(int fontsizes){
        if (fontsizes == 14){
            return "Small";
        }
        else if (fontsizes == 20){
            return "Mid";
        }
        else if (fontsizes == 26){
            return "Large";
        }
        else{
            configWriter.nowConfig.FontSize = 14;
            configWriter.writeConfig();
            return "Small";
        }
    }
}
