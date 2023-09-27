package lotofacil;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class LotofacilGUI extends JFrame{
    // Atributos
    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");

    private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");

    private JLabel jLabelSaldo = new JLabel("Saldo: R$ 0,00");

    private double saldo;

    // Construtor
    public LotofacilGUI(){
        this.saldo = saldo;
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400, 300);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));
        jLabelSaldo.setText("Saldo: R$ 0,00");

        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerAposta();
            }
        });

        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerApostaAaZ();
            }
        });

        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerApostaPar();
            }
        });



        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);
        painel.add(jLabelSaldo);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela
    }

    private void fazerAposta() {
        try {
            String aposta = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100");

            int numeroApostado = Integer.parseInt(aposta);

            if (numeroApostado >= 0 && numeroApostado <= 100) {
                Random rnd = new Random();
                int sorteio = rnd.nextInt(101);

                if (numeroApostado == sorteio) {
                    JOptionPane.showMessageDialog(null, "Você ganhou R$ 1000,00 reais.");
                    saldo += 1000;
                    jLabelSaldo.setText("Saldo: R$ " + saldo);
                } else {
                    JOptionPane.showMessageDialog(null, "Você errou");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aposta inválida! Digite um número entre 0 e 100.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número válido de 0 a 100.");
        }
    }


    private void fazerApostaAaZ() {
        Random rnd = new Random();
        // Gere uma letra aleatória de 'A' a 'Z'
        int letra = rnd.nextInt(26) + 65;
        char letraSorteada = (char) letra;

        try {
            // Exiba um diálogo de entrada para o usuário digitar uma letra
            String entrada = JOptionPane.showInputDialog(null, "Digite uma letra de A a Z").toUpperCase();

            if (entrada.length() == 1 && Character.isLetter(entrada.charAt(0))) {
                char apostaLetra = entrada.charAt(0);

                if (apostaLetra == letraSorteada) {
                    JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
                    saldo += 500;
                    jLabelSaldo.setText("Saldo: R$ " + saldo);
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraSorteada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aposta inválida! Digite uma única letra de A a Z.");
            }
        } catch (NullPointerException e) {
            // Trate o caso em que o usuário pressiona "Cancelar" ou fecha o diálogo de entrada
            JOptionPane.showMessageDialog(null, "Aposta cancelada ou sem valor.");
        }
    }

    private void fazerApostaPar() {
            // Exiba um diálogo de entrada para o usuário digitar um número
            String entrada = JOptionPane.showInputDialog(null, "Digite um número inteiro");

            try {
                int numeroDigitado = Integer.parseInt(entrada);

                if (numeroDigitado % 2 == 0) {
                    JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais. O número é par.");
                    saldo += 100;
                    jLabelSaldo.setText("Saldo: R$ " + saldo);
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena! O número é ímpar.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número inteiro.");
            }
        }




    public static void main(String[] args) {
        new LotofacilGUI();}
}
