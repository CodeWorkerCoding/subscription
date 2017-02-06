package com.nchu.weixin.subscription.action;

import com.nchu.weixin.subscription.module.Lader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * mvc frame 案例
 * Created by fujianjian on 2017/1/24.
 */
public class MVCFrameDemo extends JFrame implements ActionListener {
    private Lader lader;
    private JTextField textAbove;
    private JTextField textBottom;
    private JTextField textHeight;
    private JTextArea showArea;
    private JButton controllButton;
    private JButton clearButton;

    public MVCFrameDemo() throws HeadlessException {
        lader = new Lader();
        textAbove = new JTextField(5);

        textBottom = new JTextField(5);
        textHeight = new JTextField(5);
        showArea = new JTextArea();
        controllButton = new JButton("计算面积");
        clearButton = new JButton("清楚计算历史");

        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("上底："));
        northPanel.add(textAbove);
        northPanel.add(new JLabel("下底："));
        northPanel.add(textBottom);
        northPanel.add(new JLabel("高："));
        northPanel.add(textHeight);
        northPanel.add(controllButton);
        northPanel.add(clearButton);

        controllButton.addActionListener(this);
        clearButton.addActionListener(this);
        this.setTitle("MVC JFrame 小样");
        this.add(northPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(showArea), BorderLayout.CENTER);
        this.setBounds(100, 100, 630, 560);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controllButton){
            try {
                Double above = Double.valueOf(textAbove.getText().trim());
                Double bottom = Double.valueOf(textBottom.getText().trim());
                Double height = Double.valueOf(textHeight.getText().trim());
                this.lader.setAbove(above);
                this.lader.setBottom(bottom);
                this.lader.setHeight(height);
                this.lader.calcArea();
                showArea.append(String.
                        format("上底：%s 下底：%s 高：%s 的梯形的面积为：%s \n",
                                above, bottom, height, lader.getArea()));
            } catch (Exception exception) {
                showArea.append("\n "+exception+"\n");
            }
        } else if (e.getSource() == clearButton){
            showArea.setText("");
        }


    }

    public static void main(String[] args) {
        new MVCFrameDemo();
    }
}
