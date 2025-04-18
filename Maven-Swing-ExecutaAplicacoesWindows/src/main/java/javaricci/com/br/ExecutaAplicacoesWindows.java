package javaricci.com.br;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class ExecutaAplicacoesWindows extends JFrame {
	private static final long serialVersionUID = 1L;

	private JComboBox<String> comboApps;
    
    public ExecutaAplicacoesWindows() {
        // Configuração básica da janela
        setTitle("Abre Aplicativos Windows, *.JAR, *.EXE");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Criando o ComboBox com as opções
        String[] opcoes = {
            "Selecione um programa:",
            "Calculadora",
            "Excel",
            "Word",
            "Bloco de Notas",
            "Prompt de Comando",
            "PowerPoint",
            "Notepad++",
            "Maven-Swing-CLT.jar",
            "Menu01.exe"
        };
        
        comboApps = new JComboBox<>(opcoes);
        
        // Criando o botão de execução
        JButton btnExecutar = new JButton("Executar");
        btnExecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executarAplicativo();
            }
        });
        
        // Layout da janela
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(comboApps, BorderLayout.CENTER);
        panel.add(btnExecutar, BorderLayout.EAST);
        
        add(panel);
    }
    
    /**
     * Método que executa o aplicativo selecionado no ComboBox
     */
    private void executarAplicativo() {
        String selecionado = (String) comboApps.getSelectedItem();
        
        if (selecionado.equals("Selecione um programa...")) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, selecione um aplicativo.", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            ProcessBuilder pb = null;
            
            switch (selecionado) {
                case "Calculadora":
                    // Calculadora do Windows funciona com o comando simples
                    Runtime.getRuntime().exec("calc");
                    break;
                    
                case "Excel":
                    // Tenta os caminhos comuns do Excel
                    File excel64 = new File("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE");
                    File excel32 = new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE");
                    
                    if (excel64.exists()) {
                        pb = new ProcessBuilder(excel64.getAbsolutePath());
                    } else if (excel32.exists()) {
                        pb = new ProcessBuilder(excel32.getAbsolutePath());
                    } else {
                        // Abre uma caixa de diálogo para o usuário selecionar o Excel
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setDialogTitle("Selecione o Excel (excel.exe)");
                        int result = fileChooser.showOpenDialog(this);
                        
                        if (result == JFileChooser.APPROVE_OPTION) {
                            pb = new ProcessBuilder(fileChooser.getSelectedFile().getAbsolutePath());
                        } else {
                            return;
                        }
                    }
                    break;
                    
                case "Word":
                    // Tenta os caminhos comuns do Word
                    File word64 = new File("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
                    File word32 = new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
                    
                    if (word64.exists()) {
                        pb = new ProcessBuilder(word64.getAbsolutePath());
                    } else if (word32.exists()) {
                        pb = new ProcessBuilder(word32.getAbsolutePath());
                    } else {
                        // Abre uma caixa de diálogo para o usuário selecionar o Word
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setDialogTitle("Selecione o Word (winword.exe)");
                        int result = fileChooser.showOpenDialog(this);
                        
                        if (result == JFileChooser.APPROVE_OPTION) {
                            pb = new ProcessBuilder(fileChooser.getSelectedFile().getAbsolutePath());
                        } else {
                            return;
                        }
                    }
                    break;
                    
                case "Bloco de Notas":
                    // Bloco de notas funciona com o comando simples
                    Runtime.getRuntime().exec("notepad");
                    break;
                    
                case "Prompt de Comando":
                    // Para o prompt de comando, precisamos usar o ProcessBuilder
                    pb = new ProcessBuilder("cmd.exe", "/c", "start", "cmd.exe");
                    break;
                    
                case "PowerPoint":
                    // Tenta os caminhos comuns do PowerPoint
                    File ppt64 = new File("C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE");
                    File ppt32 = new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\POWERPNT.EXE");
                    
                    if (ppt64.exists()) {
                        pb = new ProcessBuilder(ppt64.getAbsolutePath());
                    } else if (ppt32.exists()) {
                        pb = new ProcessBuilder(ppt32.getAbsolutePath());
                    } else {
                        // Abre uma caixa de diálogo para o usuário selecionar o PowerPoint
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setDialogTitle("Selecione o PowerPoint (powerpnt.exe)");
                        int result = fileChooser.showOpenDialog(this);
                        
                        if (result == JFileChooser.APPROVE_OPTION) {
                            pb = new ProcessBuilder(fileChooser.getSelectedFile().getAbsolutePath());
                        } else {
                            return;
                        }
                    }
                    break;
                    
                case "Notepad++":
                    // Tenta os caminhos comuns do Notepad++
                    File notepadPP64 = new File("C:\\Program Files\\Notepad++\\notepad++.exe");
                    File notepadPP32 = new File("C:\\Program Files (x86)\\Notepad++\\notepad++.exe");
                    
                    if (notepadPP64.exists()) {
                        pb = new ProcessBuilder(notepadPP64.getAbsolutePath());
                    } else if (notepadPP32.exists()) {
                        pb = new ProcessBuilder(notepadPP32.getAbsolutePath());
                    } else {
                        // Abre uma caixa de diálogo para o usuário selecionar o Notepad++
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setDialogTitle("Selecione o Notepad++ (notepad++.exe)");
                        int result = fileChooser.showOpenDialog(this);
                        
                        if (result == JFileChooser.APPROVE_OPTION) {
                            pb = new ProcessBuilder(fileChooser.getSelectedFile().getAbsolutePath());
                        } else {
                            return;
                        }
                    }
                    break;
                    
                case "Maven-Swing-CLT.jar":
                    File jarFile = new File("E:\\MeusExecutaveisJava\\JavaSwingDesktop\\Maven-Swing-CLT\\Maven-Swing-CLT.jar");
                    if (jarFile.exists()) {
                        pb = new ProcessBuilder("java", "-jar", jarFile.getAbsolutePath());
                    } else {
                        JOptionPane.showMessageDialog(this, 
                            "Arquivo JAR não encontrado no caminho especificado.", 
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
                    
                case "Menu01.exe":
                    File exeFile = new File("E:\\MeusExecutaveisJava\\Ultimate-C++\\FolhaMenu\\Menu01.exe");
                    if (exeFile.exists()) {
                        pb = new ProcessBuilder(exeFile.getAbsolutePath());
                    } else {
                        JOptionPane.showMessageDialog(this, 
                            "Arquivo EXE não encontrado no caminho especificado.", 
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
            }
            
            // Se o processBuilder foi configurado, inicia o processo
            if (pb != null) {
                pb.start();
            }
            
            JOptionPane.showMessageDialog(this, 
                selecionado + " iniciado com sucesso!", 
                "Sucesso", 
                JOptionPane.INFORMATION_MESSAGE);
                
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao abrir " + selecionado + ": " + ex.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // Executa a aplicação Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExecutaAplicacoesWindows().setVisible(true);
            }
        });
    }
}