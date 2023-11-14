import javax.swing.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // declaração de variáveis
        String nome, email, tel, cpf, rg, logradouro, bairro, cidade, uf, cep;
        BigDecimal limiteCredito;

        nome = JOptionPane.showInputDialog(null, "Nome Contato: ");
        email = JOptionPane.showInputDialog(null, "E-mail: ");
        tel = JOptionPane.showInputDialog(null, "Telefone: ");
        cpf = JOptionPane.showInputDialog(null, "CPF: ");
        rg = JOptionPane.showInputDialog(null, "RG: ");
        logradouro = JOptionPane.showInputDialog(null, "Logradouro: ");
        bairro = JOptionPane.showInputDialog(null, "Bairro: ");
        cidade = JOptionPane.showInputDialog(null, "Cidade: ");
        uf = JOptionPane.showInputDialog(null, "UF: ");
        cep = JOptionPane.showInputDialog(null, "CEP: ");
        limiteCredito = BigDecimal.valueOf(10000);

        // criando o objeto da classe Cliente - utilizando parâmetros
        Cliente cliente = new Cliente(nome, email, tel, cpf, rg, logradouro, bairro, cidade, uf, cep, limiteCredito);
        // criando o objeto da classe Cliente - sem utilizar parâmetros
        Cliente cliente1 = new Cliente();

        // chamando o método obterContatos para mostrar os dados da classe cliente
        JOptionPane.showMessageDialog(null, cliente.obterContatos());
        JOptionPane.showMessageDialog(null, cliente1.obterContatos());

        JOptionPane.showMessageDialog(null, cliente.obterEndereco());
        JOptionPane.showMessageDialog(null, cliente1.obterEndereco());

        JOptionPane.showMessageDialog(null, cliente.obterDocumentos());
        JOptionPane.showMessageDialog(null, cliente1.obterDocumentos());





    }
}