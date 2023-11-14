import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // declaração de variáveis
        String nome, email, tel;

        nome = JOptionPane.showInputDialog(null, "Digite o nome do contato: ");
        email = JOptionPane.showInputDialog(null, "Digite o e-mail do contato: ");
        tel = JOptionPane.showInputDialog(null, "Digite o telefone do contato: ");

        // criando o objeto da classe Cliente - utilizando parâmetros
        Cliente cliente = new Cliente(nome, email, tel);
        // criando o objeto da classe Cliente - sem utilizar parâmetros
        Cliente cliente1 = new Cliente();

        // chamando o método obterContatos para mostrar os dados da classe cliente
        JOptionPane.showMessageDialog(null, cliente.obterContatos());
        JOptionPane.showMessageDialog(null, cliente1.obterContatos());





    }
}