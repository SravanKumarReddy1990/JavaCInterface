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
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import org.apache.log4j.Logger;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.isetjb.client.scalaberniClient;
/**
 * Frame1 class.
 *
 * @author Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn)
 */
public class Frame1 extends JInternalFrame
{
    final static Logger log = Logger.getLogger(Frame1.class);

    JButton jButton1 = new JButton(" Login >> ");
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
        setSize(700, 500);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(false);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(idTextField);
    buttonPanel.add(passTextField);
    buttonPanel.add(jButton1);
    jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                log.debug("ActionEvent on " + ev.getActionCommand());
		scalaberniClient scalaberniclient=new scalaberniClient();
		String id=(String)idTextField.getText();
		String password=(String)passTextField.getText();
		System.out.println("Frame 1 class  "+id+" ----- "+password);
		scalaberniclient.callServer(id,password);
            }
        });


        //add compnent to the frame :
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        //getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel,BorderLayout.NORTH);

        setVisible(false);

        log.debug("End of constructor.");
    }
}
