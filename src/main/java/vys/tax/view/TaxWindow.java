package vys.tax.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import vys.tax.computation.COMPUTATION_CONTEXT;
import vys.tax.computation.CommandDispatcher;
import vys.tax.facade.TaxComputationFacade;
import vys.tax.model.TaxDTO;
import vys.tax.model.TaxParamVO;
import vys.tax.model.TaxableEntity;

import static java.lang.String.valueOf;
import static javax.swing.JOptionPane.showMessageDialog;

public class TaxWindow {

        private JFrame frame;
        private JTextField id;
        private JTextField name;
        private JTextField age;
        private JTextField sex;
        private JTextField location;
        private JTextField basic;
        private JTextField da;
        private JTextField hra;
        private JTextField allowance;
        private JTextField deductions;
        private JTextField surcharge;
        private JLabel idLabel;
        private JLabel nameLabel;
        private JLabel ageLabel;
        private JLabel sexLabel;
        private JLabel locationLabel;
        private JLabel basicLabel;
        private JLabel daLabel;
        private JLabel hraLabel;
        private JLabel allowanceLabel;
        private JLabel deductionsLabel;
        private JLabel surchargeLabel;
        private JLabel resultLabel;

        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        TaxWindow window = new TaxWindow();
                                        window.frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        public TaxWindow() {
                initialize();
        }

        private void initialize() {
                frame = new JFrame();
                frame.setBounds(100, 100, 730, 489);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);

                idLabel = new JLabel("Id : ");
                idLabel.setBounds(10, 10, 30, 20);
                frame.getContentPane().add(idLabel);
                id = new JTextField();
                id.setBounds(60, 10, 50, 20);
                frame.getContentPane().add(id);

                nameLabel = new JLabel("Name : ");
                nameLabel.setBounds(140, 10, 50, 20);
                frame.getContentPane().add(nameLabel);
                name = new JTextField();
                name.setBounds(210, 10, 100, 20);
                frame.getContentPane().add(name);

                ageLabel = new JLabel("Age : ");
                ageLabel.setBounds(350, 10, 40, 20);
                frame.getContentPane().add(ageLabel);
                age = new JTextField();
                age.setBounds(410, 10, 50, 20);
                frame.getContentPane().add(age);

                sexLabel = new JLabel("Sex : ");
                sexLabel.setBounds(10, 40, 40, 20);
                frame.getContentPane().add(sexLabel);
                sex = new JTextField();
                sex.setBounds(60, 40, 50, 20);
                frame.getContentPane().add(sex);

                locationLabel = new JLabel("Location : ");
                locationLabel.setBounds(140, 40, 70, 20);
                frame.getContentPane().add(locationLabel);
                location = new JTextField();
                location.setBounds(210, 40, 100, 20);
                frame.getContentPane().add(location);

                basicLabel = new JLabel("Basic : ");
                basicLabel.setBounds(10, 100, 50, 20);
                frame.getContentPane().add(basicLabel);
                basic = new JTextField();
                basic.setBounds(80, 100, 100, 20);
                frame.getContentPane().add(basic);

                daLabel = new JLabel("DA : ");
                daLabel.setBounds(200, 100, 50, 20);
                frame.getContentPane().add(daLabel);
                da = new JTextField();
                da.setBounds(280, 100, 100, 20);
                frame.getContentPane().add(da);

                hraLabel = new JLabel("HRA : ");
                hraLabel.setBounds(400, 100, 50, 20);
                frame.getContentPane().add(hraLabel);
                hra = new JTextField();
                hra.setBounds(480, 100, 100, 20);
                frame.getContentPane().add(hra);

                allowanceLabel = new JLabel("Allowance : ");
                allowanceLabel.setBounds(10, 140, 70, 20);
                frame.getContentPane().add(allowanceLabel);
                allowance = new JTextField();
                allowance.setBounds(80, 140, 100, 20);
                frame.getContentPane().add(allowance);

                deductionsLabel = new JLabel("Deduction : ");
                deductionsLabel.setBounds(200, 140, 70, 20);
                frame.getContentPane().add(deductionsLabel);
                deductions = new JTextField();
                deductions.setBounds(280, 140, 100, 20);
                frame.getContentPane().add(deductions);

                surchargeLabel = new JLabel("Surcharge : ");
                surchargeLabel.setBounds(400, 140, 70, 20);
                frame.getContentPane().add(surchargeLabel);
                surcharge = new JTextField();
                surcharge.setBounds(480, 140, 100, 20);
                frame.getContentPane().add(surcharge);

                JButton btnSubmit = new JButton("submit");

                btnSubmit.setBackground(Color.BLUE);
                btnSubmit.setForeground(Color.MAGENTA);
                btnSubmit.setBounds(65, 387, 89, 23);
                frame.getContentPane().add(btnSubmit);

                btnSubmit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                performComputation();
                                //
                        }
                });
        }

        public void performComputation() {
                TaxableEntity te = readValues();
                String message = "Please enter valid inputs";
                if(te != null) {
                        boolean result = TaxComputationFacade.compute(te);
                        if (result) {
                               message = "Tax Liability : " + te.taxParams.getTaxLiability();
                        }
                }
                showMessageDialog(null, message);
        }

        private TaxableEntity readValues() {
                TaxableEntity te = new TaxableEntity();
                te.setId(Integer.parseInt(id.getText()));
                te.setName(name.getText());
                te.setLocation(location.getText());
                te.setSex(sex.getText());
                te.setAge(Integer.parseInt(age.getText()));

                TaxParamVO taxParamVO = new TaxParamVO();
                taxParamVO.setAllowance(Double.valueOf(allowance.getText()));
                taxParamVO.setBasic(Double.valueOf(basic.getText()));
                taxParamVO.setDA(Double.valueOf(da.getText()));
                taxParamVO.setDeductions(Double.valueOf(deductions.getText()));
                taxParamVO.setHRA(Double.valueOf(hra.getText()));
                taxParamVO.setCess(Double.valueOf(surcharge.getText()));
                te.setTaxParams(taxParamVO);
                return te;
        }
}
