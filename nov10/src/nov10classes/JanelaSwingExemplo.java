package nov10classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaSwingExemplo {
	public static void main(String[] args) {
		// Cria a frame
		JFrame frame = new JFrame("Exemplo de Janela Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerramento da janela leva ao fim do processo da aplicação
		frame.setSize(400, 300);
		
		// GrindLayout com 5 linhas e 1 coluna
		frame.setLayout(new GridLayout(5, 1));
		
		JPanel painelNome = new JPanel(new FlowLayout());
		JLabel labelNome = new JLabel("Nome: ");
		JTextField campoNome = new JTextField(20);
		painelNome.add(labelNome);
		painelNome.add(campoNome);
		
		// Rótulos e campo de entrada para o nome
		JPanel painelSexo = new JPanel(new FlowLayout());
		JLabel labelSexo = new JLabel("Sexo: ");
		JRadioButton masculino = new JRadioButton("Masculino");
		JRadioButton feminino = new JRadioButton("Feminino");
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(masculino);
		grupoSexo.add(feminino);
		painelSexo.add(labelSexo);
		painelSexo.add(masculino);
		painelSexo.add(feminino);
		
		// Painel para as caixas de seleção para hobbies
		JPanel painelHobbies = new JPanel(new FlowLayout());
		JLabel labelHobbies = new JLabel("Hobbies: ");
		JCheckBox leitura = new JCheckBox("Leitura");
		JCheckBox desporto = new JCheckBox("Desporto");
		JCheckBox musica = new JCheckBox("Musica");
		painelHobbies.add(labelHobbies);
		painelHobbies.add(leitura);
		painelHobbies.add(desporto);
		painelHobbies.add(musica);
		
		// Botão de submissão
		JButton botaoSubmeter = new JButton("Button");
		botaoSubmeter.addActionListener(new ActionListener() { // escutar ou monitorar eventos de ação
			@Override // Método está a sobrescrever o método da superclasse
			public void actionPerformed(ActionEvent e) { // Informações sobre o evento que foi disparado
				String nome = campoNome.getText();
				String sexo = masculino.isSelected() ? "Masculino" : feminino.isSelected() ? "Feminino" : "Não especificado";
				StringBuilder hobbies = new StringBuilder();
				if (leitura.isSelected()) hobbies.append("Leitura ");
				if (desporto.isSelected()) hobbies.append("Desporto ");
				if (musica.isSelected()) hobbies.append("Musica ");
				
				JOptionPane.showMessageDialog(frame, "Nome: " + nome + "\nSexo: " + sexo + "\nHobbie: " + (hobbies.length() > 0 ? hobbies.toString() : "Nenhum"));
			}
		});
		
		// Adiciona os painéis e o botão à frame
		frame.add(painelNome);
		frame.add(painelSexo);
		frame.add(painelHobbies);
		frame.add(botaoSubmeter);
		
		// Tornar a frame visível
		frame.setVisible(true);
	}
}
