/*
 * The MIT License
 *
 * Copyright 2017 Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.isetjb;

import net.isetjb.config.I18N;
import java.awt.FlowLayout;
import java.util.Random;
import org.apache.log4j.Logger;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.isetjb.client.scalaberniClient;
import javax.swing.filechooser.*;
import java.io.*; 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * Frame1 class.
 *
 * @author Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn)
 */
public class Frame1 extends JInternalFrame
{
    final static Logger log = Logger.getLogger(Frame1.class);

    JButton jButton1 = new JButton(" Login >> ");
    JButton jButtonopen = new JButton(" Open ");
    JButton jButton1s = new JButton(" Login >> ");
    JButton jButtonopens = new JButton(" Open ");

  private JTextField idTextField = new JTextField(25);
  private JTextField passTextField = new JTextField(25);

    /**
     * Constructor.
     */
    public Frame1()
    {
        log.debug("START constructor...");

        setTitle(I18N.lang("frame1.title"));
        setLocation(new Random().nextInt(120) + 10, new Random().nextInt(120) + 10);
        setSize(800, 500);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(false);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(idTextField);
    buttonPanel.add(passTextField);
    buttonPanel.add(jButton1);
    buttonPanel.add(jButtonopen);
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(buttonPanel,BorderLayout.EAST);

    JPanel buttonPanelsecond = new JPanel();
    buttonPanelsecond.add(jButton1s);
    buttonPanelsecond.add(jButtonopens);
    getContentPane().add(buttonPanelsecond,BorderLayout.BEFORE_FIRST_LINE);


    jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                log.debug("ActionEvent on " + ev.getActionCommand());
		scalaberniClient scalaberniclient=new scalaberniClient();
		String id=(String)idTextField.getText();
		String password=(String)passTextField.getText();
		JSONObject obj = new JSONObject();
            	obj.put("userid",id);
            	obj.put("password",password );
            	obj.put("opp","login" );
		System.out.println("Frame 1 class  "+id+" ----- "+password);
		scalaberniclient.callServer(obj);
            }
        });
        jButtonopen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                 // create an object of JFileChooser class 
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
  
            // allow multiple file selection 
            j.setMultiSelectionEnabled(true); 
  
            // invoke the showsOpenDialog function to show the save dialog 
            int r = j.showOpenDialog(null); 
  
            if (r == JFileChooser.APPROVE_OPTION) { 
                // get the selelcted files 
                File files[] = j.getSelectedFiles(); 
  
                // set text to blank 
               // l.setText(""); 
  
                int t = 0; 
                // set the label to the path of the selected files 
                while (t++ < files.length) {
                    System.out.println( " " + files[t - 1].getName()); 
		}
            } 
            // if the user cancelled the operation 
            else{
               // l.setText("the user cancelled the operation");
		}
            }
        });

        //add compnent to the frame :
        //getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        //getContentPane().setLayout(new BorderLayout());
        //getContentPane().add(buttonPanel,BorderLayout.NORTH);

        setVisible(false);

        log.debug("End of constructor.");
    }
}
