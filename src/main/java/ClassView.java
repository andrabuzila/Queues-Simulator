import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClassView extends JFrame {
    private JTextField m_fieldClients = new JTextField(10);
    private JTextField m_fieldQueues = new JTextField(10);
    private JTextField m_maxSimulation = new JTextField(10);
    private JTextField m_arrivalMin = new JTextField(10);
    private JTextField m_arrivalMax = new JTextField(10);
    private JTextField m_serviceMin = new JTextField(10);
    private JTextField m_serviceMax = new JTextField(10);
    JTextPane pane = new JTextPane();

    private JButton procesare= new JButton("Run");

    ClassView(){

        Font f = new Font("TimesRoman",Font.BOLD,15);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();

        JLabel label1 = new JLabel("Number of clients:");
        label1.setFont(f);
        panel1.add(label1);
        panel1.add(m_fieldClients);
        panel1.setLayout(new FlowLayout());

        JLabel label2 = new JLabel("Number of queues:");
        label2.setFont(f);
        panel2.add(label2);
        panel2.add(m_fieldQueues);
        panel2.setLayout(new FlowLayout());

        JLabel label3 = new JLabel("Simulation interval:");
        label3.setFont(f);
        panel3.add(label3);
        panel3.add(m_maxSimulation);
        panel3.setLayout(new FlowLayout());

        JLabel label4 = new JLabel("Minimum arrival time:");
        label4.setFont(f);
        panel4.add(label4);
        panel4.add(m_arrivalMin);
        panel4.setLayout(new FlowLayout());

        JLabel label5 = new JLabel("Maximum arrival time:");
        label5.setFont(f);
        panel5.add(label5);
        panel5.add(m_arrivalMax);
        panel5.setLayout(new FlowLayout());

        JLabel label6 = new JLabel("Minimum service time:");
        label6.setFont(f);
        panel6.add(label6);
        panel6.add(m_serviceMin);
        panel6.setLayout(new FlowLayout());

        JLabel label7 = new JLabel("Maximum service time:");
        label7.setFont(f);
        panel7.add(label7);
        panel7.add(m_serviceMax);
        panel7.setLayout(new FlowLayout());
        panel8.add(procesare);
        panel8.setLayout(new FlowLayout());
        panel9.add(pane);
        JPanel p = new JPanel();
        p.add(panel1);
        p.add(panel2);
        p.add(panel3);
        p.add(panel4);
        p.add(panel5);
        p.add(panel6);
        p.add(panel7);
        p.add(panel8);
        p.add(panel9);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        setTitle("Queues Simulator");
        setPreferredSize(new Dimension(500,600));
        this.setContentPane(p);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void addProcessingListener(ActionListener aal){
        procesare.addActionListener(aal);
    }
    void setPane(String s){
        pane.setText(s);
    }
    String getNbOfClients(){
        return m_fieldClients.getText();
    }
    String getNbOfQueues(){
        return m_fieldQueues.getText();
    }
    String getMaxSimulation(){
        return m_maxSimulation.getText();
    }
    String getMinArrival(){
        return m_arrivalMin.getText();
    }
    String getMaxArrival(){
        return m_arrivalMax.getText();
    }
    String getMinService(){
        return m_serviceMin.getText();
    }
    String getMaxService(){
        return m_serviceMax.getText();
    }}
