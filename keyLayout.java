import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class keyLayout extends JFrame implements ActionListener {

    private JTextField kotakTeks;
    private JButton[] tombolAngka;
    private JButton[] tombolOperator;
    private JButton tombolMod;
    private JButton tombolKeluar;

    public keyLayout() {
        super("Keyboard Layout");

        // Membuat kotak teks
        kotakTeks = new JTextField();
        kotakTeks.setPreferredSize(new Dimension(300, 50));

        // Membuat tombol angka
        tombolAngka = new JButton[10];
        for (int i = 0; i < tombolAngka.length; i++) {
            tombolAngka[i] = new JButton(String.valueOf(i + 1));
            tombolAngka[i].addActionListener(this);
        }

        // Membuat tombol operator
        tombolOperator = new JButton[] {
            new JButton("+"),
            new JButton("="),
            new JButton("-"),
            new JButton("*"),
            new JButton("/")
        };
        for (JButton tombol : tombolOperator) {
            tombol.addActionListener(this);
        }

        // Membuat tombol mod
        tombolMod = new JButton("Mod");
        tombolMod.addActionListener(this);

        // Membuat tombol keluar
        tombolKeluar = new JButton("Exit");
        tombolKeluar.addActionListener(this);

        // Membuat panel untuk kotak teks
        JPanel panelKotakTeks = new JPanel();
        panelKotakTeks.add(kotakTeks);

        // Membuat panel untuk tombol angka
        JPanel panelTombolAngka = new JPanel();
        panelTombolAngka.setLayout(new GridLayout(3, 4));
        for (JButton tombol : tombolAngka) {
            panelTombolAngka.add(tombol);
        }

        // Membuat panel untuk tombol operator
        JPanel panelTombolOperator = new JPanel();
        panelTombolOperator.setLayout(new FlowLayout());
        for (JButton tombol : tombolOperator) {
            panelTombolOperator.add(tombol);
        }

        // Membuat panel untuk tombol mod dan keluar
        JPanel panelModKeluar = new JPanel();
        panelModKeluar.setLayout(new FlowLayout());
        panelModKeluar.add(tombolMod);
        panelModKeluar.add(tombolKeluar);

        // Membuat panel utama
        JPanel panelUtama = new JPanel();
        panelUtama.setLayout(new BorderLayout());
        panelUtama.add(panelKotakTeks, BorderLayout.NORTH);
        panelUtama.add(panelTombolAngka, BorderLayout.CENTER);
        panelUtama.add(panelTombolOperator, BorderLayout.SOUTH);
        panelUtama.add(panelModKeluar, BorderLayout.EAST);

        // Menambahkan panel utama ke dalam frame
        getContentPane().add(panelUtama);

        // Melakukan packing frame
        pack();

        // Mengatur defaultCloseOperation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menjadikan frame terlihat
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sumber = e.getSource();

        if (sumber instanceof JTextField) {
            // Menghandle peristiwa kotak teks
        } else if (sumber instanceof JButton) {
            JButton tombol = (JButton) sumber;
            String teks = tombol.getText();

            if (teks.equals("Mod")) {
                // Menghandle peristiwa tombol mod
            } else if (teks.equals("Keluar")) {
                System.exit(0);
            } else {
                // Menghandle peristiwa tombol angka dan operator
                kotakTeks.setText(kotakTeks.getText() + teks);
            }
        }
    }

    public static void main(String[] args) {
        new keyLayout();
    }
}
